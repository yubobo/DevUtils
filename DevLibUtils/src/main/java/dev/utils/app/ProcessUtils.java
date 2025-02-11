package dev.utils.app;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: 进程相关工具类
 * @author Ttt
 * <pre>
 *     所需权限
 *     <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS" />
 *     <uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES" />
 * </pre>
 */
public final class ProcessUtils {

    private ProcessUtils() {
    }

    // 日志 TAG
    private static final String TAG = ProcessUtils.class.getSimpleName();

    /**
     * 销毁自身进程
     */
    public static void kill() {
        kill(android.os.Process.myPid());
    }

    /**
     * 销毁进程
     * @param pid 进程 id
     */
    public static void kill(final int pid) {
        android.os.Process.killProcess(pid);
    }

    /**
     * 判断是否当前进程
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isCurProcess() {
        try {
            return DevUtils.getContext().getPackageName().equals(getCurProcessName());
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "isCurProcess");
        }
        return false;
    }

    /**
     * 获取当前进程名
     * @return 进程名
     */
    public static String getCurProcessName() {
        try {
            // 获取自身进程 id
            int pid = android.os.Process.myPid();
            // 判断全部运行中的进程
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getCurProcessName");
        }
        return null;
    }

    /**
     * 获取进程 id 对应的进程名
     * @param pid 进程 id
     * @return 进程名
     */
    public static String getProcessName(final int pid) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = br.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            LogPrintUtils.eTag(TAG, throwable, "getProcessName");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    /**
     * 根据包名获取进程 id
     * @param packageName 应用包名
     * @return 进程 id
     */
    public static int getPid(final String packageName) {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                if (appProcess.processName.equals(packageName)) {
                    return appProcess.pid;
                }
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getPid");
        }
        return 0;
    }

    /**
     * 根据进程 id 获取进程信息
     * @param pid 进程 id
     * @return 进程信息
     */
    public static ActivityManager.RunningAppProcessInfo getRunningAppProcessInfo(final int pid) {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                if (appProcess.pid == pid) {
                    return appProcess;
                }
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getRunningAppProcessInfo");
        }
        return null;
    }

    /**
     * 根据包名获取进程信息
     * @param packageName 应用包名
     * @return 进程信息
     */
    public static ActivityManager.RunningAppProcessInfo getRunningAppProcessInfo(final String packageName) {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                if (appProcess.processName.equals(packageName)) {
                    return appProcess;
                }
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getRunningAppProcessInfo");
        }
        return null;
    }

    // =

    /**
     * 获取前台线程包名
     * @return 前台应用包名
     */
    @RequiresPermission(android.Manifest.permission.PACKAGE_USAGE_STATS)
    public static String getForegroundProcessName() {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) return null;
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            if (lists != null && lists.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                    if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        return appProcess.processName;
                    }
                }
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getForegroundProcessName");
        }
        // SDK 大于 21 时
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.LOLLIPOP) {
            try {
                PackageManager packageManager = DevUtils.getContext().getPackageManager();
                Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                List<ResolveInfo> listResolves = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                // 无权限
                if (listResolves.size() <= 0) {
                    return null;
                }

                UsageStatsManager usageStatsManager = (UsageStatsManager) DevUtils.getContext().getSystemService(Context.USAGE_STATS_SERVICE);
                List<UsageStats> listUsageStats = null;
                if (usageStatsManager != null) {
                    long endTime = System.currentTimeMillis();
                    long beginTime = endTime - 86400000 * 7;
                    listUsageStats = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_BEST, beginTime, endTime);
                }
                if (listUsageStats == null || listUsageStats.isEmpty()) return null;
                UsageStats recentStats = null;
                for (UsageStats usageStats : listUsageStats) {
                    if (recentStats == null || usageStats.getLastTimeUsed() > recentStats.getLastTimeUsed()) {
                        recentStats = usageStats;
                    }
                }
                return recentStats == null ? null : recentStats.getPackageName();
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getForegroundProcessName");
            }
        }
        return null;
    }

    /**
     * 获取后台服务进程
     * @return 后台服务进程
     */
    @RequiresPermission(android.Manifest.permission.KILL_BACKGROUND_PROCESSES)
    public static Set<String> getAllBackgroundProcesses() {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) return Collections.emptySet();
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            Set<String> set = new HashSet<>();
            if (lists != null) {
                for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                    Collections.addAll(set, appProcess.pkgList);
                }
            }
            return set;
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAllBackgroundProcesses");
        }
        return Collections.emptySet();
    }

    /**
     * 杀死所有的后台服务进程
     * @return 被暂时杀死的服务集合
     */
    @RequiresPermission(android.Manifest.permission.KILL_BACKGROUND_PROCESSES)
    public static Set<String> killAllBackgroundProcesses() {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) return Collections.emptySet();
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            Set<String> set = new HashSet<>();
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                for (String packageName : appProcess.pkgList) {
                    activityManager.killBackgroundProcesses(packageName);
                    set.add(packageName);
                }
            }
            lists = activityManager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                for (String packageName : appProcess.pkgList) {
                    set.remove(packageName);
                }
            }
            return set;
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "killAllBackgroundProcesses");
        }
        return null;
    }

    /**
     * 杀死后台服务进程
     * @param packageName 应用包名
     * @return {@code true} success, {@code false} fail
     */
    @RequiresPermission(android.Manifest.permission.KILL_BACKGROUND_PROCESSES)
    public static boolean killBackgroundProcesses(final String packageName) {
        try {
            ActivityManager activityManager = (ActivityManager) DevUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) return false;
            List<ActivityManager.RunningAppProcessInfo> lists = activityManager.getRunningAppProcesses();
            if (lists == null || lists.size() == 0) return true;
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                if (Arrays.asList(appProcess.pkgList).contains(packageName)) {
                    activityManager.killBackgroundProcesses(packageName);
                }
            }
            lists = activityManager.getRunningAppProcesses();
            if (lists == null || lists.size() == 0) return true;
            for (ActivityManager.RunningAppProcessInfo appProcess : lists) {
                if (Arrays.asList(appProcess.pkgList).contains(packageName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "killBackgroundProcesses");
        }
        return false;
    }
}