package dev.utils.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import java.io.File;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: Intent ( 意图 ) 相关工具类
 * @author Ttt
 * <pre>
 *     7.0 及以上安装需要传入清单文件中的 <provider> 的 authorities 属性
 *     @see <a href="https://developer.android.com/reference/android/support/v4/content/FileProvider.html"/>
 *     <p></p>
 *     所需权限
 *     <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
 *     <uses-permission android:name="android.permission.SHUTDOWN" />
 *     <uses-permission android:name="android.permission.CALL_PHONE" />
 * </pre>
 */
public final class IntentUtils {

    private IntentUtils() {
    }

    // 日志 TAG
    private static final String TAG = IntentUtils.class.getSimpleName();

    /**
     * 获取 Intent
     * @param intent    {@link Intent}
     * @param isNewTask 是否开启新的任务栈 (Context 非 Activity 则需要设置 FLAG_ACTIVITY_NEW_TASK)
     * @return {@link Intent}
     */
    public static Intent getIntent(final Intent intent, final boolean isNewTask) {
        if (intent != null) {
            return isNewTask ? intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) : intent;
        }
        return null;
    }

    /**
     * 判断 Intent 是否可用
     * @param intent {@link Intent}
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isIntentAvailable(final Intent intent) {
        if (intent != null) {
            try {
                return DevUtils.getContext().getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0;
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "isIntentAvailable");
            }
        }
        return false;
    }

    /**
     * 获取安装 APP( 支持 8.0) 的意图
     * @param filePath  文件路径
     * @param authority 7.0 及以上安装需要传入清单文件中的 <provider> 的 authorities 属性
     * @return 安装 APP( 支持 8.0) 的意图
     */
    public static Intent getInstallAppIntent(final String filePath, final String authority) {
        return getInstallAppIntent(getFileByPath(filePath), authority);
    }

    /**
     * 获取安装 APP( 支持 8.0) 的意图
     * @param file      文件
     * @param authority 7.0 及以上安装需要传入清单文件中的 <provider> 的 authorities 属性
     * @return 安装 APP( 支持 8.0) 的意图
     */
    public static Intent getInstallAppIntent(final File file, final String authority) {
        return getInstallAppIntent(file, authority, false);
    }

    /**
     * 获取安装 APP( 支持 8.0) 的意图
     * @param file      文件
     * @param authority 7.0 及以上安装需要传入清单文件中的 <provider> 的 authorities 属性
     * @param isNewTask 是否开启新的任务栈
     * @return 安装 APP( 支持 8.0) 的意图
     */
    public static Intent getInstallAppIntent(final File file, final String authority, final boolean isNewTask) {
        if (file == null) return null;
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri data;
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                data = Uri.fromFile(file);
            } else {
                data = FileProvider.getUriForFile(DevUtils.getContext(), authority, file);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            intent.setDataAndType(data, "application/vnd.android.package-archive");
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getInstallAppIntent");
        }
        return null;
    }

    /**
     * 获取卸载 APP 的意图
     * @param packageName 应用包名
     * @return 卸载 APP 的意图
     */
    public static Intent getUninstallAppIntent(final String packageName) {
        return getUninstallAppIntent(packageName, false);
    }

    /**
     * 获取卸载 APP 的意图
     * @param packageName 应用包名
     * @param isNewTask   是否开启新的任务栈
     * @return 卸载 APP 的意图
     */
    public static Intent getUninstallAppIntent(final String packageName, final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + packageName));
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getUninstallAppIntent");
        }
        return null;
    }

    /**
     * 获取打开 APP 的意图
     * @param packageName 应用包名
     * @return 打开 APP 的意图
     */
    public static Intent getLaunchAppIntent(final String packageName) {
        return getLaunchAppIntent(packageName, false);
    }

    /**
     * 获取打开 APP 的意图
     * @param packageName 应用包名
     * @param isNewTask   是否开启新的任务栈
     * @return 打开 APP 的意图
     */
    public static Intent getLaunchAppIntent(final String packageName, final boolean isNewTask) {
        try {
            Intent intent = DevUtils.getContext().getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent == null) return null;
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getLaunchAppIntent");
        }
        return null;
    }

    /**
     * 获取跳转到系统设置的意图
     * @param isNewTask 是否开启新的任务栈
     * @return 跳转到系统设置的意图
     */
    public static Intent getSystemSettingIntent(final boolean isNewTask) {
        try {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getSystemSettingIntent");
        }
        return null;
    }

    /**
     * 获取 APP 具体设置的意图
     * @param packageName 应用包名
     * @return APP 具体设置的意图
     */
    public static Intent getLaunchAppDetailsSettingsIntent(final String packageName) {
        return getLaunchAppDetailsSettingsIntent(packageName, false);
    }

    /**
     * 获取 APP 具体设置的意图
     * @param packageName 应用包名
     * @param isNewTask   是否开启新的任务栈
     * @return APP 具体设置的意图
     */
    public static Intent getLaunchAppDetailsSettingsIntent(final String packageName, final boolean isNewTask) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + packageName));
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getLaunchAppDetailsSettingsIntent");
        }
        return null;
    }

    /**
     * 获取到应用商店 APP 详情界面的意图
     * @param packageName 应用包名
     * @param marketPkg   应用商店包名, 如果为 ""  则由系统弹出应用商店列表供用户选择, 否则调转到目标市场的应用详情界面, 某些应用商店可能会失败
     * @return 到应用商店 APP 详情界面的意图
     */
    public static Intent getLaunchAppDetailIntent(final String packageName, final String marketPkg) {
        return getLaunchAppDetailIntent(packageName, marketPkg, false);
    }

    /**
     * 获取到应用商店 APP 详情界面的意图
     * @param packageName 应用包名
     * @param marketPkg   应用商店包名, 如果为 ""  则由系统弹出应用商店列表供用户选择, 否则调转到目标市场的应用详情界面, 某些应用商店可能会失败
     * @param isNewTask   是否开启新的任务栈
     * @return 到应用商店 APP 详情界面的意图
     */
    public static Intent getLaunchAppDetailIntent(final String packageName, final String marketPkg, final boolean isNewTask) {
        try {
            if (TextUtils.isEmpty(packageName)) return null;

            Uri uri = Uri.parse("market://details?id=" + packageName);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg)) {
                intent.setPackage(marketPkg);
            }
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getLaunchAppDetailIntent");
        }
        return null;
    }

    // =

    /**
     * 获取分享文本的意图
     * @param content 分享文本
     * @return 分享文本的意图
     */
    public static Intent getShareTextIntent(final String content) {
        return getShareTextIntent(content, false);
    }

    /**
     * 获取分享文本的意图
     * @param content   分享文本
     * @param isNewTask 是否开启新的任务栈
     * @return 分享文本的意图
     */
    public static Intent getShareTextIntent(final String content, final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, content);
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getShareTextIntent");
        }
        return null;
    }

    /**
     * 获取分享图片的意图
     * @param content   文本
     * @param imagePath 图片文件路径
     * @return 分享图片的意图
     */
    public static Intent getShareImageIntent(final String content, final String imagePath) {
        return getShareImageIntent(content, imagePath, false);
    }

    /**
     * 获取分享图片的意图
     * @param content   文本
     * @param imagePath 图片文件路径
     * @param isNewTask 是否开启新的任务栈
     * @return 分享图片的意图
     */
    public static Intent getShareImageIntent(final String content, final String imagePath, final boolean isNewTask) {
        try {
            return getShareImageIntent(content, getFileByPath(imagePath), isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getShareImageIntent");
        }
        return null;
    }

    /**
     * 获取分享图片的意图
     * @param content 文本
     * @param image   图片文件
     * @return 分享图片的意图
     */
    public static Intent getShareImageIntent(final String content, final File image) {
        return getShareImageIntent(content, image, false);
    }

    /**
     * 获取分享图片的意图
     * @param content   文本
     * @param image     图片文件
     * @param isNewTask 是否开启新的任务栈
     * @return 分享图片的意图
     */
    public static Intent getShareImageIntent(final String content, final File image, final boolean isNewTask) {
        try {
            return getShareImageIntent(content, Uri.fromFile(image), isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getShareImageIntent");
        }
        return null;
    }

    /**
     * 获取分享图片的意图
     * @param content 分享文本
     * @param uri     图片 uri
     * @return 分享图片的意图
     */
    public static Intent getShareImageIntent(final String content, final Uri uri) {
        return getShareImageIntent(content, uri, false);
    }

    /**
     * 获取分享图片的意图
     * @param content   分享文本
     * @param uri       图片 uri
     * @param isNewTask 是否开启新的任务栈
     * @return 分享图片的意图
     */
    public static Intent getShareImageIntent(final String content, final Uri uri, final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, content);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.setType("image/*");
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getShareImageIntent");
        }
        return null;
    }

    /**
     * 获取其他应用组件的意图
     * @param packageName 应用包名
     * @param className   class.getCanonicalName()
     * @return 其他应用组件的意图
     */
    public static Intent getComponentIntent(final String packageName, final String className) {
        return getComponentIntent(packageName, className, null, false);
    }

    /**
     * 获取其他应用组件的意图
     * @param packageName 应用包名
     * @param className   class.getCanonicalName()
     * @param isNewTask   是否开启新的任务栈
     * @return 其他应用组件的意图
     */
    public static Intent getComponentIntent(final String packageName, final String className, final boolean isNewTask) {
        return getComponentIntent(packageName, className, null, isNewTask);
    }

    /**
     * 获取其他应用组件的意图
     * @param packageName 应用包名
     * @param className   class.getCanonicalName()
     * @param bundle      {@link Bundle}
     * @return 其他应用组件的意图
     */
    public static Intent getComponentIntent(final String packageName, final String className, final Bundle bundle) {
        return getComponentIntent(packageName, className, bundle, false);
    }

    /**
     * 获取其他应用组件的意图
     * @param packageName 应用包名
     * @param className   class.getCanonicalName()
     * @param bundle      {@link Bundle}
     * @param isNewTask   是否开启新的任务栈
     * @return 其他应用组件的意图
     */
    public static Intent getComponentIntent(final String packageName, final String className, final Bundle bundle, final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (bundle != null) intent.putExtras(bundle);
            ComponentName componentName = new ComponentName(packageName, className);
            intent.setComponent(componentName);
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getComponentIntent");
        }
        return null;
    }

    /**
     * 获取关机的意图
     * @return 关机的意图
     */
    public static Intent getShutdownIntent() {
        return getShutdownIntent(false);
    }

    /**
     * 获取关机的意图
     * @param isNewTask 是否开启新的任务栈
     * @return 关机的意图
     */
    public static Intent getShutdownIntent(final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_SHUTDOWN);
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getShutdownIntent");
        }
        return null;
    }

    /**
     * 获取跳至拨号界面意图
     * @param phoneNumber 电话号码
     * @return 跳至拨号界面意图
     */
    public static Intent getDialIntent(final String phoneNumber) {
        return getDialIntent(phoneNumber, false);
    }

    /**
     * 获取跳至拨号界面意图
     * @param phoneNumber 电话号码
     * @param isNewTask   是否开启新的任务栈
     * @return 跳至拨号界面意图
     */
    public static Intent getDialIntent(final String phoneNumber, final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getDialIntent");
        }
        return null;
    }

    /**
     * 获取拨打电话意图
     * @param phoneNumber 电话号码
     * @return 拨打电话意图
     */
    @RequiresPermission(android.Manifest.permission.CALL_PHONE)
    public static Intent getCallIntent(final String phoneNumber) {
        return getCallIntent(phoneNumber, false);
    }

    /**
     * 获取拨打电话意图
     * @param phoneNumber 电话号码
     * @param isNewTask   是否开启新的任务栈
     * @return 拨打电话意图
     */
    @RequiresPermission(android.Manifest.permission.CALL_PHONE)
    public static Intent getCallIntent(final String phoneNumber, final boolean isNewTask) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getCallIntent");
        }
        return null;
    }

    /**
     * 获取发送短信界面的意图
     * @param phoneNumber 接收号码
     * @param content     短信内容
     * @return 发送短信界面的意图
     */
    public static Intent getSendSmsIntent(final String phoneNumber, final String content) {
        return getSendSmsIntent(phoneNumber, content, false);
    }

    /**
     * 获取跳至发送短信界面的意图
     * @param phoneNumber 接收号码
     * @param content     短信内容
     * @param isNewTask   是否开启新的任务栈
     * @return 发送短信界面的意图
     */
    public static Intent getSendSmsIntent(final String phoneNumber, final String content, final boolean isNewTask) {
        try {
            Uri uri = Uri.parse("smsto:" + phoneNumber);
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", content);
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getSendSmsIntent");
        }
        return null;
    }

    /**
     * 获取拍照的意图
     * @param outUri 输出的 uri ( 保存地址 )
     * @return 拍照的意图
     */
    public static Intent getCaptureIntent(final Uri outUri) {
        return getCaptureIntent(outUri, false);
    }

    /**
     * 获取拍照的意图
     * @param outUri    输出的 uri ( 保存地址 )
     * @param isNewTask 是否开启新的任务栈
     * @return 拍照的意图
     */
    public static Intent getCaptureIntent(final Uri outUri, final boolean isNewTask) {
        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outUri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            return getIntent(intent, isNewTask);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getCaptureIntent");
        }
        return null;
    }

    // ======================
    // = 其他工具类实现代码 =
    // ======================

    // =============
    // = FileUtils =
    // =============

    /**
     * 获取文件
     * @param filePath 文件路径
     * @return 文件 {@link File}
     */
    private static File getFileByPath(final String filePath) {
        return filePath != null ? new File(filePath) : null;
    }
}