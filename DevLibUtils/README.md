
## 使用

> ##### 只需要在 Application 中调用 `DevUtils.init()` 进行初始化就行

## 目录结构

```
- dev.utils          | 根目录
   - app             | APP 相关工具类
      - anim         | 动画工具类
      - assist       | 辅助类
         - manager   | 管理器 如: TimerManager
      - cache        | 缓存工具类
      - camera1      | 摄像头相关 android.hardware.Camera
      - image        | 图片相关处理
      - info         | APP 信息、PackageInfo 等
      - logger       | 日志库 DevLogger
      - permission   | 权限工具类
      - player       | 多媒体 ( 视频、音频 ) 播放封装
      - share        | SharedPreferences 封装
      - toast        | Toast
         - toaster   | Toaster 处理无通知权限
      - wifi         | Wifi、热点工具类
   - common          | Java 工具类, 不依赖 android api
      - assist       | 各种快捷辅助类
         - search    | 搜索相关 ( 文件搜索等 )
      - cipher       | 编 / 解码工具类
      - encrypt      | 加密工具类
      - random       | 随机概率算法工具类
      - thread       | 线程相关
      - validator    | 数据校验工具类
```


## 事项

- 内部存在两个日志工具类(工具类内部调用)，对外使用 [DevLogger](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/utils_readme/logger/DevLogger.md)

```java
// 整个工具类内部日志信息, 都通过以下两个工具类输出打印, 并且通过 DevUtils.openLog() 控制开关

// dev.utils.app - APP 打印日志工具类
LogPrintUtils
// dev.utils.common - Java Common 日志打印工具类
JCLogUtils
```

- 需要开启日志，单独调用
```java
// 打开 lib 内部日志 - 线上(release)环境, 不调用方法就行
DevUtils.openLog();
// 标示 debug 模式
DevUtils.openDebug();
```

- 工具类部分模块配置与使用 - [Use and Config](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/utils_readme/USE_CONFIG.md)

- 部分 api 更新不及时或有遗漏等，`具体以对应的工具类为准`

- [JavaDoc - API](https://javadoc.jitpack.io/com/github/afkT/DevUtils/1.7.6/javadoc/)

- [检测代码规范、注释内容排版, API 文档生成](https://github.com/afkT/JavaDoc)

## API


- dev.utils                                           | 根目录
   - [app](#devutilsapp)                              | APP 相关工具类
      - [anim](#devutilsappanim)                      | 动画工具类
      - [assist](#devutilsappassist)                  | 辅助类
         - [manager](#devutilsappassistmanager)       | 管理器 如: TimerManager
      - [cache](#devutilsappcache)                    | 缓存工具类
      - [camera1](#devutilsappcamera1)                | 摄像头相关 android.hardware.Camera
      - [image](#devutilsappimage)                    | 图片相关处理
      - [info](#devutilsappinfo)                      | APP 信息、PackageInfo 等
      - [logger](#devutilsapplogger)                  | 日志库 DevLogger
      - [permission](#devutilsapppermission)          | 权限工具类
      - [player](#devutilsappplayer)                  | 多媒体 ( 视频、音频 ) 播放封装
      - [share](#devutilsappshare)                    | SharedPreferences 封装
      - [toast](#devutilsapptoast)                    | Toast
         - [toaster](#devutilsapptoasttoaster)        | Toaster 处理无通知权限
      - [wifi](#devutilsappwifi)                      | Wifi、热点工具类
   - [common](#devutilscommon)                        | Java 工具类, 不依赖 android api
      - [assist](#devutilscommonassist)               | 各种快捷辅助类
         - [search](#devutilscommonassistsearch)      | 搜索相关 ( 文件搜索等 )
      - [cipher](#devutilscommoncipher)               | 编 / 解码工具类
      - [encrypt](#devutilscommonencrypt)             | 加密工具类
      - [random](#devutilscommonrandom)               | 随机概率算法工具类
      - [thread](#devutilscommonthread)               | 线程相关
      - [validator](#devutilscommonvalidator)         | 数据校验工具类




## <span id="devutilsapp">**`dev.utils.app`**</span>


* **无障碍功能工具类 ->** [AccessibilityUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/AccessibilityUtils.java)

| 方法 | 注释 |
| :- | :- |
| getService | 获取 AccessibilityService 对象 |
| setService | 设置 AccessibilityService 对象 |
| checkAccessibility | 检查是否开启无障碍功能 |
| isAccessibilitySettingsOn | 判断是否开启无障碍功能 |
| printAccessibilityEvent | 打印 AccessibilityEvent 信息日志 |
| findFocus | 查找符合条件的节点 |
| findAccessibilityNodeInfosByText | 查找符合条件的节点 |
| findAccessibilityNodeInfosByViewId | 查找符合条件的节点 |
| performClick | 点击指定的节点 |
| performLongClick | 长按指定的节点 |
| preformActionBack | 触发返回键 |
| preformActionHome | 触发 Home 键 |
| preformActionPowerDialog | 启动长按电源按钮 Dialog |
| preformActionLockScreen | 锁定屏幕 ( 非锁屏 ) |
| preformActionTakeScreenshot | 截屏 |
| preformActionNotifications | 打开通知栏 |
| preformActionRecents | 最近打开应用列表 |
| preformActionQuickSettings | 打开设置 |
| preformActionSplitScreen | 分屏 |
| preformAction | 模拟对应 Action 操作 |
| performGlobalAction | 模拟全局对应 Action 操作 |


* **Activity 工具类 ( 包含 Activity 控制管理 ) ->** [ActivityUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ActivityUtils.java)

| 方法 | 注释 |
| :- | :- |
| getActivity | 通过 Context 获取 Activity |
| isFinishing | 判断 Activity 是否关闭 |
| isActivityExists | 判断是否存在指定的 Activity |
| startHomeActivity | 回到桌面 ( 同点击 Home 键效果 ) |
| getLauncherActivity | 获取 Launcher activity |
| getActivityIcon | 获取 Activity 对应的 icon |
| getActivityLogo | 获取 Activity 对应的 logo |
| getActivityToLauncher | 获取对应包名应用启动的 Activity |
| getLauncherCategoryHomeToResolveInfo | 获取系统桌面信息 |
| getLauncherCategoryHomeToPackageName | 获取系统桌面信息 - packageName |
| getLauncherCategoryHomeToActivityName | 获取系统桌面信息 - activityName |
| getLauncherCategoryHomeToPackageAndName | 获取系统桌面信息 - package/activityName |
| getOptionsBundle | 设置跳转动画 |
| getManager | 获取 ActivityUtils 管理实例 |
| getActivityStacks | 获取 Activity 栈 |
| addActivity | 添加 Activity |
| removeActivity | 移除 Activity |
| currentActivity | 获取最后一个 ( 当前 ) Activity |
| finishActivity | 关闭最后一个 ( 当前 ) Activity |
| existActivitys | 检测是否包含指定的 Activity |
| finishAllActivityToIgnore | 结束全部 Activity 除忽略的 Activity 外 |
| finishAllActivity | 结束所有 Activity |
| appExit | 退出应用程序 |
| restartApplication | 重启 APP |


* **ADB shell 工具类 ->** [ADBUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ADBUtils.java)

| 方法 | 注释 |
| :- | :- |
| isDeviceRooted | 判断设备是否 root |
| requestRoot | 请求 Root 权限 |
| isGrantedRoot | 判断 APP 是否授权 Root 权限 |
| getAppList | 获取 APP 列表 ( 包名 ) |
| getInstallAppList | 获取 APP 安装列表 ( 包名 ) |
| getUserAppList | 获取用户安装的应用列表 ( 包名 ) |
| getSystemAppList | 获取系统应用列表 ( 包名 ) |
| getEnableAppList | 获取启用的应用列表 ( 包名 ) |
| getDisableAppList | 获取禁用的应用列表 ( 包名 ) |
| getAppListToFilter | 获取包名包含字符串 xxx 的应用列表 |
| isInstalledApp | 判断是否安装应用 |
| getAppInstallPath | 查看应用安装路径 |
| clearAppDataCache | 清除应用数据与缓存 - 相当于在设置里的应用信息界面点击了「清除缓存」和「清除数据」 |
| getAppMessage | 查看应用详细信息 |
| getVersionCode | 获取 APP versionCode |
| getVersionName | 获取 APP versionName |
| installApp | 安装应用 |
| installAppSilent | 静默安装应用 |
| uninstallApp | 卸载应用 |
| uninstallAppSilent | 静默卸载应用 |
| getActivityToLauncher | 获取对应包名应用启动的 Activity |
| getWindowCurrent | 获取当前显示的 Window |
| getWindowCurrent2 | 获取当前显示的 Window |
| getWindowCurrentToPackage | 获取对应包名显示的 Window |
| getActivityCurrent | 获取当前显示的 Activity |
| getActivitys | 获取 Activity 栈 |
| getActivitysToPackage | 获取对应包名的 Activity 栈 |
| getActivitysToPackageLists | 获取对应包名的 Activity 栈 ( 处理成 List) - 最新的 Activity 越靠后 |
| isActivityTopRepeat | 判断 Activity 栈顶是否重复 |
| getActivityTopRepeatCount | 获取 Activity 栈顶重复总数 |
| getServices | 查看正在运行的 Services |
| startSelfApp | 启动自身应用 |
| startActivity | 跳转页面 Activity |
| startService | 启动服务 |
| stopService | 停止服务 |
| sendBroadcastToAll | 发送广播 ( 向所有组件发送 ) |
| sendBroadcast | 发送广播 |
| kill | 销毁进程 |
| sendTrimMemory | 收紧内存 |
| tap | 点击某个区域 |
| swipeClick | 按压某个区域 ( 点击 ) |
| swipe | 滑动到某个区域 |
| text | 输入文本 - 不支持中文 |
| keyevent | 触发某些按键 |
| screencap | 屏幕截图 |
| screenrecord | 录制屏幕 ( 以 mp4 格式保存到 /sdcard) |
| wifiConf | 查看连接过的 Wifi 密码 |
| wifiSwitch | 开启 / 关闭 Wifi |
| setSystemTime | 设置系统时间 |
| setSystemTime2 | 设置系统时间 |
| shutdown | 关机 ( 需要 root 权限 ) |
| reboot | 重启设备 ( 需要 root 权限 ) |
| rebootToRecovery | 重启引导到 recovery ( 需要 root 权限 ) |
| rebootToBootloader | 重启引导到 bootloader ( 需要 root 权限 ) |
| sendEventSlide | 发送事件滑动 |
| getSDKVersion | 获取 SDK 版本 |
| getAndroidVersion | 获取 Android 系统版本 |
| getModel | 获取设备型号 - 如 RedmiNote4X |
| getBrand | 获取设备品牌 |
| getDeviceName | 获取设备名 |
| getCpuAbiList | 获取 CPU 支持的 abi 列表 |
| getAppHeapsize | 获取每个应用程序的内存上限 |
| getBattery | 获取电池状况 |
| getDensity | 获取屏幕密度 |
| getScreenSize | 获取屏幕分辨率 |
| getDisplays | 获取显示屏参数 |
| getAndroidId | 获取 Android id |
| getIMEI | 获取 IMEI 码 |
| getIPAddress | 获取 IP 地址 |
| getMac | 获取 Mac 地址 |
| getCPU | 获取 CPU 信息 |
| getMeminfo | 获取内存信息 |
| setScreenSize | 设置屏幕大小 |
| resetScreen | 恢复原分辨率命令 |
| setDensity | 设置屏幕密度 |
| resetDensity | 恢复原屏幕密度 |
| setOverscan | 显示区域 ( 设置留白边距 ) |
| resetOverscan | 恢复原显示区域 |
| getScreenBrightnessMode | 获取亮度是否为自动获取 ( 自动调节亮度 ) |
| setScreenBrightnessMode | 设置亮度是否为自动获取 ( 自动调节亮度 ) |
| getScreenBrightness | 获取屏幕亮度值 |
| setScreenBrightness | 更改屏幕亮度值 ( 亮度值在 0-255 之间 ) |
| getScreenOffTimeout | 获取自动锁屏休眠时间 ( 单位毫秒 ) |
| setScreenOffTimeout | 设置自动锁屏休眠时间 ( 单位毫秒 ) |
| getGlobalAutoTime | 获取日期时间选项中通过网络获取时间的状态 |
| setGlobalAutoTime | 修改日期时间选项中通过网络获取时间的状态, 设置是否开启 |
| disableADB | 关闭 USB 调试模式 |
| putHiddenApi | 允许访问非 SDK API |
| deleteHiddenApi | 禁止访问非 SDK API |
| openAccessibility | 开启无障碍辅助功能 |
| closeAccessibility | 关闭无障碍辅助功能 |


* **AlarmManager( 全局定时器、闹钟 ) 工具类 ->** [AlarmUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/AlarmUtils.java)

| 方法 | 注释 |
| :- | :- |
| startAlarmIntent | 开启一次性闹钟 |
| stopAlarmIntent | 关闭闹钟 |
| startAlarmService | 开启 Service 闹钟 |
| stopAlarmService | 关闭 Service 闹钟 |
| startAlarmForegroundService | 开启 ForegroundService 闹钟 |
| stopAlarmForegroundService | 关闭 ForegroundService 闹钟 |
| startAlarmBroadcast | 开启 Receiver 闹钟 |
| stopAlarmBroadcast | 关闭 Receiver 闹钟 |
| startAlarmActivity | 开启 Activity 闹钟 |
| stopAlarmActivity | 关闭 Activity 闹钟 |


* **日志记录分析工具类 ->** [AnalysisRecordUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/AnalysisRecordUtils.java)

| 方法 | 注释 |
| :- | :- |
| init | 初始化操作 ( 内部已调用 ) |
| record | 日志记录 |
| isHandler | 判断是否处理日志记录 |
| setHandler | 设置是否处理日志记录 |
| isAppendSpace | 判断是否追加空格 |
| setAppendSpace | 设置是否追加空格 |
| getLogFolderName | 获取日志文件名 |
| setLogFolderName | 设置日志文件夹名 |
| getLogStoragePath | 获取日志存储路径 |
| setLogStoragePath | 设置日志存储路径 |
| obtain | 获取日志记录分析文件对象 |
| getStoragePath | 获取存储路径 |
| getFileName | 获取日志文件名 |
| getFileFunction | 获取日志文件记录功能 |
| getFileIntervalTime | 获取日志文件记录间隔时间 |
| getFolderName | 获取日志文件夹名 |
| getLogPath | 获取日志文件地址 |
| getIntervalTimeFolder | 获取时间间隔所属的文件夹 |


* **APP 通用工具类 ->** [AppCommonUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/AppCommonUtils.java)

| 方法 | 注释 |
| :- | :- |
| getUUID | 获取设备唯一 UUID |
| getFormatRes | 获取 R.string 资源的格式化字符串 |
| getSDKVersion | 获取 SDK 版本 |
| isFroyo | 是否在 2.2 版本及以上 |
| isGingerbread | 是否在 2.3 版本及以上 |
| isGingerbreadMR1 | 是否在 2.3.3 版本及以上 |
| isHoneycomb | 是否在 3.0 版本及以上 |
| isHoneycombMR1 | 是否在 3.1 版本及以上 |
| isIceCreamSandwich | 是否在 4.0 版本及以上 |
| isIceCreamSandwichMR1 | 是否在 4.0.3 版本及以上 |
| isJellyBean | 是否在 4.1 版本及以上 |
| isJellyBeanMR1 | 是否在 4.2 版本及以上 |
| isJellyBeanMR2 | 是否在 4.3 版本及以上 |
| isKitkat | 是否在 4.4.2 版本及以上 |
| isLollipop | 是否在 5.0.1 版本及以上 |
| isM | 是否在 6.0 版本及以上 |
| isN | 是否在 7.0 版本及以上 |
| isN_MR1 | 是否在 7.1.1 版本及以上 |
| isO | 是否在 8.0 版本及以上 |
| isO_MR1 | 是否在 8.1 版本及以上 |
| isP | 是否在 9.0 版本及以上 |
| convertSDKVersion | 转换 SDK 版本 convertSDKVersion(14) => Android 4.0.0-2 |


* **APP (Android) 工具类 ->** [AppUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/AppUtils.java)

| 方法 | 注释 |
| :- | :- |
| getWindowManager | 获取 WindowManager |
| getSystemService | 获取 SystemService |
| getPackageManager | 获取 PackageManager |
| getAppPackageName | 获取 APP 包名 |
| getAppIcon | 获取 APP 图标 |
| getAppName | 获取 APP 应用名 |
| getAppVersionName | 获取 APP versionName |
| getAppVersionCode | 获取 APP versionCode |
| getAppPath | 获取 APP 安装包路径 /data/data/packageName/.apk |
| getAppSignature | 获取 APP Signature |
| getAppSignatureMD5 | 获取 APP 签名 MD5 值 |
| getAppSignatureSHA1 | 获取 APP 签名 SHA1 值 |
| getAppSignatureSHA256 | 获取 APP 签名 SHA256 值 |
| isAppDebug | 判断 APP 是否 debug 模式 |
| isAppRelease | 判断 APP 是否 release 模式 |
| isAppSystem | 判断 APP 是否系统 app |
| isAppForeground | 判断 APP 是否在前台 |
| isInstalledApp | 判断是否安装了 APP |
| isInstalledApp2 | 判断是否安装了 APP |
| installApp | 安装 APP( 支持 8.0) 的意图 |
| installAppSilent | 静默安装应用 |
| uninstallApp | 卸载应用 |
| uninstallAppSilent | 静默卸载应用 |
| launchApp | 打开 APP |
| launchAppDetailsSettings | 跳转到 APP 设置详情页面 |
| launchAppDetails | 跳转到 APP 应用商城详情页面 |
| openFile | 打开文件 |
| openFileByApp | 打开文件 - 指定应用 |
| openPDFFile | 打开 PDF 文件 |
| openWordFile | 打开 Word 文件 |
| openOfficeByWPS | 调用 WPS 打开 office 文档 |
| startSysSetting | 跳转到系统设置页面 |
| openWirelessSettings | 打开网络设置界面 |
| openGpsSettings | 打开 GPS 设置界面 |


* **音频管理工具类 ->** [AudioManagerUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/AudioManagerUtils.java)

| 方法 | 注释 |
| :- | :- |
| getAudioManager | 获取 AudioManager |
| getStreamMaxVolume | 获取指定声音流最大音量大小 |
| getStreamVolume | 获取指定声音流音量大小 |
| setStreamVolume | 设置指定声音流音量大小 |
| adjustVolumeLower | 控制手机音量, 调小一个单位 |
| adjustVolumeRaise | 控制手机音量, 调大一个单位 |
| adjustVolume | 控制手机音量, 调大或者调小一个单位 |
| adjustStreamVolumeLower | 控制指定声音流音量, 调小一个单位 |
| adjustStreamVolumeRaise | 控制指定声音流音量, 调大一个单位 |
| adjustStreamVolume | 控制指定声音流音量, 调大或者调小一个单位 |
| setStreamMuteByMusic | 设置媒体声音静音状态 |
| setStreamMuteByVoiceCall | 设置通话声音静音状态 |
| setStreamMuteBySystem | 设置系统声音静音状态 |
| setStreamMuteByRing | 设置来电响铃静音状态 |
| setStreamMuteByAlarm | 设置闹钟声音静音状态 |
| setStreamMuteByNotification | 设置通知声音静音状态 |
| setStreamMute | 设置指定声音流静音状态 |
| getMode | 获取当前的音频模式 |
| setMode | 设置当前的音频模式 |
| getRingerMode | 获取当前的铃声模式 |
| setRingerMode | 获取当前的铃声模式 |
| ringerSilent | 设置静音模式 ( 静音, 且无振动 ) |
| ringerVibrate | 设置震动模式 ( 静音, 但有振动 ) |
| ringerNormal | 设置正常模式 ( 正常声音, 振动开关由 setVibrateSetting 决定 ) |
| isDoNotDisturb | 判断是否授权 Do not disturb 权限 |
| setSpeakerphoneOn | 设置是否打开扩音器 ( 扬声器 ) |
| setMicrophoneMute | 设置是否让麦克风静音 |
| isSpeakerphoneOn | 判断是否打开扩音器 ( 扬声器 ) |
| isMicrophoneMute | 判断麦克风是否静音 |
| isMusicActive | 判断是否有音乐处于活跃状态 |
| isWiredHeadsetOn | 判断是否插入了耳机 |
| isBluetoothA2dpOn | 检查蓝牙 A2DP 音频外设是否已连接 |
| isBluetoothScoAvailableOffCall | 检查当前平台是否支持使用 SCO 的关闭调用用例 |
| isBluetoothScoOn | 检查通信是否使用蓝牙 SCO |
| setBluetoothScoOn | 设置是否使用蓝牙 SCO 耳机进行通讯 |
| startBluetoothSco | 启动蓝牙 SCO 音频连接 |
| stopBluetoothSco | 停止蓝牙 SCO 音频连接 |
| loadSoundEffects | 加载音效 |
| unloadSoundEffects | 卸载音效 |
| playSoundEffect | 播放音效 |
| abandonAudioFocus | 放弃音频焦点, 使上一个焦点所有者 ( 如果有 ) 接收焦点 |
| adjustSuggestedStreamVolume | 调整最相关的流的音量, 或者给定的回退流 |
| getParameters | 获取音频硬件指定 key 的参数值 |
| getVibrateSetting | 获取用户对振动类型的振动设置 |


* **状态栏相关工具类 ->** [BarUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/BarUtils.java)

| 方法 | 注释 |
| :- | :- |
| getStatusBarHeight | 获取状态栏高度 |
| setStatusBarVisibility | 设置状态栏是否显示 |
| isStatusBarVisible | 判断状态栏是否显示 |
| setStatusBarLightMode | 设置状态是否高亮模式 |
| addMarginTopEqualStatusBarHeight | 添加状态栏同等高度到 View 的顶部 |
| subtractMarginTopEqualStatusBarHeight | 添加状态栏同等高度到 View 的顶部 |
| setStatusBarColor | 设置状态栏颜色 |
| setStatusBarAlpha | 设置状态栏透明度 |
| setStatusBarCustom | 设置自定义状态栏 |
| setStatusBarColor4Drawer | 设置状态栏的颜色 |
| setStatusBarAlpha4Drawer | 设置状态栏透明度 |
| getActionBarHeight | 获取 ActionBase 高度 |
| setNotificationBarVisibility | 设置通知栏是否显示 |
| getNavBarHeight | 获取 NavigationView 高度 |
| setNavBarVisibility | 设置导航栏是否可见 ( 图标显示 ) |
| isNavBarVisible | 判断导航栏是否可见 |
| setNavBarColor | 设置导航栏颜色 |
| getNavBarColor | 设置导航栏颜色 |
| isSupportNavBar | 判断是否支持导航栏 |


* **亮度相关工具类 ->** [BrightnessUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/BrightnessUtils.java)

| 方法 | 注释 |
| :- | :- |
| isAutoBrightnessEnabled | 判断是否开启自动调节亮度 |
| setAutoBrightnessEnabled | 设置是否开启自动调节亮度 |
| getBrightness | 获取屏幕亮度 0-255 |
| setBrightness | 设置屏幕亮度 |
| setWindowBrightness | 设置窗口亮度 |
| getWindowBrightness | 获取窗口亮度 |


* **本应用数据清除管理工具类 ->** [CleanUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/CleanUtils.java)

| 方法 | 注释 |
| :- | :- |
| cleanInternalCache | 清除内部缓存 - path /data/data/package/cache |
| cleanInternalFiles | 清除内部文件 - path /data/data/package/files |
| cleanInternalDbs | 清除内部数据库 - path /data/data/package/databases |
| cleanInternalDbByName | 根据名称清除数据库 - path /data/data/package/databases/dbName |
| cleanInternalSp | 清除内部 SP - path /data/data/package/shared_prefs |
| cleanExternalCache | 清除外部缓存 - path /storage/emulated/0/android/data/package/cache |
| cleanCustomDir | 清除自定义路径下的文件, 使用需小心请不要误删, 而且只支持目录下的文件删除 |
| cleanApplicationData | 清除本应用所有的数据 |


* **点击 ( 双击 ) 工具类 ->** [ClickUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ClickUtils.java)

| 方法 | 注释 |
| :- | :- |
| addTouchArea | 增加控件的触摸范围, 最大范围只能是父布局所包含的的区域 |
| get | 获取对应功能模块点击辅助类 |
| remove | 移除对应功能模块点击辅助类 |
| isFastDoubleClick | 判断是否双击 ( 无效点击 - 短时间内多次点击 ) |
| initConfig | 初始化配置信息 |
| putConfig | 添加配置信息 |
| removeConfig | 移除配置信息 |
| getConfigTime | 获取配置时间 |
| removeRecord | 移除点击记录 |
| clearRecord | 清空全部点击记录 |
| setIntervalTime | 设置默认点击时间间隔 |
| reset | 重置处理 |


* **剪贴板相关工具类 ->** [ClipboardUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ClipboardUtils.java)

| 方法 | 注释 |
| :- | :- |
| copyText | 复制文本到剪贴板 |
| getText | 获取剪贴板文本 |
| copyUri | 复制 URI 到剪贴板 |
| getUri | 获取剪贴板 URI |
| copyIntent | 复制意图到剪贴板 |
| getIntent | 获取剪贴板意图 |


* **ContentResolver 工具类 ->** [ContentResolverUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ContentResolverUtils.java)

| 方法 | 注释 |
| :- | :- |
| notifyMediaStore | 通知刷新本地资源 |
| insertImageIntoMediaStore | 添加图片到系统相册 ( 包含原图、相册图, 会存在两张 ) - 想要一张, 直接调用 notifyMediaStore() |
| insertVideoIntoMediaStore | 添加视频到系统相册 |
| insertIntoMediaStore | 保存到系统相册 |


* **获取 CPU 信息工具类 ->** [CPUUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/CPUUtils.java)

| 方法 | 注释 |
| :- | :- |
| getProcessorsCount | 获取处理器的 Java 虚拟机的数量 |
| getSysCPUSerialNum | 获取手机 CPU 序列号 |
| getCpuInfo | 获取 CPU 信息 |
| getCpuModel | 获取 CPU 型号 |
| getMaxCpuFreq | 获取 CPU 最大频率 ( 单位 KHZ) |
| getMinCpuFreq | 获取 CPU 最小频率 ( 单位 KHZ) |
| getCurCpuFreq | 获取 CPU 当前频率 ( 单位 KHZ) |
| getCoresNumbers | 获取 CPU 核心数 |
| getCpuName | 获取 CPU 名字 |
| getCMDOutputString | 获取 CMD 指令回调数据 |


* **数据库工具类 ( 导入导出等 ) ->** [DBUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/DBUtils.java)

| 方法 | 注释 |
| :- | :- |
| startExportDatabase | 导出数据库 |
| startImportDatabase | 导入数据库 |
| getDBPath | 获取数据库路径 |


* **设备相关工具类 ->** [DeviceUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/DeviceUtils.java)

| 方法 | 注释 |
| :- | :- |
| getDeviceInfo | 获取设备信息 |
| handlerDeviceInfo | 处理设备信息 |
| getBoard | 获取设备基板名称 |
| getBootloader | 获取设备引导程序版本号 |
| getBrand | 获取设备品牌 |
| getCPU_ABI | 获取支持的第一个指令集 |
| getCPU_ABI2 | 获取支持的第二个指令集 |
| getABIs | 获取支持的指令集 如: [arm64-v8a, armeabi-v7a, armeabi] |
| getSUPPORTED_32_BIT_ABIS | 获取支持的 32 位指令集 |
| getSUPPORTED_64_BIT_ABIS | 获取支持的 64 位指令集 |
| getDevice | 获取设备驱动名称 |
| getDisplay | 获取设备显示的版本包 ( 在系统设置中显示为版本号 ) 和 ID 一样 |
| getFingerprint | 获取设备的唯一标识, 由设备的多个信息拼接合成 |
| getHardware | 获取设备硬件名称, 一般和基板名称一样 (BOARD) |
| getHost | 获取设备主机地址 |
| getID | 获取设备版本号 |
| getModel | 获取设备型号 如 RedmiNote4X |
| getManufacturer | 获取设备厂商 如 Xiaomi |
| getProduct | 获取整个产品的名称 |
| getRadio | 获取无线电固件版本号, 通常是不可用的 显示 unknown |
| getTags | 获取设备标签, 如 release-keys 或测试的 test-keys |
| getTime | 获取设备时间 |
| getType | 获取设备版本类型 主要为 "user" 或 "eng". |
| getUser | 获取设备用户名 基本上都为 android-build |
| getSDKVersion | 获取 SDK 版本号 |
| getRelease | 获取系统版本号, 如 4.1.2 或 2.2 或 2.3 等 |
| getCodename | 获取设备当前的系统开发代号, 一般使用 REL 代替 |
| getIncremental | 获取系统源代码控制值, 一个数字或者 git hash 值 |
| getAndroidId | 获取 Android id |
| getBaseband_Ver | 获取基带版本 BASEBAND-VER |
| getLinuxCore_Ver | 获取内核版本 CORE-VER |
| isDeviceRooted | 判断设备是否 root |
| isAdbEnabled | 获取是否启用 ADB |
| getMacAddress | 获取设备 MAC 地址 |
| shutdown | 关机 ( 需要 root 权限 ) |
| reboot | 重启设备 ( 需要 root 权限 ) |
| rebootToRecovery | 重启引导到 recovery ( 需要 root 权限 ) |
| rebootToBootloader | 重启引导到 bootloader ( 需要 root 权限 ) |


* **Dialog 操作相关工具类 ->** [DialogUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/DialogUtils.java)

| 方法 | 注释 |
| :- | :- |
| getWindow | 获取 Dialog Window |
| getAttributes | 获取 Dialog Window LayoutParams |
| setAttributes | 设置 Dialog Window LayoutParams |
| setWidth | 设置 Dialog 宽度 |
| setHeight | 设置 Dialog 高度 |
| setWidthHeight | 设置 Dialog 宽度、高度 |
| setX | 设置 Dialog X 轴坐标 |
| setY | 设置 Dialog Y 轴坐标 |
| setXY | 设置 Dialog X、Y 轴坐标 |
| setGravity | 设置 Dialog Gravity |
| setDimAmount | 设置 Dialog 透明度 |
| setCancelable | 设置是否允许返回键关闭 |
| setCanceledOnTouchOutside | 设置是否允许点击其他地方自动关闭 |
| setCancelableAndTouchOutside | 设置是否允许 返回键关闭、点击其他地方自动关闭 |
| showDialog | 显示 Dialog |
| closeDialog | 关闭 Dialog |
| closeDialogs | 关闭多个 Dialog |
| closePopupWindow | 关闭 PopupWindow |
| closePopupWindows | 关闭多个 PopupWindow |
| createAlertDialog | 创建提示 Dialog ( 原生样式 ) |
| createProgressDialog | 创建加载中 Dialog ( 原生样式 ) |
| autoCloseDialog | 自动关闭 dialog |
| autoClosePopupWindow | 自动关闭 PopupWindow |
| createSingleChoiceListDialog | 创建单选列表样式 Dialog |
| createSingleChoiceDialog | 创建单选样式 Dialog |
| createMultiChoiceDialog | 创建多选样式 Dialog |
| createViewDialog | 创建自定义 View 样式 Dialog |


* **EditText 工具类 ->** [EditTextUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/EditTextUtils.java)

| 方法 | 注释 |
| :- | :- |
| getEditText | 获取 EditText |
| getText | 获取输入的内容 |
| getTextLength | 获取输入的内容长度 |
| setText | 设置内容 |
| insert | 追加内容 ( 当前光标位置追加 ) |
| setMaxLength | 设置长度限制 |
| setMaxLengthAndText | 设置长度限制, 并且设置内容 |
| setCursorVisible | 设置是否显示光标 |
| getSelectionStart | 获取光标位置 |
| setSelectionToTop | 设置光标在第一位 |
| setSelectionToBottom | 设置光标在最后一位 |
| setSelection | 设置光标位置 |
| setKeyListener | 设置 KeyListener |
| getLettersKeyListener | 获取 DigitsKeyListener ( 限制只能输入字母, 默认弹出英文输入法 ) |
| getNumberAndLettersKeyListener | 获取 DigitsKeyListener ( 限制只能输入字母和数字, 默认弹出英文输入法 ) |
| getNumberKeyListener | 获取 DigitsKeyListener ( 限制只能输入数字, 默认弹出数字列表 ) |
| createDigitsKeyListener | 创建 DigitsKeyListener |


* **文件记录工具类 ->** [FileRecordUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/FileRecordUtils.java)

| 方法 | 注释 |
| :- | :- |
| init | 初始化调用方法 ( 内部已调用 ) |
| saveErrorLog | 保存异常日志 |
| saveLog | 保存日志 |


* **手电筒工具类 ->** [FlashlightUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/FlashlightUtils.java)

| 方法 | 注释 |
| :- | :- |
| getInstance | 获取 FlashlightUtils 实例 |
| register | 注册摄像头 |
| unregister | 注销摄像头 |
| setFlashlightOn | 打开闪光灯 |
| setFlashlightOff | 关闭闪光灯 |
| isFlashlightOn | 是否打开闪光灯 |
| isFlashlightEnable | 是否支持手机闪光灯 |


* **Handler 工具类 ( 默认开启一个 Handler, 方便在各个地方随时执行主线程任务 ) ->** [HandlerUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/HandlerUtils.java)

| 方法 | 注释 |
| :- | :- |
| getMainHandler | 获取主线程 Handler |
| postRunnable | 在主线程 Handler 中执行任务 |
| removeRunnable | 在主线程 Handler 中清除任务 |


* **Html 工具类 ->** [HtmlUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/HtmlUtils.java)

| 方法 | 注释 |
| :- | :- |
| setHtmlText | 设置 Html 内容 |
| addHtmlColor | 为给定的字符串添加 HTML 颜色标记 |
| addHtmlBold | 为给定的字符串添加 HTML 加粗标记 |
| addHtmlColorAndBlod | 为给定的字符串添加 HTML 颜色标记并加粗 |
| addHtmlUnderline | 为给定的字符串添加 HTML 下划线 |
| addHtmlIncline | 为给定的字符串添加 HTML 字体倾斜 |
| keywordReplaceHtmlColor | 将给定的字符串中所有给定的关键字标色 |


* **ImageView 工具类 ->** [ImageViewUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ImageViewUtils.java)

| 方法 | 注释 |
| :- | :- |
| getImageView | 获取 ImageView |
| setBackground | 设置背景图片 |
| setBackgroundColor | 设置背景颜色 |
| setBackgroundResource | 设置背景资源 |
| setBackgroundTintList | 设置背景着色颜色 |
| setBackgroundTintMode | 设置背景着色模式 |
| setForeground | 设置前景图片 |
| setForegroundGravity | 设置前景重心 |
| setForegroundTintList | 设置前景着色颜色 |
| setForegroundTintMode | 设置前景着色模式 |
| setImageBitmap | 设置 ImageView Bitmap |
| setImageDrawable | 设置 ImageView Drawable |
| setImageResource | 设置 ImageView 资源 |
| setImageMatrix | 设置 ImageView Matrix |
| setImageTintList | 设置 ImageView 着色颜色 |
| setImageTintMode | 设置 ImageView 着色模式 |
| setScaleType | 设置 ImageView 缩放类型 |
| getBackground | 获取 View 背景 Drawable |
| getBackgroundTintList | 获取 View 背景着色颜色 |
| getBackgroundTintMode | 获取 View 背景着色模式 |
| getForeground | 获取 View 前景 Drawable |
| getForegroundGravity | 获取 View 前景重心 |
| getForegroundTintList | 获取 View 前景着色颜色 |
| getForegroundTintMode | 获取 View 前景着色模式 |
| getImageMatrix | 获取 ImageView Matrix |
| getImageTintList | 获取 ImageView 着色颜色 |
| getImageTintMode | 获取 ImageView 着色模式 |
| getScaleType | 获取 ImageView 缩放模式 |
| getDrawable | 获取 ImageView Drawable |
| setColorFilter | ImageView 着色处理 |
| setImageResources | 设置 View 图片资源 |
| setImageBitmaps | 设置 View Bitmap |
| setImageDrawables | 设置 View Drawable |
| setScaleTypes | 设置 View 缩放模式 |
| getImageViewSize | 根据 ImageView 获适当的宽高 |


* **Intent ( 意图 ) 相关工具类 ->** [IntentUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/IntentUtils.java)

| 方法 | 注释 |
| :- | :- |
| getIntent | 获取 Intent |
| isIntentAvailable | 判断 Intent 是否可用 |
| getInstallAppIntent | 获取安装 APP( 支持 8.0) 的意图 |
| getUninstallAppIntent | 获取卸载 APP 的意图 |
| getLaunchAppIntent | 获取打开 APP 的意图 |
| getSystemSettingIntent | 获取跳转到系统设置的意图 |
| getLaunchAppDetailsSettingsIntent | 获取 APP 具体设置的意图 |
| getLaunchAppDetailIntent | 获取到应用商店 APP 详情界面的意图 |
| getShareTextIntent | 获取分享文本的意图 |
| getShareImageIntent | 获取分享图片的意图 |
| getComponentIntent | 获取其他应用组件的意图 |
| getShutdownIntent | 获取关机的意图 |
| getDialIntent | 获取跳至拨号界面意图 |
| getCallIntent | 获取拨打电话意图 |
| getSendSmsIntent | 获取发送短信界面的意图 |
| getCaptureIntent | 获取拍照的意图 |


* **Android 原生 JSONObject 工具类 ->** [JSONObjectUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/JSONObjectUtils.java)

| 方法 | 注释 |
| :- | :- |
| toJson | 转换为 JSON 格式字符串 |
| fromJson | Object 转换 JSON 对象 |
| wrap | 包装转换 Object - {@link JSONObject#wrap(Object)} |
| stringJSONEscape | 字符串 JSON 转义处理 |


* **软键盘相关辅助类 ->** [KeyBoardUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/KeyBoardUtils.java)

| 方法 | 注释 |
| :- | :- |
| setDelayMillis | 设置延迟时间 |
| openKeyboard | 打开软键盘 |
| closeKeyboard | 关闭软键盘 |
| closeKeyBoardSpecial | 关闭软键盘 - 特殊处理 |
| toggleKeyboard | 自动切换键盘状态, 如果键盘显示了则隐藏, 隐藏着显示 |
| judgeView | 设置某个 View 内所有非 EditText 的子 View OnTouchListener 事件 |
| isSoftInputVisible | 判断软键盘是否可见 |
| registerSoftInputChangedListener | 注册软键盘改变监听 |
| registerSoftInputChangedListener2 | 注册软键盘改变监听 |
| fixSoftInputLeaks | 修复软键盘内存泄漏 在 Activity.onDestroy() 中使用 |


* **锁屏管理工具类 ( 锁屏、禁用锁屏, 判断是否锁屏 ) ->** [KeyguardUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/KeyguardUtils.java)

| 方法 | 注释 |
| :- | :- |
| getInstance | 获取 KeyguardUtils 实例 |
| isKeyguardLocked | 是否锁屏 - android 4.1 以上支持 |
| isKeyguardSecure | 是否有锁屏密码 - android 4.1 以上支持 |
| inKeyguardRestrictedInputMode | 是否锁屏 |
| getKeyguardManager | 获取 KeyguardManager |
| setKeyguardManager | 设置 KeyguardManager |
| disableKeyguard | 屏蔽系统的屏保 |
| reenableKeyguard | 使能显示锁屏界面, 如果你之前调用了 disableKeyguard() 方法取消锁屏界面, 那么会马上显示锁屏界面 |
| release | 释放资源 |
| getKeyguardLock | 获取 KeyguardManager.KeyguardLock |
| setKeyguardLock | 设置 KeyguardManager.KeyguardLock |


* **语言工具类 ->** [LanguageUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/LanguageUtils.java)

| 方法 | 注释 |
| :- | :- |
| getSystemLanguage | 获取系统语言 |
| getSystemPreferredLanguage | 获取系统首选语言 |
| applyLanguage | 修改系统语言 (APP 多语言, 单独改变 APP 语言 ) |
| getSupportLanguages | 获取支持的语言 |
| putSupportLanguage | 添加支持的语言 |
| removeSupportLanguage | 移除支持的语言 |
| isSupportLanguage | 是否支持此语言 |
| getSupportLanguage | 获取支持语言 |


* **事件工具类 ->** [ListenerUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ListenerUtils.java)

| 方法 | 注释 |
| :- | :- |
| getTouchListener | 获取 View 设置的 OnTouchListener 事件对象 |
| getListenerInfo | 获取 View ListenerInfo 对象 ( 内部类 ) |
| getListenerInfoListener | 获取 View ListenerInfo 对象内部事件对象 |
| setOnClicks | 设置点击事件 |


* **定位相关工具类 ->** [LocationUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/LocationUtils.java)

| 方法 | 注释 |
| :- | :- |
| getLocation | 获取位置, 需要先判断是否开启了定位 |
| isGpsEnabled | 判断 GPS 是否可用 |
| isLocationEnabled | 判断定位是否可用 |
| openGpsSettings | 打开 GPS 设置界面 |
| register | 注册 - 使用完记得调用 {@link #unregister()} |
| unregister | 注销监听 |
| getAddress | 根据经纬度获取地理位置 |
| getCountryName | 根据经纬度获取所在国家 |
| getLocality | 根据经纬度获取所在地 |
| getStreet | 根据经纬度获取所在街道 |
| isBetterLocation | 判断是否更好的位置 |
| isSameProvider | 是否相同的提供者 |
| getLastKnownLocation | 获取最后一次保留的坐标 |
| onLocationChanged | 当坐标改变时触发此函数, 如果 Provider 传进相同的坐标, 它就不会被触发 |
| onStatusChanged | provider 的在可用、暂时不可用和无服务三个状态直接切换时触发此函数 |


* **Android Manifest 工具类 ->** [ManifestUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ManifestUtils.java)

| 方法 | 注释 |
| :- | :- |
| getMetaData | 获取 Application meta Data |
| getMetaDataInActivity | 获取 Activity meta Data |
| getMetaDataInService | 获取 Service meta Data |
| getMetaDataInReceiver | 获取 Receiver meta Data |
| getMetaDataInProvider | 获取 ContentProvider meta Data |
| getAppVersion | 获取 APP 版本信息 |
| getAppVersionCode | 获取 APP versionCode |
| getAppVersionName | 获取 APP versionName |


* **内存信息工具类 ->** [MemoryUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/MemoryUtils.java)

| 方法 | 注释 |
| :- | :- |
| printMemoryInfo | 获取内存信息 |
| printMemoryInfo2 | 获取内存信息 |
| getMemoryInfo | 获取内存信息 |
| getAvailMemory | 获取可用内存信息 |
| getAvailMemoryFormat | 获取可用内存信息 ( 格式化 ) |
| getTotalMemory | 获取总内存大小 |
| getTotalMemoryFormat | 获取总内存大小 ( 格式化 ) |
| getMemoryAvailable | 获取可用内存大小 |
| getMemoryAvailableFormat | 获取可用内存大小 ( 格式化 ) |
| getMemInfoIype | 通过不同 type 获取对应的内存信息 |


* **网络管理工具类 ->** [NetWorkUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/NetWorkUtils.java)

| 方法 | 注释 |
| :- | :- |
| getMobileDataEnabled | 获取移动网络打开状态 ( 默认属于未打开 ) |
| setMobileDataEnabled | 设置移动网络开关 ( 无判断是否已开启移动网络 ) - 实际无效果, 非系统应用无权限 |
| isConnect | 判断是否连接了网络 |
| getConnectType | 获取连接的网络类型 |
| isConnWifi | 判断是否连接 Wifi( 连接上、连接中 ) |
| isConnMobileData | 判断是否连接移动网络 ( 连接上、连接中 ) |
| isAvailable | 判断网络是否可用 |
| isAvailableByPing | 使用 ping ip 方式判断网络是否可用 |
| getActiveNetworkInfo | 获取活动网络信息 |
| getActiveNetwork | 获取活动网络信息 |
| is4G | 判断是否 4G 网络 |
| getWifiEnabled | 判断 wifi 是否打开 |
| isWifiAvailable | 判断 wifi 数据是否可用 |
| getNetworkOperatorName | 获取网络运营商名称 - 中国移动、如中国联通、中国电信 |
| getNetworkType | 获取当前网络类型 |
| getNetworkClass | 获取移动网络连接类型 |
| getBroadcastIpAddress | 获取广播 IP 地址 |
| getDomainAddress | 获取域名 IP 地址 |
| getIPAddress | 获取 IP 地址 |
| getIpAddressByWifi | 根据 Wifi 获取网络 IP 地址 |
| getGatewayByWifi | 根据 Wifi 获取网关 IP 地址 |
| getNetMaskByWifi | 根据 Wifi 获取子网掩码 IP 地址 |
| getServerAddressByWifi | 根据 Wifi 获取服务端 IP 地址 |


* **通知栏管理工具类 ->** [NotificationUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/NotificationUtils.java)

| 方法 | 注释 |
| :- | :- |
| getNotificationManager | 获取通知栏管理对象 |
| cancelAll | 移除通知 - 移除所有通知 ( 只是针对当前 Context 下的 Notification) |
| cancel | 移除通知 - 移除标记为 id 的通知 ( 只是针对当前 Context 下的所有 Notification) |
| notify | 进行通知 |
| createPendingIntent | 获取 PendingIntent |
| createNotification | 创建通知栏对象 |
| obtain | 获取 Led 配置参数 |
| isEmpty | 判断是否为 null |


* **OS 系统相关工具类 ->** [OSUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/OSUtils.java)

| 方法 | 注释 |
| :- | :- |
| getRomType | 获取 ROM 类型 |
| getVersion | 获取 ROM 具体版本号, 如 MIUI 9 8.4.26 获取的是 8.4.26 |
| getBaseVersion | 获取 ROM 版本, 如 MIUI 9 获取的是 9 |


* **路径相关工具类 ->** [PathUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/PathUtils.java)

| 方法 | 注释 |
| :- | :- |
| getRootPath | 获取 Android 系统根目录 - path /system |
| getDataPath | 获取 data 目录 - path /data |
| getDownloadCachePath | 获取下载缓存目录 - path data/cache |
| getInternalAppDataPath | 获取内存应用数据路径 - path /data/data/package |
| getInternalAppCodeCacheDir | 获取内存应用代码缓存路径 - path /data/data/package/code_cache |
| getInternalAppDbsPath | 获取内存应用数据库路径 - path /data/data/package/databases |
| getInternalAppDbPath | 获取内存应用数据库路径 - path /data/data/package/databases/name |
| getInternalAppFilesPath | 获取内存应用文件路径 - path/data/data/package/files |
| getInternalAppSpPath | 获取内存应用 SP 路径 - path/data/data/package/shared_prefs |
| getInternalAppNoBackupFilesPath | 获取内存应用未备份文件路径 - path/data/data/package/no_backup |
| getExternalStoragePath | 获取外存路径 - path/storage/emulated/0 |
| getExternalMusicPath | 获取外存音乐路径 - path/storage/emulated/0/Music |
| getExternalPodcastsPath | 获取外存播客路径 - path/storage/emulated/0/Podcasts |
| getExternalRingtonesPath | 获取外存铃声路径 - path/storage/emulated/0/Ringtones |
| getExternalAlarmsPath | 获取外存闹铃路径 - path/storage/emulated/0/Alarms |
| getExternalNotificationsPath | 获取外存通知路径 - path/storage/emulated/0/Notifications |
| getExternalPicturesPath | 获取外存图片路径 - path/storage/emulated/0/Pictures |
| getExternalMoviesPath | 获取外存影片路径 - path/storage/emulated/0/Movies |
| getExternalDownloadsPath | 获取外存下载路径 - path/storage/emulated/0/Download |
| getExternalDcimPath | 获取外存数码相机图片路径 - path/storage/emulated/0/DCIM |
| getExternalDocumentsPath | 获取外存文档路径 - path/storage/emulated/0/Documents |
| getExternalAppDataPath | 获取外存应用数据路径 - path/storage/emulated/0/Android/data/package |
| getExternalAppCachePath | 获取外存应用缓存路径 - path/storage/emulated/0/Android/data/package/cache |
| getExternalAppFilesPath | 获取外存应用文件路径 - path/storage/emulated/0/Android/data/package/files |
| getExternalAppMusicPath | 获取外存应用音乐路径 - path/storage/emulated/0/Android/data/package/files/Music |
| getExternalAppPodcastsPath | 获取外存应用播客路径 - path/storage/emulated/0/Android/data/package/files/Podcasts |
| getExternalAppRingtonesPath | 获取外存应用铃声路径 - path/storage/emulated/0/Android/data/package/files/Ringtones |
| getExternalAppAlarmsPath | 获取外存应用闹铃路径 - path/storage/emulated/0/Android/data/package/files/Alarms |
| getExternalAppNotificationsPath | 获取外存应用通知路径 - path/storage/emulated/0/Android/data/package/files/Notifications |
| getExternalAppPicturesPath | 获取外存应用图片路径 - path/storage/emulated/0/Android/data/package/files/Pictures |
| getExternalAppMoviesPath | 获取外存应用影片路径 - path/storage/emulated/0/Android/data/package/files/Movies |
| getExternalAppDownloadPath | 获取外存应用下载路径 - path/storage/emulated/0/Android/data/package/files/Download |
| getExternalAppDcimPath | 获取外存应用数码相机图片路径 - path/storage/emulated/0/Android/data/package/files/DCIM |
| getExternalAppDocumentsPath | 获取外存应用文档路径 - path/storage/emulated/0/Android/data/package/files/Documents |
| getExternalAppObbPath | 获取外存应用 OBB 路径 - path/storage/emulated/0/Android/obb/package |


* **手机相关工具类 ->** [PhoneUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/PhoneUtils.java)

| 方法 | 注释 |
| :- | :- |
| getTelephonyManager | 获取 TelephonyManager |
| isPhone | 判断设备是否是手机 |
| getSimState | 获取 SIM 卡状态 |
| isSimReady | 判断是否装载 SIM 卡 |
| getSimCountryIso | 获取 SIM 卡运营商的国家代码 |
| getNetworkCountryIso | 获取 SIM 卡注册的网络运营商的国家代码 |
| getSimCountry | 获取 SIM 卡运营商的国家代码 |
| checkSimCountry | 判断 SIM 卡运营商是否国内 |
| getMEID | 获取 MEID 码 |
| getIMEI | 获取 IMEI 码 |
| getIMSI | 获取 IMSI 码 |
| getSimOperatorName | 获取 SIM 卡运营商名称 ( 如: 中国移动、如中国联通、中国电信 ) |
| getSimOperator | 获取 SIM 卡运营商 MCC + MNC |
| getChinaOperatorByIMSI | 通过 IMSI 获取中国运营商简称 |
| getChinaOperatorBySimOperator | 获取 SIM 卡中国运营商简称 |
| getPhoneType | 获取手机类型 |
| getDeviceId | 获取设备 id |
| getAndroidId | 获取 Android id |
| getSerialNumber | 获取设备序列号 |
| getSimSerialNumber | 获取 SIM 卡序列号 |
| getUUID | 获取设备唯一 UUID |
| getPhoneStatus | 获取手机状态信息 |
| dial | 跳至拨号界面 |
| call | 拨打电话 |
| sendSms | 跳至发送短信界面 |
| sendSmsSilent | 发送短信 |
| getContactNum | 打开手机联系人界面点击联系人后便获取该号码 |
| getAllContactInfo | 获取手机联系人信息 |
| getAllContactInfo2 | 获取手机联系人信息 |
| getAllSMS | 获取手机短信并保存到 xml 中 |
| getMtkTeleInfo | 获取 MTK 神机的双卡 IMSI、IMSI 信息 |
| getMtkTeleInfo2 | 获取 MTK 神机的双卡 IMSI、IMSI 信息 |
| getQualcommTeleInfo | 获取 高通 神机的双卡 IMSI、IMSI 信息 |
| getSpreadtrumTeleInfo | 获取 展讯 神机的双卡 IMSI、IMSI 信息 |


* **电源管理工具类 ->** [PowerManagerUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/PowerManagerUtils.java)

| 方法 | 注释 |
| :- | :- |
| getInstance | 获取 PowerManagerUtils 实例 |
| isScreenOn | 屏幕是否打开 ( 亮屏 ) |
| turnScreenOn | 唤醒 / 点亮 屏幕 |
| turnScreenOff | 释放屏幕锁, 允许休眠时间自动黑屏 |
| getWakeLock | 获取 PowerManager.WakeLock |
| setWakeLock | 设置 PowerManager.WakeLock |
| getPowerManager | 获取 PowerManager |
| setPowerManager | 设置 PowerManager |
| setBright | 设置屏幕常亮 |
| setWakeLockToBright | 设置 WakeLock 常亮 |


* **进程相关工具类 ->** [ProcessUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ProcessUtils.java)

| 方法 | 注释 |
| :- | :- |
| kill | 销毁自身进程 |
| isCurProcess | 判断是否当前进程 |
| getCurProcessName | 获取当前进程名 |
| getProcessName | 获取进程 id 对应的进程名 |
| getPid | 根据包名获取进程 id |
| getRunningAppProcessInfo | 根据进程 id 获取进程信息 |
| getForegroundProcessName | 获取前台线程包名 |
| getAllBackgroundProcesses | 获取后台服务进程 |
| killAllBackgroundProcesses | 杀死所有的后台服务进程 |
| killBackgroundProcesses | 杀死后台服务进程 |


* **资源文件工具类 ->** [ResourceUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ResourceUtils.java)

| 方法 | 注释 |
| :- | :- |
| getResources | 获取 Resources |
| getTheme | 获取 Resources.Theme |
| getAssets | 获取 AssetManager |
| getContentResolver | 获取 ContentResolver |
| getDisplayMetrics | 获取 DisplayMetrics |
| getConfiguration | 获取 Configuration |
| getColorStateList | 获取 ColorStateList |
| getString | 获取 String |
| getColor | 获取 Color |
| getDrawable | 获取 Drawable |
| getColorDrawable | 获取指定颜色 Drawable |
| getBitmap | 获取 Bitmap |
| getDimension | 获取 Dimension |
| getBoolean | 获取 Boolean |
| getInteger | 获取 Integer |
| getAnimation | 获取 Animation |
| getResourceName | 获取给定资源标识符的全名 |
| getIntArray | 获取 int[] |
| getStringArray | 获取 String[] |
| getTextArray | 获取 CharSequence[] |
| getLayoutId | 获取 layout id |
| getDrawableId | 获取 drawable id |
| getMipmapId | 获取 mipmap id |
| getMenuId | 获取 menu id |
| getRawId | 获取 raw id |
| getAnimId | 获取 anim id |
| getColorId | 获取 color id |
| getDimenId | 获取 dimen id |
| getAttrId | 获取 attr id |
| getStyleId | 获取 style id |
| getStyleableId | 获取 styleable id |
| getId | 获取 id |
| getStringId | 获取 string id |
| getBoolId | 获取 bool id |
| getIntegerId | 获取 integer id |
| getIdentifier | 获取资源 id |
| openAssetsResource | 获取 AssetManager 指定资源 InputStream |
| openRawResource | 获取对应资源 InputStream |
| openRawResourceFd | 获取对应资源 AssetFileDescriptor |
| readBytesFromAssets | 获取 Assets 资源文件数据 |
| readStringFromAssets | 获取 Assets 资源文件数据 |
| readBytesFromRaw | 获取 Raw 资源文件数据 |
| readStringFromRaw | 获取 Raw 资源文件数据 |
| geFileToListFromAssets | 获取 Assets 资源文件数据 ( 返回 List<String> 一行的全部内容属于一个索引 ) |
| geFileToListFromRaw | 获取 Raw 资源文件数据 ( 返回 List<String> 一行的全部内容属于一个索引 ) |
| saveAssetsFormFile | 获取 Assets 资源文件数据并保存到本地 |
| saveRawFormFile | 获取 Raw 资源文件数据并保存到本地 |


* **屏幕相关工具类 ->** [ScreenUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ScreenUtils.java)

| 方法 | 注释 |
| :- | :- |
| getWindowManager | 获取 WindowManager |
| getDisplayMetrics | 获取 DisplayMetrics |
| getScreenWidth | 获取屏幕宽度 |
| getScreenHeight | 获取屏幕高度 |
| getScreenWidthHeight | 获取屏幕宽高 |
| getScreenWidthHeightToPoint | 获取屏幕宽高 |
| getScreenSize | 获取屏幕分辨率 |
| getScreenSizeOfDevice | 获取屏幕英寸 - 例 5.5 英寸 |
| getDensity | 获取屏幕密度 |
| getDensityDpi | 获取屏幕密度 dpi |
| getScaledDensity | 获取屏幕缩放密度 |
| getXDpi | 获取 X 轴 dpi |
| getYDpi | 获取 Y 轴 dpi |
| getWidthDpi | 获取宽度比例 dpi 基准 |
| getHeightDpi | 获取高度比例 dpi 基准 |
| getScreenInfo | 获取屏幕信息 |
| setFullScreen | 设置屏幕为全屏 |
| setLandscape | 设置屏幕为横屏 |
| setPortrait | 设置屏幕为竖屏 |
| isLandscape | 判断是否横屏 |
| isPortrait | 判断是否竖屏 |
| toggleScreenOrientation | 切换屏幕方向 |
| getScreenRotation | 获取屏幕旋转角度 |
| isScreenLock | 判断是否锁屏 |
| isTablet | 判断是否是平板 |
| getStatusHeight | 获取状态栏的高度 ( 无关 android:theme 获取状态栏高度 ) |
| getStatusBarHeight | 获取应用区域 TitleBar 高度 ( 顶部灰色 TitleBar 高度, 没有设置 android:theme 的 NoTitleBar 时会显示 ) |
| setSleepDuration | 设置进入休眠时长 |
| getSleepDuration | 获取进入休眠时长 |
| snapShotWithStatusBar | 获取当前屏幕截图, 包含状态栏 ( 顶部灰色 TitleBar 高度, 没有设置 android:theme 的 NoTitleBar 时会显示 ) |
| snapShotWithoutStatusBar | 获取当前屏幕截图, 不包含状态栏 ( 如果 android:theme 全屏, 则截图无状态栏 ) |
| getNavigationBarHeight | 获取底部导航栏高度 |
| checkDeviceHasNavigationBar | 检测是否具有底部导航栏 |


* **SDCard 工具类 ->** [SDCardUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/SDCardUtils.java)

| 方法 | 注释 |
| :- | :- |
| isSDCardEnable | 判断内置 SDCard 是否正常挂载 |
| getSDCardFile | 获取内置 SDCard File |
| getSDCardPath | 获取内置 SDCard 绝对路径 |
| getSDCardPathSeparator | 获取内置 SDCard 绝对路径 |
| isSDCardEnablePath | 判断 SDCard 是否可用 |
| getSDCardPaths | 获取 SDCard 路径 |
| getAllBlockSizeFormat | 获取内置 SDCard 空间总大小 |
| getAvailableBlocksFormat | 获取内置 SDCard 空闲空间大小 |
| getUsedBlocksFormat | 获取内置 SDCard 已使用空间大小 |
| getAllBlockSize | 获取内置 SDCard 空间总大小 |
| getAvailableBlocks | 获取内置 SDCard 空闲空间大小 |
| getUsedBlocks | 获取内置 SDCard 已使用空间大小 |
| getBlockSizeInfos | 返回内置 SDCard 空间大小信息 |
| getDiskCacheDir | 获取 APP Cache 文件夹地址 |
| getCacheFile | 获取 APP Cache 路径 File |
| getCachePath | 获取 APP Cache 路径 |


* **服务相关工具类 ->** [ServiceUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ServiceUtils.java)

| 方法 | 注释 |
| :- | :- |
| isServiceRunning | 判断服务是否运行 |
| getAllRunningService | 获取所有运行的服务 |
| startService | 启动服务 |
| stopService | 停止服务 |
| bindService | 绑定服务 |
| unbindService | 解绑服务 |


* **Shape 工具类 ->** [ShapeUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ShapeUtils.java)

| 方法 | 注释 |
| :- | :- |
| getDrawable | 获取 GradientDrawable |
| setDrawable | 设置 Drawable 背景 |
| newBuilder | 创建新的 Shape Builder 对象 |
| newBuilderToLeft | 创建新的 Shape Builder 对象 |
| newBuilderToRight | 创建新的 Shape Builder 对象 |
| newBuilderToGradient | 创建渐变的 Shape Builder 对象 |
| build | build ShapeUtils 对象 |
| setRadius | 设置圆角 |
| setRadiusLeft | 设置圆角 |
| setRadiusRight | 设置圆角 |
| setCornerRadii | 设置圆角 ( 统一处理方法 ) |
| setColor | 设置背景色 ( 填充铺满 ) |
| setStroke | 设置边框颜色 |
| setSize | 设置大小 |
| setPadding | 设置边距 |
| getOrientation | 获取渐变角度 |


* **Shell 命令工具类 ->** [ShellUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ShellUtils.java)

| 方法 | 注释 |
| :- | :- |
| execCmd | 执行 shell 命令 |
| isSuccess | 判断是否执行成功 |
| isSuccess2 | 判断是否执行成功 ( 判断 errorMsg) |
| isSuccess3 | 判断是否执行成功 ( 判断 successMsg) |
| isSuccess4 | 判断是否执行成功 ( 判断 successMsg), 并且 successMsg 是否包含某个字符串 |


* **快捷方式工具类 ->** [ShortCutUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ShortCutUtils.java)

| 方法 | 注释 |
| :- | :- |
| hasShortcut | 检测是否存在桌面快捷方式 |
| getShortCutIntent | 获取桌面快捷方式点击 Intent |
| addShortcut | 创建桌面快捷方式 |
| deleteShortcut | 删除桌面快捷方式 |


* **签名工具类 ( 获取 APP 签名信息 ) ->** [SignaturesUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/SignaturesUtils.java)

| 方法 | 注释 |
| :- | :- |
| signatureMD5 | 获取 MD5 签名 |
| signatureSHA1 | 获取签名 SHA1 加密字符串 |
| signatureSHA256 | 获取签名 SHA256 加密字符串 |
| isDebuggable | 判断 debug 签名还是 release 签名 |
| getX509Certificate | 获取证书对象 |
| printSignatureInfo | 打印签名信息 |
| getSignaturesFromApk | 从 APK 中读取签名 |
| getCertificateFromApk | 从 APK 中读取签名 |


* **大小工具类 (dp, px, sp 转换、View 获取宽高等 ) ->** [SizeUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/SizeUtils.java)

| 方法 | 注释 |
| :- | :- |
| dipConvertPx | dp 转 px |
| dipConvertPxf | dp 转 px (float) |
| pxConvertDip | px 转 dp |
| pxConvertDipf | px 转 dp (float) |
| spConvertPx | sp 转 px |
| spConvertPxf | sp 转 px (float) |
| pxConvertSp | px 转 sp |
| pxConvertSpf | px 转 sp (float) |
| applyDimension | 各种单位转换 - 该方法存在于 TypedValue.applyDimension |
| forceGetViewSize | 在 onCreate 中获取视图的尺寸 - 需回调 onGetSizeListener 接口, 在 onGetSize 中获取 View 宽高 |
| measureView | 测量 View |
| getMeasuredWidth | 获取 View 的宽度 |
| getMeasuredHeight | 获取 View 的高度 |


* **Snackbar 工具类 ->** [SnackbarUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/SnackbarUtils.java)

| 方法 | 注释 |
| :- | :- |
| with | 获取 SnackbarUtils 对象 |
| getStyle | 获取样式 |
| setStyle | 设置样式 |
| getSnackbar | 获取 Snackbar |
| getSnackbarView | 获取 Snackbar View |
| getTextView | 获取 Snackbar TextView(snackbar_text) |
| getActionButton | 获取 Snackbar Action Button(snackbar_action) |
| addView | 向 Snackbar 布局中添加 View (Google 不建议, 复杂的布局应该使用 DialogFragment 进行展示 ) |
| setCallback | 设置 Snackbar 展示完成、隐藏完成 的监听 |
| setAction | 设置 Action 按钮文字内容及点击监听 |
| dismiss | 关闭 Snackbar |
| showShort | 显示 Short Snackbar |
| showLong | 显示 Long Snackbar |
| showIndefinite | 显示 Indefinite Snackbar ( 无限时, 一直显示 ) |
| setSnackbarStyle | 设置 Snackbar 样式配置 |
| getShadowMargin | 获取阴影边距 |
| setShadowMargin | 设置阴影边距 |
| isAutoCalc | 判断是否自动计算边距 ( 如: 显示在 View 下面, 但是下方距离不够, 自动设置为在 View 上方显示 ) |
| setAutoCalc | 设置是否自动计算边距 ( 如: 显示在 View 下面, 但是下方距离不够, 自动设置为在 View 上方显示 ) |
| above | 设置 Snackbar 显示在指定 View 的上方 |
| bellow | 设置 Snackbar 显示在指定 View 的下方 |


* **SpannableString 工具类 ->** [SpannableStringUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/SpannableStringUtils.java)

| 方法 | 注释 |
| :- | :- |
| with | 获取持有 TextView SpannableStringUtils |
| setFlag | 设置标识 |
| setForegroundColor | 设置前景色 |
| setBackgroundColor | 设置背景色 |
| setLineHeight | 设置行高 |
| setQuoteColor | 设置引用线的颜色 |
| setLeadingMargin | 设置缩进 |
| setBullet | 设置列表标记 |
| setFontSize | 设置字体尺寸 |
| setFontProportion | 设置字体比例 |
| setFontXProportion | 设置字体横向比例 |
| setStrikethrough | 设置删除线 |
| setUnderline | 设置下划线 |
| setSuperscript | 设置上标 |
| setSubscript | 设置下标 |
| setBold | 设置粗体 |
| setItalic | 设置斜体 |
| setBoldItalic | 设置粗斜体 |
| setFontFamily | 设置字体系列 |
| setTypeface | 设置字体 |
| setHorizontalAlign | 设置水平对齐 |
| setVerticalAlign | 设置垂直对齐 |
| setClickSpan | 设置点击事件 |
| setUrl | 设置超链接 |
| setBlur | 设置模糊 |
| setShader | 设置着色器 |
| setShadow | 设置阴影 |
| setSpans | 自定义 setSpan 参数 |
| append | 追加文本 |
| appendLine | 追加换行 |
| appendImage | 追加 Image |
| appendSpace | 追加空格 |
| get | 获取 SpannableStringBuilder |
| create | 创建 SpannableStringBuilder |


* **颜色状态列表工具类 ->** [StateListUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/StateListUtils.java)

| 方法 | 注释 |
| :- | :- |
| getColorStateList | 获取 ColorStateList |
| createColorStateList | 创建 ColorStateList => createColorStateList("#ffffffff", "#ff44e6ff") |
| newSelector | 创建 StateListDrawable => view.setBackground(Drawable) |


* **TextView 工具类 ->** [TextViewUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/TextViewUtils.java)

| 方法 | 注释 |
| :- | :- |
| getTextView | 获取 TextView |
| getText | 获取文本 |
| getTexts | 获取多个 TextView 文本 |
| setText | 设置文本 |
| setTexts | 设置多个 TextView 文本 |
| setHtmlText | 设置 Html 内容 |
| setHtmlTexts | 设置多个 TextView Html 内容 |
| setTextColor | 设置字体颜色 |
| setTextColors | 设置多个 TextView 字体颜色 |
| setTypeface | 设置字体 |
| setTextSizeByPx | 设置字体大小 - px 像素 |
| setTextSizeBySp | 设置字体大小 - sp 缩放像素 |
| setTextSizeByDp | 设置字体大小 - dp 与设备无关的像素 |
| setTextSizeByIn | 设置字体大小 - inches 英寸 |
| setTextSize | 设置字体大小 |
| setTextSizes | 设置多个 TextView 字体大小 |
| getTextSize | 获取 TextView 字体大小 - px |
| clearFlags | 清空 flags |
| setBold | 设置 TextView 是否加粗 |
| setUnderlineText | 设置下划线 |
| setStrikeThruText | 设置中划线 |
| setLetterSpacing | 设置文字水平间距 |
| setLineSpacing | 设置文字行间距 ( 行高 ) |
| setLineSpacingAndMultiplier | 设置文字行间距 ( 行高 )、行间距倍数 |
| setTextScaleX | 设置字体水平方向的缩放 |
| setIncludeFontPadding | 设置是否保留字体留白间隙区域 |
| getTextHeight | 获取字体高度 |
| getTextTopOffsetHeight | 获取字体顶部偏移高度 |
| getTextWidth | 计算字体宽度 |
| getCenterRectY | 获取画布中间居中位置 |
| reckonTextSize | 通过需要的高度, 计算字体大小 |
| calcTextWidth | 计算第几位超过宽度 |


* **Uri 工具类 ->** [UriUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/UriUtils.java)

| 方法 | 注释 |
| :- | :- |
| getUriForFileToName | 获取文件 Uri ( 自动添加包名 ${applicationId}) |
| getUriForFile | 获取文件 Uri |
| getFilePathByUri | 通过 Uri 获取文件路径 |


* **震动相关工具类 ->** [VibrationUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/VibrationUtils.java)

| 方法 | 注释 |
| :- | :- |
| vibrate | 震动 |
| cancel | 取消震动 |


* **View 操作相关工具类 ->** [ViewUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/ViewUtils.java)

| 方法 | 注释 |
| :- | :- |
| getContext | 获取 Context |
| getActivity | 获取 View context 所属的 Activity |
| inflate | 获取 View |
| getChildAt | 获取指定索引 View |
| removeAllViews | 移除全部子 View |
| findViewById | 初始化 View |
| convertView | 转换 View |
| isEmpty | 判断 View 是否为 null |
| isNotEmpty | 判断 View 是否不为 null |
| setFocusable | 设置 View 是否可以获取焦点 |
| setSelected | 设置 View 是否选中 |
| setEnabled | 设置 View 是否启用 |
| setClickable | 设置 View 是否可以点击 |
| setLongClickable | 设置 View 是否可以长按 |
| isVisibility | 判断 View 是否显示 |
| isVisibilitys | 判断 View 是否都显示 |
| isVisibilityIN | 判断 View 是否隐藏占位 |
| isVisibilityINs | 判断 View 是否都隐藏占位 |
| isVisibilityGone | 判断 View 是否隐藏 |
| isVisibilityGones | 判断 View 是否都隐藏 |
| getVisibility | 获取显示的状态 (View.VISIBLE : View.GONE) |
| getVisibilityIN | 获取显示的状态 (View.VISIBLE : View.INVISIBLE) |
| setVisibility | 设置 View 显示的状态 |
| setVisibilitys | 设置 View 显示的状态 |
| toggleVisibilitys | 切换 View 显示的状态 |
| reverseVisibilitys | 反转 View 显示的状态 |
| toggleView | 切换 View 状态 |
| toggleViews | 切换 View 状态 |
| removeSelfFromParent | 把自身从父 View 中移除 |
| isTouchInView | 判断触点是否落在该 View 上 |
| requestLayoutParent | View 请求更新 |
| measureView | 测量 View |
| getMeasuredWidth | 获取 View 的宽度 |
| getMeasuredHeight | 获取 View 的高度 |
| getMargin | 获取 View Margin |
| setMargin | 设置 Margin 边距 |
| getPadding | 获取 View Padding |
| setPadding | 设置 Padding 边距 |
| getCompoundDrawables | 获取 CompoundDrawables |
| getCompoundDrawablePadding | 获取 CompoundDrawables Padding |
| setCompoundDrawablesByLeft | 设置 Left CompoundDrawables |
| setCompoundDrawablesByTop | 设置 Top CompoundDrawables |
| setCompoundDrawablesByRight | 设置 Right CompoundDrawables |
| setCompoundDrawablesByBottom | 设置 Bottom CompoundDrawables |
| setCompoundDrawables | 设置 CompoundDrawables |
| setCompoundDrawablesWithIntrinsicBoundsByLeft | 设置 Left CompoundDrawables - 按照原有比例大小显示图片 |
| setCompoundDrawablesWithIntrinsicBoundsByTop | 设置 Top CompoundDrawables - 按照原有比例大小显示图片 |
| setCompoundDrawablesWithIntrinsicBoundsByRight | 设置 Right CompoundDrawables - 按照原有比例大小显示图片 |
| setCompoundDrawablesWithIntrinsicBoundsByBottom | 设置 Bottom CompoundDrawables - 按照原有比例大小显示图片 |
| setCompoundDrawablesWithIntrinsicBounds | 设置 CompoundDrawables - 按照原有比例大小显示图片 |
| calcListViewItemHeight | 计算 ListView Item 高度 |
| calcGridViewItemHeight | 计算 GridView Item 高度 |
| getItemHeighet | 获取单独一个 Item 高度 |


## <span id="devutilsappanim">**`dev.utils.app.anim`**</span>


* **动画工具类 ->** [AnimationUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/anim/AnimationUtils.java)

| 方法 | 注释 |
| :- | :- |
| setAnimRepeat | 设置动画重复处理 |
| getRotateAnimation | 获取一个旋转动画 |
| getRotateAnimationByCenter | 获取一个根据视图自身中心点旋转的动画 |
| getAlphaAnimation | 获取一个透明度渐变动画 |
| getHiddenAlphaAnimation | 获取一个由完全显示变为不可见的透明度渐变动画 |
| getShowAlphaAnimation | 获取一个由不可见变为完全显示的透明度渐变动画 |
| getScaleAnimation | 获取一个缩放动画 |
| getScaleAnimationCenter | 获取一个中心点缩放动画 |
| getLessenScaleAnimation | 获取一个缩小动画 |
| getAmplificationAnimation | 获取一个放大动画 |
| getTranslateAnimation | 获取一个视图移动动画 |
| getShakeAnimation | 获取一个视图摇晃动画 |


* **视图动画工具类 (AnimationUtils 基础上封装 ), 提供简单的控制视图的动画的工具方法 ->** [ViewAnimationUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/anim/ViewAnimationUtils.java)

| 方法 | 注释 |
| :- | :- |
| invisibleViewByAlpha | 将给定视图渐渐隐去 - view.setVisibility(View.INVISIBLE) |
| goneViewByAlpha | 将给定视图渐渐隐去最后从界面中移除 - view.setVisibility(View.GONE) |
| visibleViewByAlpha | 将给定视图渐渐显示出来 - view.setVisibility(View.VISIBLE) |
| translate | 视图移动 |
| shake | 视图摇晃 |


## <span id="devutilsappassist">**`dev.utils.app.assist`**</span>


* **异步执行辅助类 ->** [AsyncExecutor.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/assist/AsyncExecutor.java)

| 方法 | 注释 |
| :- | :- |
| shutdownNow | 立即关闭线程池任务 |
| execute | 将任务投入线程池执行 |


* **播放「bee」的声音, 并且震动辅助类 ->** [BeepVibrateAssist.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/assist/BeepVibrateAssist.java)

| 方法 | 注释 |
| :- | :- |
| isPlayBeep | 判断是否允许播放声音 |
| isVibrate | 判断是否允许震动 |
| setVibrate | 设置是否允许震动 |
| setMediaPlayer | 设置播放资源对象 |
| playBeepSoundAndVibrate | 进行播放声音, 并且震动 |
| close | 关闭震动、提示声, 并释放资源 |
| buildMediaPlayer | 创建 MediaPlayer 对象 |


* **Activity 无操作定时辅助类 ->** [InactivityTimerAssist.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/assist/InactivityTimerAssist.java)

| 方法 | 注释 |
| :- | :- |
| onPause | 暂停检测 |
| onResume | 回到 Activity 处理 |
| onDestroy | Activity 销毁处理 |


* **屏幕传感器辅助类 ( 监听是否横竖屏 ) ->** [ScreenSensorAssist.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/assist/ScreenSensorAssist.java)

| 方法 | 注释 |
| :- | :- |
| start | 开始监听 |
| stop | 停止监听 |
| isPortrait | 是否竖屏 |
| isAllowChange | 是否允许切屏 |


## <span id="devutilsappassistmanager">**`dev.utils.app.assist.manager`**</span>


* **定时器工具类 ->** [TimerManager.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/assist/manager/TimerManager.java)

| 方法 | 注释 |
| :- | :- |
| gc | 回收定时器资源 |
| getTimerSize | 获取全部任务总数 |
| getTimer | 获取属于对应字符串标记的定时器任务 ( 优先获取符合的 ) |
| getTimers | 获取属于对应字符串标记的定时器任务集合 |
| closeAll | 关闭全部任务 |
| closeNotRunTask | 关闭所有未运行的任务 |
| closeInfiniteTask | 关闭所有无限循环的任务 |
| closeMark | 关闭所有符合对应的字符串标记的定时器任务 |
| createTimer | 创建定时器 => 立即执行、无限循环、通知默认 what |
| getMarkId | 获取标记 id |
| getMarkStr | 获取标记字符串 |
| setMarkId | 设置标记 id |
| setMarkStr | 设置标记字符串 |
| startTimer | 运行定时器 |
| closeTimer | 关闭定时器 |
| isRunTimer | 判断是否运行中 |
| getTriggerNumber | 获取已经触发的次数 |
| getTriggerLimit | 获取允许触发的上限次数 |
| isTriggerEnd | 是否触发结束 ( 到达最大次数 ) |
| isInfinite | 是否无限循环 |
| setHandler | 设置通知的 Handler |
| setNotifyWhat | 设置通知的 what |
| setNotifyObject | 设置通知的 Object |
| setTime | 设置时间 |
| setTriggerLimit | 设置触发次数上限 |


## <span id="devutilsappcache">**`dev.utils.app.cache`**</span>


* **缓存工具类 ->** [DevCache.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/cache/DevCache.java)

| 方法 | 注释 |
| :- | :- |
| getCacheDir | 获取缓存地址 |
| get | 默认缓存地址 |
| put | 保存 String 数据到缓存中 |
| getAsString | 读取 String 数据 |
| getAsJSONObject | 读取 JSONObject 数据 |
| getAsJSONArray | 读取 JSONArray 数据 |
| getAsBinary | 获取 byte[] 数据 |
| getAsObject | 读取 Serializable 数据 |
| getAsBitmap | 读取 Bitmap 数据 |
| getAsDrawable | 读取 Drawable 数据 |
| file | 获取缓存文件 |
| remove | 移除某个 key 的数据 |
| clear | 清除所有数据 |


## <span id="devutilsappcamera1">**`dev.utils.app.camera1`**</span>


* **摄像头自动获取焦点辅助类 ->** [AutoFocusAssist.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/camera1/AutoFocusAssist.java)

| 方法 | 注释 |
| :- | :- |
| setFocusModes | 设置对焦模式 |
| isAutoFocus | 是否允许自动对焦 |
| setAutoFocus | 设置是否开启自动对焦 |
| start | 开始对焦 |
| stop | 停止对焦 |


* **摄像头辅助类 ->** [CameraAssist.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/camera1/CameraAssist.java)

| 方法 | 注释 |
| :- | :- |
| openDriver | 打开摄像头程序 |
| closeDriver | 关闭摄像头程序 |
| startPreview | 开始将 Camera 画面预览到手机上 |
| stopPreview | 停止 Camera 画面预览 |
| getCameraResolution | 获取相机分辨率 |
| getPreviewSize | 获取预览分辨率 |
| getCameraSizeAssist | 获取 Camera.Size 计算辅助类 |
| getCamera | 获取摄像头 |
| setCamera | 设置摄像头 |
| setPreviewNotify | 设置预览回调 |
| setAutoFocus | 设置是否开启自动对焦 |
| isPreviewing | 是否预览中 |
| setAutoInterval | 设置自动对焦时间间隔 |
| setFlashlightOn | 打开闪光灯 |
| setFlashlightOff | 关闭闪光灯 |
| isFlashlightOn | 是否打开闪光灯 |
| isFlashlightEnable | 是否支持手机闪光灯 |


* **摄像头 ( 预览、输出大小 ) 辅助类 ->** [CameraSizeAssist.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/camera1/CameraSizeAssist.java)

| 方法 | 注释 |
| :- | :- |
| getCamera | 获取摄像头 |
| setPreviewSize | 设置预览大小 |
| getPreviewSize | 根据手机支持的预览分辨率计算, 设置预览尺寸 |
| setPictureSize | 设置拍照图片大小 |
| getPictureSize | 根据手机支持的拍照分辨率计算 |
| getVideoSize | 根据手机支持的视频录制分辨率计算 |


* **摄像头相关工具类 ->** [CameraUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/camera1/CameraUtils.java)

| 方法 | 注释 |
| :- | :- |
| isSupportReverse | 判断是否支持反转摄像头 ( 是否存在前置摄像头 ) |
| checkCameraFacing | 检查是否有指定的摄像头 |
| isFrontCamera | 判断是否使用前置摄像头 |
| isBackCamera | 判断是否使用后置摄像头 |
| isUseCameraFacing | 判断使用的摄像头 |
| freeCameraResource | 释放摄像头资源 |
| initCamera | 初始化摄像头 |
| open | 打开摄像头 |


## <span id="devutilsappimage">**`dev.utils.app.image`**</span>


* **Bitmap 工具类 ->** [BitmapUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/image/BitmapUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断 Bitmap 对象是否为 null |
| isNotEmpty | 判断 Bitmap 对象是否不为 null |
| getBitmapWidth | 获取 Bitmap 宽度 |
| getBitmapHeight | 获取 Bitmap 高度 |
| getBitmapWidthHeight | 获取 Bitmap 宽高 |
| copy | 复制 Bitmap |
| extractAlpha | 获取 Alpha 位图 ( 获取源图片的轮廓 rgb 为 0) |
| recode | 重新编码 Bitmap |
| recycle | Bitmap 通知回收 |
| rotate | 旋转图片 |
| getRotateDegree | 读取图片属性, 获取图片被旋转的角度 |
| reverseByHorizontal | 水平翻转图片 ( 左右颠倒 ) |
| reverseByVertical | 垂直翻转图片 ( 上下颠倒 ) |
| reverse | 翻转图片 |
| zoom | 缩放图片 ( 指定所需宽高 ) |
| scale | 缩放图片 ( 比例缩放 ) |
| skew | 倾斜图片 |
| clip | 裁剪图片 |
| crop | 裁剪图片 ( 返回指定比例图片 ) |
| combine | 合并图片 |
| combineToCenter | 合并图片 ( 居中 ) |
| combineToSameSize | 合并图片 ( 转为相同大小 ) |
| reflection | 图片倒影处理 |
| roundCorner | 图片圆角处理 ( 非圆形 ) |
| roundCornerTop | 图片圆角处理 ( 非圆形 ) - 只有 leftTop、rightTop |
| roundCornerBottom | 图片圆角处理 ( 非圆形 ) - 只有 leftBottom、rightBottom |
| round | 图片圆形处理 |
| addCornerBorder | 添加圆角边框 |
| addCircleBorder | 添加圆形边框 |
| addTextWatermark | 添加文字水印 |
| addImageWatermark | 添加图片水印 |
| compressByZoom | 按缩放宽高压缩 |
| compressByScale | 按缩放比例压缩 |
| compressByQuality | 按质量压缩 |
| compressByByteSize | 按质量压缩 ( 图片大小 ) |
| compressBySampleSize | 按采样大小压缩 |
| calculateInSampleSize | 计算采样大小 |


* **图片格式转换工具类 ->** [ImageConvertUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/image/ImageConvertUtils.java)

| 方法 | 注释 |
| :- | :- |
| convertBMP | 图片转换 BMP 格式 byte[] 数据 |


* **图片 ( 滤镜、效果 ) 工具类 ->** [ImageFilterUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/image/ImageFilterUtils.java)

| 方法 | 注释 |
| :- | :- |
| blur | 图片模糊处理 ( Android RenderScript 实现, 效率最高 ) |
| fastBlur | 图片模糊处理 ( 毛玻璃化 FastBlur Java 实现 ) |
| nostalgic | 怀旧效果处理 |
| sunshine | 光照效果处理 |
| film | 底片效果处理 |
| soften | 柔化效果处理 |
| sharpen | 锐化效果处理 |
| emboss | 浮雕效果处理 |
| toGray | 转为灰度图片 |
| saturation | 饱和度处理 |
| lum | 亮度处理 |
| hue | 色相处理 |
| lumHueSaturation | 亮度、色相、饱和度处理 |
| yuvLandscapeToPortrait | 将 YUV 格式的图片的源数据从横屏模式转为竖屏模式 |


* **Image ( Bitmap、Drawable 等 ) 工具类 ->** [ImageUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/image/ImageUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断 Bitmap 对象是否为 null |
| isNotEmpty | 判断 Bitmap 对象是否不为 null |
| isImage | 根据文件名判断文件是否为图片 |
| getImageType | 获取图片类型 |
| isPNG | 判断是否 PNG 图片 |
| isJPEG | 判断是否 JPG 图片 |
| isBMP | 判断是否 BMP 图片 |
| isGif | 判断是否 GIF 图片 |
| isWEBP | 判断是否 WEBP 图片 |
| decodeFile | 获取 Bitmap |
| decodeResource | 获取 Bitmap |
| decodeStream | 获取 Bitmap |
| decodeFileDescriptor | 获取 Bitmap |
| decodeByteArray | 获取 Bitmap |
| saveBitmapToSDCardJPEG | 保存图片到 SDCard - JPEG |
| saveBitmapToSDCardPNG | 保存图片到 SDCard - PNG |
| saveBitmapToSDCardWEBP | 保存图片到 SDCard - WEBP |
| saveBitmapToSDCard | 保存图片到 SDCard |
| get9PatchDrawable | 获取 .9 Drawable |
| setColorFilter | 图片着色 - tint |
| getBitmap | 获取 Bitmap |
| getBitmapFromView | 通过 View 绘制为 Bitmap |
| getBitmapFromViewCache | 通过 View Cache 绘制为 Bitmap |
| bitmapToByte | Bitmap 转换成 byte[] |
| drawableToByte | Drawable 转换成 byte[] |
| byteToBitmap | byte[] 转 Bitmap |
| bitmapToDrawable | Bitmap 转 Drawable |
| byteToDrawable | byte[] 转 Drawable |
| drawableToBitmap | Drawable 转 Bitmap |
| setBounds | 设置 Drawable 绘制区域 |


## <span id="devutilsappinfo">**`dev.utils.app.info`**</span>


* **APK 信息 Item ->** [ApkInfoItem.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/info/ApkInfoItem.java)

| 方法 | 注释 |
| :- | :- |
| obtain | 获取 ApkInfoItem |
| getAppInfoBean | 获取 AppInfoBean |
| getListKeyValues | 获取 List 信息键对值集合 |
| getAppMD5 | 获取 APP MD5 签名 |
| getAppSHA1 | 获取 APP SHA1 签名 |
| getAppSHA256 | 获取 APP SHA256 签名 |
| getMinSdkVersion | 获取 APP 最低支持 Android SDK 版本 |
| getTargetSdkVersion | 获取 APP 兼容 SDK 版本 |
| getApkLength | 获取 APP 安装包大小 |
| getX509Certificate | 获取证书对象 |
| getNotBefore | 获取证书生成日期 |
| getNotAfter | 获取证书有效期 |
| isEffective | 获取证书是否过期 |
| getCertPrincipal | 获取证书发布方 |
| getCertVersion | 获取证书版本号 |
| getCertSigalgname | 获取证书算法名称 |
| getCertSigalgoid | 获取证书算法 OID |
| getCertSerialnumber | 获取证书机器码 |
| getCertDercode | 获取证书 DER 编码 |


* **APP 信息实体类 ->** [AppInfoBean.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/info/AppInfoBean.java)

| 方法 | 注释 |
| :- | :- |
| obtain | 获取 AppInfoBean |
| getAppPackName | 获取 APP 包名 |
| getAppName | 获取 APP 应用名 |
| getAppIcon | 获取 APP 图标 |
| getAppType | 获取 APP 类型 |
| getVersionCode | 获取 versionCode |
| getVersionName | 获取 versionName |
| getFirstInstallTime | 获取 APP 首次安装时间 |
| getLastUpdateTime | 获取 APP 最后更新时间 |
| getSourceDir | 获取 APK 地址 |
| getApkSize | 获取 APK 大小 |
| isSystemApp | 是否系统程序 |
| isSystemUpdateApp | 是否系统程序被手动更新后, 也成为第三方应用程序 |


* **APP 信息 Item ->** [AppInfoItem.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/info/AppInfoItem.java)

| 方法 | 注释 |
| :- | :- |
| obtain | 获取 AppInfoItem |
| getAppInfoBean | 获取 AppInfoBean |
| getListKeyValues | 获取 List 信息键对值集合 |
| getAppMD5 | 获取 APP MD5 签名 |
| getAppSHA1 | 获取 APP SHA1 签名 |
| getAppSHA256 | 获取 APP SHA256 签名 |
| getMinSdkVersion | 获取 APP 最低支持 Android SDK 版本 |
| getTargetSdkVersion | 获取 APP 兼容 SDK 版本 |
| getApkLength | 获取 APP 安装包大小 |
| getX509Certificate | 获取证书对象 |
| getNotBefore | 获取证书生成日期 |
| getNotAfter | 获取证书有效期 |
| isEffective | 获取证书是否过期 |
| getCertPrincipal | 获取证书发布方 |
| getCertVersion | 获取证书版本号 |
| getCertSigalgname | 获取证书算法名称 |
| getCertSigalgoid | 获取证书算法 OID |
| getCertSerialnumber | 获取证书机器码 |
| getCertDercode | 获取证书 DER 编码 |


* **APP 信息获取工具类 ->** [AppInfoUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/info/AppInfoUtils.java)

| 方法 | 注释 |
| :- | :- |
| getPackageInfoToFile | 通过 APK 路径 初始化 PackageInfo |
| getPackageInfoToPath | 通过 APK 路径 初始化 PackageInfo |
| getPackageInfo | 获取当前应用 PackageInfo |
| getAppInfoBeanToFile | 通过 APK 路径 获取 AppInfoBean |
| getAppInfoBeanToPath | 通过 APK 路径 获取 AppInfoBean |
| getAppInfoBean | 获取当前应用 AppInfoBean |
| getApkInfoItem | 获取 APK 详细信息 |
| getAppInfoItem | 获取 APP 详细信息 |
| getAppLists | 获取全部 APP 列表 |
| getAppPermissionToList | 获取 APP 注册的权限 |
| getAppPermissionToSet | 获取 APP 注册的权限 |
| getAppPermission | 获取 APP 注册的权限 |
| printAppPermission | 打印 APP 注册的权限 |


* **键对值实体类 ->** [KeyValueBean.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/info/KeyValueBean.java)

| 方法 | 注释 |
| :- | :- |
| getKey | 获取 key |
| getValue | 获取 value |
| toString | toString |
| get | 通过 resId 设置 key, 并且初始化 KeyValueBean |


## <span id="devutilsapplogger">**`dev.utils.app.logger`**</span>


* **日志操作类 ( 对外公开直接调用 ) ->** [DevLogger.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/logger/DevLogger.java)

| 方法 | 注释 |
| :- | :- |
| other | 使用单次其他日志配置 |
| getLogConfig | 获取日志配置信息 |
| init | 初始化日志配置信息 ( 使用默认配置 ) |
| d | 打印 Log.DEBUG |
| e | 打印 Log.ERROR |
| w | 打印 Log.WARN |
| i | 打印 Log.INFO |
| v | 打印 Log.VERBOSE |
| wtf | 打印 Log.ASSERT |
| json | 格式化 JSON 格式数据, 并打印 |
| xml | 格式化 XML 格式数据, 并打印 |
| dTag | 打印 Log.DEBUG |
| eTag | 打印 Log.ERROR |
| wTag | 打印 Log.WARN |
| iTag | 打印 Log.INFO |
| vTag | 打印 Log.VERBOSE |
| wtfTag | 打印 Log.ASSERT |
| jsonTag | 格式化 JSON 格式数据, 并打印 |
| xmlTag | 格式化 XML 格式数据, 并打印 |


* **日志操作工具类 ->** [DevLoggerUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/logger/DevLoggerUtils.java)

| 方法 | 注释 |
| :- | :- |
| init | 初始化调用方法 ( 内部已调用 ) |
| getReleaseLogConfig | 获取 Release Log 配置 ( 打印线程信息、显示方法总数 3、从 0 开始、不进行排序、默认只打印 ERROR 级别日志 ) |
| getDebugLogConfig | 获取 Debug Log 配置 ( 打印线程信息、显示方法总数 3、从 0 开始、不进行排序、默认只打印 ERROR 级别日志 ) |
| getSortLogConfig | 获取 Log 配置 ( 打印线程信息、显示方法总数 3、从 0 开始、并且美化日志信息、默认打印 DEBUG 级别及以上日志 ) |
| getLogConfig | 获取 Log 配置 |
| saveErrorLog | 保存异常日志 |
| saveLog | 保存日志 |


## <span id="devutilsapppermission">**`dev.utils.app.permission`**</span>


* **权限常量 ->** [PermissionConstants.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/permission/PermissionConstants.java)

| 方法 | 注释 |
| :- | :- |
| getPermissions | 获取权限组 |


* **权限请求工具类 ->** [PermissionUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/permission/PermissionUtils.java)

| 方法 | 注释 |
| :- | :- |
| permission | 申请权限初始化 |
| callBack | 设置回调方法 |
| setRequestPermissionsResult | 设置是否需要在 Activity 的 onRequestPermissionsResult 回调中, 调用 PermissionUtils.onRequestPermissionsResult(this); |
| request | 请求权限 |
| onRequestPermissionsResult | 请求权限回调 - 需要在 Activity 的 onRequestPermissionsResult 回调中, 调用 PermissionUtils.onRequestPermissionsResult(this); |
| notifyPermissionsChange | 刷新权限改变处理 ( 清空已拒绝的权限记录 ) |
| isGranted | 判断是否授予了权限 |
| shouldShowRequestPermissionRationale | 是否拒绝了权限 - 拒绝过一次, 再次申请时, 弹出选择不再提醒并拒绝才会触发 true |
| getAllPermissionToSet | 获取全部权限 |
| getAllPermissionToList | 获取全部权限 |
| getAppPermissionToList | 获取 APP 注册的权限 |
| getAppPermissionToSet | 获取 APP 注册的权限 |
| getAppPermission | 获取 APP 注册的权限 |


## <span id="devutilsappplayer">**`dev.utils.app.player`**</span>


* **MediaPlayer 统一管理类 ->** [DevMediaManager.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/player/DevMediaManager.java)

| 方法 | 注释 |
| :- | :- |
| getInstance | 获取 DevMediaManager 实例 |
| setAudioStreamType | 设置流类型 |
| playPrepareRaw | 播放 Raw 资源 |
| playPrepareAssets | 播放 Assets 资源 |
| playPrepare | 预加载播放 - (file-path or http/rtsp URL) http 资源、本地资源 |
| isPlaying | 是否播放中 |
| pause | 暂停操作 |
| stop | 停止操作 - 销毁 MediaPlayer |
| isIgnoreWhat | 是否忽略错误类型 |
| setMeidaListener | 设置 MediaPlayer 回调事件 |
| isNullMediaPlayer | 判断 MediaPlayer 是否为 null |
| isNotNullMediaPlayer | 判断 MediaPlayer 是否不为 null |
| getMediaPlayer | 获取 MediaPlayer 对象 |
| setMediaPlayer | 设置 MediaPlayer 对象 |
| setTAG | 设置日志打印 TAG |
| getVolume | 获取播放音量 |
| setVolume | 设置播放音量 |
| getPlayRawId | 获取播放资源 id |
| getPlayUri | 获取播放地址 |
| getVideoWidth | 获取视频宽度 |
| getVideoHeight | 获取视频高度 |
| getCurrentPosition | 获取播放时间 |
| getDuration | 获取资源总时间 |
| getPlayPercent | 获取播放进度百分比 |


* **视频播放控制器 ->** [DevVideoPlayerControl.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/player/DevVideoPlayerControl.java)

| 方法 | 注释 |
| :- | :- |
| setMediaListener | 设置播放监听事件 |
| pausePlayer | 暂停播放 |
| stopPlayer | 停止播放 |
| startPlayer | 开始播放 |
| getSurfaceview | 获取 SurfaceView |
| isPlaying | 是否播放中 |
| isAutoPlay | 判断是否自动播放 |
| setAutoPlay | 设置自动播放 |
| getPlayUri | 获取播放地址 |
| getVideoWidth | 获取视频宽度 |
| getVideoHeight | 获取视频高度 |
| getCurrentPosition | 获取播放时间 |
| getDuration | 获取资源总时间 |
| getPlayPercent | 获取播放进度百分比 |


## <span id="devutilsappshare">**`dev.utils.app.share`**</span>


* **SPUtils 工具类 ( 单独使用 ) ->** [SharedUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/share/SharedUtils.java)

| 方法 | 注释 |
| :- | :- |
| init | 初始化操作 ( 内部已调用 ) |
| put | 保存数据 |
| putAll | 保存 Map 集合 ( 只能是 Integer、Long、Boolean、Float、String、Set) |
| get | 根据 key 获取数据 |
| getAll | 获取全部数据 |
| remove | 移除数据 |
| removeAll | 移除集合的数据 |
| contains | 是否存在 key |
| clear | 清除全部数据 |
| getInt | 获取 int 类型的数据 |
| getFloat | 获取 float 类型的数据 |
| getLong | 获取 long 类型的数据 |
| getBoolean | 获取 boolean 类型的数据 |
| getString | 获取 String 类型的数据 |
| getSet | 获取 Set 类型的数据 |


## <span id="devutilsapptoast">**`dev.utils.app.toast`**</span>


* **自定义 View 着色美化 Toast 工具类 ->** [ToastTintUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/toast/ToastTintUtils.java)

| 方法 | 注释 |
| :- | :- |
| reset | 重置默认参数 |
| setToastFilter | 设置 Toast 过滤器 |
| setIsHandler | 设置是否使用 Handler 显示 Toast |
| setNullText | 设置 Text 为 null 的文本 |
| setUseConfig | 设置是否使用配置 |
| setGravity | 设置 Toast 显示在屏幕上的位置 |
| setMargin | 设置边距 |
| getDefaultStyle | 获取默认样式 |
| getNormalStyle | 获取 Normal 样式 |
| getInfoStyle | 获取 Info 样式 |
| getWarningStyle | 获取 Warning 样式 |
| getErrorStyle | 获取 Error 样式 |
| getSuccessStyle | 获取 Success 样式 |
| setNormalStyle | 设置 Normal 样式 |
| setInfoStyle | 设置 Info 样式 |
| setWarningStyle | 设置 Warning 样式 |
| setErrorStyle | 设置 Error 样式 |
| setSuccessStyle | 设置 Success 样式 |
| getInfoDrawable | 获取 Info 样式 icon |
| getWarningDrawable | 获取 Warning 样式 icon |
| getErrorDrawable | 获取 Error 样式 icon |
| getSuccessDrawable | 获取 Success 样式 icon |
| normal | normal 样式 Toast |
| info | info 样式 Toast |
| warning | warning 样式 Toast |
| error | error 样式 Toast |
| success | success 样式 Toast |
| custom | custom Toast |


* **Simple Toast 工具类 ( 简单的 Toast 工具类, 支持子线程弹出 Toast) ->** [ToastUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/toast/ToastUtils.java)

| 方法 | 注释 |
| :- | :- |
| reset | 重置默认参数 |
| setToastFilter | 设置 Toast 过滤器 |
| setIsHandler | 设置是否使用 Handler 显示 Toast |
| setNullText | 设置 Text 为 null 的文本 |
| setUseConfig | 设置是否使用配置 |
| setGravity | 设置 Toast 显示在屏幕上的位置 |
| setMargin | 设置边距 |
| showShort | 显示 LENGTH_SHORT Toast |
| showLong | 显示 LENGTH_LONG Toast |
| showToast | 显示 Toast |
| showShortNew | 显示 new LENGTH_SHORT Toast |
| showLongNew | 显示 new LENGTH_LONG Toast |
| showToastNew | 显示新的 Toast |
| newToastText | 获取一个新的 Text Toast |
| showToastView | 显示 View Toast 方法 |
| newToastView | 获取一个新的 View Toast |


## <span id="devutilsapptoasttoaster">**`dev.utils.app.toast.toaster`**</span>


* **Toast 工具类 ( 支持子线程弹出 Toast, 处理无通知权限 ) ->** [DevToast.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/toast/toaster/DevToast.java)

| 方法 | 注释 |
| :- | :- |
| reset | 重置默认参数 |
| setIsHandler | 设置是否使用 Handler 显示 Toast |
| setNullText | 设置 Text 为 null 的文本 |
| setTextLength | 设置 Toast 文案长度转换 显示时间 |
| init | Application 初始化调用 ( 内部已调用 ) |
| style | 使用单次 Toast 样式配置 |
| defaultStyle | 使用默认 Toast 样式 |
| getToastStyle | 获取 Toast 样式配置 |
| initStyle | 初始化 Toast 样式配置 |
| initToastFilter | 初始化 Toast 过滤器 |
| setView | 设置 Toast 显示的 View |
| show | 显示 Toast |
| cancel | 取消当前显示的 Toast |


## <span id="devutilsappwifi">**`dev.utils.app.wifi`**</span>


* **Wifi 热点工具类 ->** [WifiHotUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/wifi/WifiHotUtils.java)

| 方法 | 注释 |
| :- | :- |
| createWifiConfigToAp | 创建 wifi 热点配置 ( 支持 无密码 /WPA2 PSK) |
| stratWifiAp | 开启 wifi 热点 |
| closeWifiAp | 关闭 wifi 热点 |
| getWifiApState | 获取 wifi 热点状态 |
| getWifiApConfiguration | 获取 wifi 热点配置信息 |
| setWifiApConfiguration | 设置 wifi 热点配置信息 |
| isOpenWifiAp | 判断是否打开 wifi 热点 |
| closeWifiApCheck | 关闭 wifi 热点 ( 判断当前状态 ) |
| isConnectHot | 是否有设备连接热点 |
| getHotspotServiceIp | 获取热点主机 IP 地址 |
| getHotspotAllotIp | 获取连接上的子网关热点 IP ( 一个 ) |
| getConnectHotspotMsg | 获取连接的热点信息 |
| getHotspotSplitIpMask | 获取热点拼接后的 IP 网关掩码 |
| getApWifiSSID | 获取 wifi 热点名 |
| getApWifiPwd | 获取 wifi 热点密码 |
| setOnWifiAPListener | 设置 wifi 热点监听事件 |


* **Wifi 工具类 ->** [WifiUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/app/wifi/WifiUtils.java)

| 方法 | 注释 |
| :- | :- |
| getWifiManager | 获取 WifiManager |
| isOpenWifi | 判断是否打开 wifi |
| openWifi | 打开 wifi |
| closeWifi | 关闭 wifi |
| toggleWifiEnabled | 自动切换 wifi 开关状态 |
| getWifiState | 获取当前 wifi 连接状态 |
| startScan | 开始扫描 wifi |
| getConfiguration | 获取已配置 ( 连接过 ) 的 wifi 配置 |
| getWifiList | 获取附近的 wifi 列表 |
| getWifiInfo | 获取连接的 WifiInfo |
| getMacAddress | 获取 MAC 地址 |
| getBSSID | 获取连接的 BSSID |
| getIPAddress | 获取 IP 地址 |
| getNetworkId | 获取连接的 Network Id |
| getSSID | 获取 wifi SSID |
| formatSSID | 判断是否存在 \"ssid\", 存在则裁剪返回 |
| getPassword | 获取处理后的密码 |
| isHexWepKey | 判断是否 wep 加密 |
| getWifiType | 获取加密类型 |
| getWifiTypeInt | 获取加密类型 |
| getWifiTypeStr | 获取加密类型 |
| isConnNull | 判断是否连接为 null - unknown ssid |
| isConnectAphot | 获取连接的 wifi 热点 SSID |
| getSecurity | 获取 wifi 加密类型 |
| isExistsPwd | 判断 wifi 加密类型, 是否为加密类型 |
| isExists | 获取指定的 ssid 网络配置 ( 需连接保存过, 才存在 ) |
| delWifiConfig | 删除指定的 wifi(SSID) 配置信息 |
| quickConnWifi | 快速连接 wifi ( 不使用静态 IP 方式 ) |
| createWifiConfig | 创建 wifi 配置信息 |
| removeWifiConfig | 移除 wifi 配置信息 |
| disconnectWifi | 断开指定 networkId 的网络 |


## <span id="devutilscommon">**`dev.utils.common`**</span>


* **Array 数组工具类 ->** [ArrayUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ArrayUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断数组是否为 null |
| isNotEmpty | 判断数组是否不为 null |
| length | 获取数组长度 |
| isLength | 判断数组长度是否等于期望长度 |
| get | 获取数组对应索引数据 |
| getFirst | 获取数组第一条数据 |
| getLast | 获取数组最后一条数据 |
| getPosition | 根据指定值获取 value 所在位置 + 偏移量的索引 |
| getNotNull | 根据指定 value 获取 value 所在位置 + 偏移量的值, 不允许值为 null |
| getPositionNotNull | 根据指定 value 获取索引, 不允许值为 null |
| intsToIntegers | int[] 转换 Integer[] |
| bytesToBytes | byte[] 转换 Byte[] |
| charsToCharacters | char[] 转换 Character[] |
| shortsToShorts | short[] 转换 Short[] |
| longsToLongs | long[] 转换 Long[] |
| floatsToFloats | float[] 转换 Float[] |
| doublesToDoubles | double[] 转换 Double[] |
| booleansToBooleans | boolean[] 转换 Boolean[] |
| integersToInts | Integer[] 转换 int[] |
| charactersToChars | Character[] 转换 char[] |
| asList | 转换数组为集合 |
| equals | 判断两个值是否一样 |
| arraycopy | 拼接数组 |
| newarray | 创建指定长度数组 |
| subarray | 从数组上截取一段 |
| appendToString | 追加数组内容字符串 |


* **资金运算工具类 ->** [BigDecimalUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/BigDecimalUtils.java)

| 方法 | 注释 |
| :- | :- |
| add | 提供精确的加法运算 |
| substract | 提供精确的减法运算 |
| multiply | 提供精确的乘法运算 |
| divide | 提供 ( 相对 ) 精确的除法运算 |
| round | 提供精确的小数位四舍五入处理 |
| remainder | 取余数 |
| compare | 比较大小 |
| formatMoney | 金额分割, 四舍五入金额 |
| adjustDouble | 获取自己想要的数据格式 |


* **类 (Class) 工具类 ->** [ClassUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ClassUtils.java)

| 方法 | 注释 |
| :- | :- |
| isBaseDataType | 判断类是否是基础数据类型 - 目前支持 11 种 |
| newInstance | 根据类获取对象, 不再必须一个无参构造 |
| getDefaultPrimiticeValue | 判断 Class 是否为原始类型 (boolean、char、byte、short、int、long、float、double) |
| isCollection | 判断是否集合类型 |
| isArray | 判断是否数组类型 |
| getGenericSuperclass | 获取父类泛型类型 |
| getGenericInterfaces | 获取接口泛型类型 |


* **克隆工具类 ->** [CloneUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/CloneUtils.java)

| 方法 | 注释 |
| :- | :- |
| deepClone | 进行克隆 |
| serializableToBytes | 通过序列化实体类, 获取对应的 byte[] 数据 |


* **关闭 (IO 流 ) 工具类 ->** [CloseUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/CloseUtils.java)

| 方法 | 注释 |
| :- | :- |
| closeIO | 关闭 IO |
| closeIOQuietly | 安静关闭 IO |


* **集合工具类 (Collection - List、Set、Queue) 等 ->** [CollectionUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/CollectionUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断 Collection 是否为 null |
| isNotEmpty | 判断 Collection 是否不为 null |
| length | 获取 Collection 长度 |
| isLength | 获取长度 to Collection 是否等于期望长度 |
| greaterThan | 判断 Collection 长度是否大于指定长度 |
| greaterThanOrEqual | 判断 Collection 长度是否大于等于指定长度 |
| lessThan | 判断 Collection 长度是否小于指定长度 |
| lessThanOrEqual | 判断 Collection 长度是否小于等于指定长度 |
| get | 获取数据 |
| getFirst | 获取第一条数据 |
| getLast | 获取最后一条数据 |
| getPosition | 根据指定 value 获取 value 所在位置 + 偏移量的索引 |
| getPositionNotNull | 根据指定 value 获取索引, 不允许值为 null |
| getNext | 根据指定 value 获取 value 所在位置的下一个值 |
| getNextNotNull | 根据指定 value 获取 value 所在位置的下一个值, 不允许值为 null |
| getPrevious | 根据指定 value 获取 value 所在位置的上一个值 |
| getPreviousNotNull | 根据指定 value 获取 value 所在位置的上一个值, 不允许值为 null |
| add | 添加一条数据 |
| addNotNull | 添加一条数据 - value 不允许为 null |
| addAll | 添加集合数据 |
| addAllNotNull | 添加集合数据 - values 内的值不允许为 null |
| remove | 移除一条数据 |
| removeAll | 移除集合数据 |
| clear | 清空集合中符合指定 value 的全部数据 |
| clearNotBelong | 保留集合中符合指定 value 的全部数据 |
| clearAll | 清空集合全部数据 |
| clearNull | 清空集合中为 null 的值 |
| isEqualCollection | 判断两个集合是否相同 |
| isEqualCollections | 判断多个集合是否相同 |
| union | 两个集合并集处理 |
| unions | 多个集合并集处理 |
| intersection | 两个集合交集处理 |
| disjunction | 两个集合交集的补集处理 |
| subtract | 两个集合差集 ( 扣除 ) 处理 |
| equals | 判断两个值是否一样 |
| toArray | 转换数组 to Object |
| reverse | 集合翻转处理 |


* **颜色工具类 ( 包括常用的色值 ) ->** [ColorUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ColorUtils.java)

| 方法 | 注释 |
| :- | :- |
| toHexAlpha | 获取十六进制透明度字符串 |
| alpha | 返回一个颜色中的透明度值 ( 返回十进制 ) |
| alphaPercent | 返回一个颜色中的透明度百分比值 |
| red | 返回一个颜色中红色的色值 ( 返回十进制 ) |
| redPercent | 返回一个颜色中红色的百分比值 |
| green | 返回一个颜色中绿色的色值 ( 返回十进制 ) |
| greenPercent | 返回一个颜色中绿色的百分比值 |
| blue | 返回一个颜色中蓝色的色值 ( 返回十进制 ) |
| bluePercent | 返回一个颜色中蓝色的百分比值 |
| rgb | 根据对应的 red、green、blue 生成一个颜色值 |
| argb | 根据对应的 alpha、red、green、blue 生成一个颜色值 ( 含透明度 ) |
| isRGB | 判断颜色 RGB 是否有效 |
| isARGB | 判断颜色 ARGB 是否有效 |
| setAlpha | 设置透明度 |
| setRed | 改变颜色值中的红色色值 |
| setGreen | 改变颜色值中的绿色色值 |
| setBlue | 改变颜色值中的蓝色色值 |
| parseColor | 解析颜色字符串, 返回对应的颜色值 |
| intToRgbString | 颜色值 转换 RGB 颜色字符串 |
| intToArgbString | 颜色值 转换 ARGB 颜色字符串 |
| getRandomColor | 获取随机颜色值 |
| judgeColorString | 判断是否为 ARGB 格式的十六进制颜色, 例如: FF990587 |
| setDark | 颜色加深 ( 单独修改 RGB 值, 不变动透明度 ) |
| setLight | 颜色变浅, 变亮 ( 单独修改 RGB 值, 不变动透明度 ) |
| setAlphaDark | 设置透明度加深 |
| setAlphaLight | 设置透明度变浅 |


* **转换工具类 (Byte、Hex 等 ) ->** [ConvertUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ConvertUtils.java)

| 方法 | 注释 |
| :- | :- |
| toString | char[] 转 String |
| toInt | 字符串 转 int |
| toBoolean | 字符串 转 boolean |
| toFloat | 字符串 转 float |
| toDouble | 字符串 转 double |
| toLong | 字符串 转 long |
| toShort | 基本类型对象 转 short |
| toChar | 基本类型对象 转 char |
| toByte | 基本类型对象 转 byte |
| toCharInt | char 转换 unicode 编码 |
| toChars | 字符串 获取 char[] |
| toBytes | 字符串 获取 byte[] |
| parseInt | 字符串转换对应的进制 |
| parseLong | 字符串转换对应的进制 |
| bytesToObject | byte[] 转为 Object |
| objectToBytes | Object 转为 byte[] |
| bytesToChars | byte[] 转换 char[], 并且进行补码 |
| charsToBytes | char[] 转换 byte[] |
| intsToStrings | int[] 转换 string[] |
| doublesToStrings | double[] 转换 string[] |
| longsToStrings | long[] 转换 string[] |
| floatsToStrings | float[] 转换 string[] |
| intsToDoubles | int[] 转换 double[] |
| intsToLongs | int[] 转换 long[] |
| intsToFloats | int[] 转换 float[] |
| stringsToInts | string[] 转换 int[] |
| stringsToDoubles | string[] 转换 double[] |
| stringsToLongs | string[] 转换 long[] |
| stringsToFloats | string[] 转换 float[] |
| doublesToInts | double[] 转换 int[] |
| longsToInts | long[] 转换 int[] |
| floatsToInts | float[] 转换 int[] |
| toBinaryString | 将 字节转换 为 二进制字符串 |
| decodeBinary | 二进制字符串 转换 byte[] 解码 |
| isHex | 判断是否十六进制数据 |
| decodeHex | 将十六进制字节数组解码 |
| hexToInt | 十六进制 char 转换 int |
| toHexString | int 转换十六进制 |
| toHexChars | 将 string 转换为 十六进制 char[] |
| bytesBitwiseAND | 按位求补 byte[] 位移编解码 ( 共用同一个方法 ) |


* **坐标 (GPS 纠偏 ) 相关工具类 ->** [CoordinateUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/CoordinateUtils.java)

| 方法 | 注释 |
| :- | :- |
| bd09ToGcj02 | BD09 坐标转 GCJ02 坐标 |
| gcj02ToBd09 | GCJ02 坐标转 BD09 坐标 |
| gcj02ToWGS84 | GCJ02 坐标转 WGS84 坐标 |
| wgs84ToGcj02 | WGS84 坐标转 GCJ02 坐标 |
| bd09ToWGS84 | BD09 坐标转 WGS84 坐标 |
| wgs84ToBd09 | WGS84 坐标转 BD09 坐标 |
| outOfChina | 判断是否中国境外 |


* **日期工具类 ->** [DateUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/DateUtils.java)

| 方法 | 注释 |
| :- | :- |
| getDateNow | 获取当前日期的字符串 - yyyy-MM-dd HH:mm:ss |
| formatTime | 将时间戳转换日期字符串 |
| formatDate | 将 Date 转换日期字符串 |
| parseDate | 将时间戳转换成 Date |
| parseLong | 解析时间字符串转换为 long 毫秒 - 默认表示 time 属于 yyyy-MM-dd HH:mm:ss 格式 |
| parseToString | 转换时间为指定字符串 |
| getTimeDiffMinute | 获取时间差 - 分钟 |
| getTimeDiffHour | 获取时间差 - 小时 |
| getTimeDiffDay | 获取时间差 - 天 |
| getTimeDiff | 获取时间差 - ( 传入时间 - 当前时间 ) |
| getYear | 获取年 |
| getMonth | 获取月 (0 - 11) + 1 |
| getDay | 获取日 |
| getWeek | 获取日期是星期几 |
| get24Hour | 获取时 - 24 |
| get12Hour | 获取时 - 12 |
| getMinute | 获取分 |
| getSecond | 获取秒 |
| convertTime | 转换时间处理, 小于 10, 则自动补充 0x |
| isLeapYear | 判断是否闰年 |
| getMonthDayNumberAll | 根据年份、月份, 获取对应的天数 ( 完整天数, 无判断是否属于未来日期 ) |
| getYearMonthNumber | 根据年份, 获取对应的月份 |
| getMonthDayNumber | 根据年份、月份, 获取对应的天数 |
| getArrayToHH | 生成 HH 按时间排序数组 |
| getListToHH | 生成 HH 按时间排序集合 |
| getArrayToMM | 生成 MM 按时间排序数组 |
| getListToMM | 生成 MM 按时间排序集合 |
| getArrayToHHMM | 生成 HH:mm 按间隔时间排序数组 |
| getListToHHMM | 生成 HH:mm 按间隔时间排序集合 |
| getListToHHMMPosition | 获取 HH:mm 按间隔时间排序的集合中, 指定时间所在索引 |
| secToTimeRetain | 传入时间, 获取时间 (00:00:00 格式 ) - 不处理大于一天 |
| convertTimeArys | 传入时间, 时间参数 ( 小时、分钟、秒 ) |
| millisToFitTimeSpan | 转换时间 |
| millisToTimeArys | 转换时间为数组 |
| isInTimeHHmm | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| isInTimeHHmmss | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| isInTime | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| isInDate | 判断时间是否在 [startTime, endTime] 区间, 注意时间格式要一致 |
| getEndTimeDiffHHmm | 获取指定时间距离该时间第二天的指定时段的时间 ( 判断凌晨情况 ) |
| getEndTimeDiff | 获取指定时间距离该时间第二天的指定时段的时间差 ( 判断凌晨情况 ) |


* **开发常用方法工具类 ->** [DevCommonUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/DevCommonUtils.java)

| 方法 | 注释 |
| :- | :- |
| timeRecord | 耗时时间记录 |
| getOperateTime | 获取操作时间 |
| sleepOperate | 堵塞操作 |
| isHttpRes | 判断是否网络资源 |
| whileMD5 | 循环 MD5 加密处理 |
| randomUUID | 获取随机唯一数 |
| randomUUIDToHashCode | 获取随机唯一数 HashCode |
| getRandomUUID | 获取随机规则生成 UUID |
| getRandomUUIDToString | 获取随机规则生成 UUID 字符串 |
| converHideMobile | 转换手机号 |
| converSymbolHide | 转换符号处理 |
| subEllipsize | 裁剪超出的内容, 并且追加符号 ( 如 ...) |
| subSymbolHide | 裁剪符号处理 |
| substring | 裁剪字符串 |
| toReplaceSEWith | 替换 ( 删除 - 替换成 "") 字符串中符合 特定标记字符的 startsWith - endsWith |
| toReplaceStartsWith | 替换开头字符串 |
| toReplaceEndsWith | 替换结尾字符串 |
| toClearSEWiths | 这个方法功能主要把字符符合标记的 头部和尾部都替换成 "" |
| toClearStartsWith | 清空属于特定字符串开头的字段 |
| toClearEndsWith | 清空属于特定字符串结尾的字段 |
| replaceStr | 替换字符串 |
| replaceStrToNull | 替换字符串 |
| replaceStrs | 替换字符串 |
| isEmpty | 判断数组是否为 null |
| isNotEmpty | 判断数组是否不为 null |
| length | 获取数组长度 |
| isLength | 判断数组长度是否等于期望长度 |
| equals | 判断两个值是否一样 |
| isEquals | 判断多个字符串是否相等, 只有全相等才返回 true - 对比大小写 |
| isOrEquals | 判断多个字符串, 只要有一个符合条件则通过 |
| isContains | 判断一堆值中, 是否存在符合该条件的 ( 包含 ) |
| isStartsWith | 判断内容, 是否属于特定字符串开头 - 对比大小写 |
| isEndsWith | 判断内容, 是否属于特定字符串结尾 - 对比大小写 |
| isSpace | 判断字符串是否为 null 或全为空白字符 |
| toClearSpace | 清空字符串全部空格 |
| toClearSpaceTrim | 清空字符串前后所有空格 |
| appendSpace | 追加空格 |
| appendTab | 追加 Tab |
| appendLine | 追加换行 |
| toCheckValue | 检查字符串 |
| toCheckValues | 检查字符串 - 多个值 |
| toCheckValuesSpace | 检查字符串 - 多个值 ( 删除前后空格对比判断 ) |
| getFormatString | 获取格式化后的字符串 |
| getAutoFormatString | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| getAutoFormatString2 | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| appends | StringBuilder 拼接处理 |


* **编码工具类 ->** [EncodeUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/EncodeUtils.java)

| 方法 | 注释 |
| :- | :- |
| base64Encode | Base64 编码 |
| base64EncodeToString | Base64 编码 |
| base64Decode | Base64 解码 |
| base64DecodeToString | Base64 解码 |
| htmlEncode | Html 字符串编码 |


* **变量字段工具类 ->** [FieldUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/FieldUtils.java)

| 方法 | 注释 |
| :- | :- |
| isSerializable | 判断是否序列化 |
| set | 设置字段的值 |
| get | 获取字段的值 |
| isLong | 是否 long/Long 类型 |
| isFloat | 是否 float/Float 类型 |
| isDouble | 是否 double/Double 类型 |
| isInteger | 是否 int/Integer 类型 |
| isString | 是否 String 类型 |
| getGenericType | 获取字段的泛型类型, 如果不带泛型返回 null |
| getComponentType | 获取数组的类型 |
| getAllDeclaredFields | 获取全部 Field, 包括父类 |
| isInvalid | 是静态常量或者内部结构属性 |


* **文件 (IO 流 ) 工具类 ->** [FileIOUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/FileIOUtils.java)

| 方法 | 注释 |
| :- | :- |
| setBufferSize | 设置缓冲区的大小, 默认大小等于 8192 字节 |
| writeFileFromIS | 通过输入流写入文件 |
| writeFileFromBytesByStream | 通过字节流写入文件 |
| writeFileFromBytesByChannel | 通过 FileChannel 把字节流写入文件 |
| writeFileFromBytesByMap | 通过 MappedByteBuffer 把字节流写入文件 |
| writeFileFromString | 通过字符串写入文件 |
| readFileToList | 读取文件内容, 返回换行 List |
| readFileToString | 读取文件内容, 返回字符串 |
| readFileToBytesByStream | 读取文件内容, 返回 byte[] |
| readFileToBytesByChannel | 通过 FileChannel, 读取文件内容, 返回 byte[] |
| readFileToBytesByMap | 通过 MappedByteBuffer, 读取文件内容, 返回 byte[] |


* **文件操作工具类 ->** [FileUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/FileUtils.java)

| 方法 | 注释 |
| :- | :- |
| getFile | 获取文件 |
| getFileByPath | 获取文件 |
| getFileCreateFolder | 获取路径, 并且进行创建目录 |
| getFilePathCreateFolder | 获取路径, 并且进行创建目录 |
| createFolder | 判断某个文件夹是否创建, 未创建则创建 ( 纯路径 - 无文件名 ) |
| createFolderByPath | 创建文件夹目录 - 可以传入文件名 |
| createFolderByPaths | 创建多个文件夹, 如果不存在则创建 |
| createOrExistsDir | 判断目录是否存在, 不存在则判断是否创建成功 |
| createOrExistsFile | 判断文件是否存在, 不存在则判断是否创建成功 |
| createFileByDeleteOldFile | 判断文件是否存在, 存在则在创建之前删除 |
| getPath | 获取文件路径 |
| getAbsolutePath | 获取文件绝对路径 |
| getName | 获取文件名 |
| getFileSuffix | 获取文件后缀名 ( 无 "." 单独后缀 ) |
| getFileNotSuffix | 获取文件名 ( 无后缀 ) |
| getFileNotSuffixToPath | 获取文件名 ( 无后缀 ) |
| getFileNameNoExtension | 获取路径中的不带拓展名的文件名 |
| getFileExtension | 获取路径中的文件拓展名 |
| isFileExists | 检查是否存在某个文件 |
| isFile | 判断是否文件 |
| isDirectory | 判断是否文件夹 |
| isHidden | 判断是否隐藏文件 |
| getFileLastModified | 获取文件最后修改的毫秒时间戳 |
| getFileCharsetSimple | 获取文件编码格式 |
| getFileLines | 获取文件行数 |
| getFileSize | 获取文件大小 |
| getDirSize | 获取目录大小 |
| getFileLength | 获取文件大小 |
| getDirLength | 获取目录全部文件大小 |
| getFileLengthNetwork | 获取文件大小 - 网络资源 |
| getFileName | 获取路径中的文件名 |
| getDirName | 获取路径中的最长目录地址 |
| rename | 重命名文件 - 同个目录下, 修改文件名 |
| formatFileSize | 传入文件路径, 返回对应的文件大小 |
| formatByteMemorySize | 字节数转合适内存大小 保留 3 位小数 (%.位数f) |
| deleteFile | 删除文件 |
| deleteFiles | 删除多个文件 |
| deleteFolder | 删除文件夹 |
| saveFile | 保存文件 |
| appendFile | 追加文件 ( 使用 FileWriter) |
| readFileBytes | 读取文件 |
| readFile | 读取文件 |
| copyFile | 复制单个文件 |
| copyFolder | 复制文件夹 |
| moveFile | 移动 ( 剪切 ) 文件 |
| moveFolder | 移动 ( 剪切 ) 文件夹 |
| copyOrMoveDir | 复制或移动目录 |
| copyOrMoveFile | 复制或移动文件 |
| copyDir | 复制目录 |
| moveDir | 移动目录 |
| deleteDir | 删除目录 |
| deleteAllInDir | 删除目录下所有东西 |
| deleteFilesInDir | 删除目录下所有文件 |
| deleteFilesInDirWithFilter | 删除目录下所有过滤的文件 |
| listFilesInDir | 获取目录下所有文件 - 不递归进子目录 |
| listFilesInDirWithFilter | 获取目录下所有过滤的文件 - 不递归进子目录 |
| getFileMD5 | 获取文件 MD5 值 |
| getFileMD5ToHexString | 获取文件 MD5 值 - 小写 |


* **Http 参数工具类 ->** [HttpParamsUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/HttpParamsUtils.java)

| 方法 | 注释 |
| :- | :- |
| splitParams | 拆分参数 |
| joinParams | 拼接请求参数 - value(String) |
| joinParamsObj | 拼接请求参数 - value(Object) |
| printMapParams | 拼接打印 Map 参数 |
| toConvertObjToMS | 进行转换对象处理 ( 请求发送对象 ) |
| toConvertObjToMO | 进行转换对象处理 ( 请求发送对象 ) |
| toUrlEncode | 进行 URL 编码, 默认 UTF-8 |


* **HttpURLConnection 网络工具类 ->** [HttpURLConnectionUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/HttpURLConnectionUtils.java)

| 方法 | 注释 |
| :- | :- |
| doGetAsyn | 异步的 Get 请求 |
| doPostAsyn | 异步的 Post 请求 |
| request | 发送请求 |
| getNetTime | 获取网络时间 - 默认使用百度链接 |


* **Map 工具类 ->** [MapUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/MapUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断 Map 是否为 null |
| isNotEmpty | 判断 Map 是否不为 null |
| length | 获取 Map 长度 |
| isLength | 获取长度 to Map 是否等于期望长度 |
| greaterThan | 判断 Map 长度是否大于指定长度 |
| greaterThanOrEqual | 判断 Map 长度是否大于等于指定长度 |
| lessThan | 判断 Map 长度是否小于指定长度 |
| lessThanOrEqual | 判断 Map 长度是否小于等于指定长度 |
| get | 获取 value |
| getKeyByValue | 通过 value 获取 key |
| getKeysByValue | 通过 value 获取 key 集合 ( 返回等于 value 的 key 集合 ) |
| getKeys | 通过 Map 获取 key 集合 |
| getKeysToArrays | 通过 Map 获取 key 数组 |
| getValues | 通过 Map 获取 value 集合 |
| getValuesToArrays | 通过 Map 获取 value 数组 |
| getFirst | 获取第一条数据 |
| getLast | 获取最后一条数据 |
| getNext | 根据指定 key 获取 key 所在位置的下一条数据 |
| getPrevious | 根据指定 key 获取 key 所在位置的上一条数据 |
| put | 添加一条数据 |
| putNotNull | 添加一条数据, 不允许 key 为 null |
| putAll | 添加多条数据 |
| putAllNotNull | 添加多条数据, 不允许 key 为 null |
| remove | 移除一条数据 |
| removeToKeys | 移除多条数据 |
| removeToValue | 移除等于 value 的所有数据 |
| removeToValues | 移除等于 value 的所有数据 (Collection<Value>) |
| equals | 判断两个值是否一样 |
| toggle | 切换保存状态 |
| isNullToValue | 判断指定 key 的 value 是否为 null |
| containsKey | 判断 Map 是否存储了 key |
| containsValue | 判断 Map 是否存储了 value |
| putToList | 添加一条数据 - (Value) List<T> |
| removeToList | 移除一条数据 - (Value) List<T> |
| removeToLists | 移除多条数据 - (Value) List<T> |
| removeToMap | 移除多条数据 - 通过 Map 进行移除 |


* **数字 ( 计算 ) 工具类 ->** [NumberUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/NumberUtils.java)

| 方法 | 注释 |
| :- | :- |
| percentI | 计算百分比值 ( 最大 100%) |
| percentD | 计算百分比值 ( 最大 100%) |
| percentL | 计算百分比值 ( 最大 100%) |
| percentF | 计算百分比值 ( 最大 100%) |
| percentI2 | 计算百分比值 ( 可超出 100%) |
| percentD2 | 计算百分比值 ( 可超出 100%) |
| percentL2 | 计算百分比值 ( 可超出 100%) |
| percentF2 | 计算百分比值 ( 可超出 100%) |
| clamp | 返回的 value 介于 max、min 之间, 若 value 小于 min, 返回 min, 若大于 max, 返回 max |
| numberToCHN | 数字转中文数值 |
| isNumber | 检验数字 |
| isNumberDecimal | 检验数字或包含小数点 |


* **对象相关工具类 ->** [ObjectUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ObjectUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断对象是否为空 |
| isNotEmpty | 判断对象是否非空 |
| equals | 判断两个值是否一样 |
| requireNonNull | 检查对象是否为 null, 为 null 则抛出异常, 不为 null 则返回该对象 |
| getOrDefault | 获取非空或默认对象 |
| hashCode | 获取对象哈希值 |
| getObjectTag | 获取一个对象的独一无二的标记 |
| converObj | 获取转换对象 |


* **随机工具类 ->** [RandomUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/RandomUtils.java)

| 方法 | 注释 |
| :- | :- |
| nextBoolean | 获取伪随机 boolean 值 |
| nextBytes | 获取伪随机 byte[] |
| nextDouble | 获取伪随机 double 值 |
| nextGaussian | 获取伪随机高斯分布值 |
| nextFloat | 获取伪随机 float 值 |
| nextInt | 获取伪随机 int 值 |
| nextLong | 获取伪随机 long 值 |
| getRandomNumbers | 获取数字自定义长度的随机数 |
| getRandomLowerCaseLetters | 获取小写字母自定义长度的随机数 |
| getRandomCapitalLetters | 获取大写字母自定义长度的随机数 |
| getRandomLetters | 获取大小写字母自定义长度的随机数 |
| getRandomNumbersAndLetters | 获取数字、大小写字母自定义长度的随机数 |
| getRandom | 获取自定义数据自定义长度的随机数 |
| shuffle | 洗牌算法 ( 第一种 ), 随机置换指定的数组使用的默认源的随机性 ( 随机数据源小于三个, 则无效 ) |
| shuffle2 | 洗牌算法 ( 第二种 ), 随机置换指定的数组使用的默认源的随机性 |
| nextIntRange | 获取指定范围 int 值 |
| nextLongRange | 获取指定范围 long 值 |
| nextDoubleRange | 获取指定范围 double 值 |
| ints | 获取随机 int[] |
| longs | 获取随机 long[] |
| doubles | 获取随机 double[] |


* **反射相关工具类 ->** [Reflect2Utils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/Reflect2Utils.java)

| 方法 | 注释 |
| :- | :- |
| setProperty | 设置某个对象变量值 ( 可设置静态变量 ) |
| getProperty | 获取某个对象的变量 ( 可获取静态变量 ) |
| getStaticProperty | 获取某个类的静态变量 ( 只能获取静态变量 ) |
| invokeMethod | 执行某个对象方法 ( 可执行静态方法 ) |
| invokeStaticMethod | 执行某个类的静态方法 ( 只能执行静态方法 ) |
| newInstance | 新建实例 ( 构造函数创建 ) |
| isInstance | 是不是某个类的实例 |
| getArgsClass | 获取参数类型 |
| getPropertyByObject | 获取父类中的变量对象 |
| getDeclaredFieldParent | 获取父类中的变量对象 ( 循环向上转型, 获取对象的 DeclaredField) |


* **反射相关工具类 ->** [ReflectUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ReflectUtils.java)

| 方法 | 注释 |
| :- | :- |
| reflect | 设置要反射的类 |
| newInstance | 实例化反射对象 |
| field | 设置反射的字段 |
| setEnumVal | 设置枚举值 |
| method | 设置反射的方法 |
| proxy | 根据类, 代理创建并返回对象 |
| type | 获取类型 |
| get | 获取反射想要获取的 |
| hashCode | 获取 HashCode |
| equals | 判断反射的两个对象是否一样 |
| toString | 获取反射获取的对象 |


* **计算比例工具类 ->** [ScaleUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ScaleUtils.java)

| 方法 | 注释 |
| :- | :- |
| calcScaleToWidth | 计算缩放比例 - 根据宽度比例转换高度 |
| calcScaleToHeight | 计算缩放比例 - 根据高度比例转换宽度 |
| calcWidthHeightToScale | 通过宽度、高度根据对应的比例, 转换成对应的比例宽度高度 - 智能转换 |
| calcWidthToScale | 以宽度为基准, 转换对应比例的高度 |
| calcHeightToScale | 以高度为基准, 转换对应比例的宽度 |


* **流操作工具类 ->** [StreamUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/StreamUtils.java)

| 方法 | 注释 |
| :- | :- |
| inputToOutputStream | 输入流转输出流 |
| outputToInputStream | 输出流转输入流 |
| inputStreamToBytes | 输入流转 byte[] |
| bytesToInputStream | byte[] 转输出流 |
| outputStreamToBytes | 输出流转 byte[] |
| bytesToOutputStream | byte[] 转 输出流 |
| inputStreamToString | 输入流转 String |
| stringToInputStream | String 转换输入流 |
| outputStreamToString | 输出流转 String |
| stringToOutputStream | String 转 输出流 |


* **字符串工具类 ->** [StringUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/StringUtils.java)

| 方法 | 注释 |
| :- | :- |
| isEmpty | 判断字符串是否为 null |
| isNotEmpty | 判断字符串是否不为 null |
| length | 获取字符串长度 |
| isLength | 获取字符串长度 是否等于期望长度 |
| equals | 判断两个值是否一样 |
| isEquals | 判断多个字符串是否相等, 只有全相等才返回 true - 对比大小写 |
| isOrEquals | 判断多个字符串, 只要有一个符合条件则通过 |
| countMatches | 统计字符串匹配个数 |
| countMatches2 | 统计字符串匹配个数 |
| isContains | 判断一堆值中, 是否存在符合该条件的 ( 包含 ) |
| isStartsWith | 判断内容, 是否属于特定字符串开头 - 对比大小写 |
| isEndsWith | 判断内容, 是否属于特定字符串结尾 - 对比大小写 |
| isSpace | 判断字符串是否为 null 或全为空白字符 |
| toClearSpace | 清空字符串全部空格 |
| toClearSpaceTrim | 清空字符串前后所有空格 |
| appendSpace | 追加空格 |
| appendTab | 追加 Tab |
| appendLine | 追加换行 |
| colonSplit | 冒号分割处理 |
| toCheckValue | 检查字符串 |
| toCheckValues | 检查字符串 - 多个值 |
| toCheckValuesSpace | 检查字符串 - 多个值 ( 删除前后空格对比判断 ) |
| getFormatString | 获取格式化后的字符串 |
| getAutoFormatString | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| getAutoFormatString2 | 获取自动数量格式化后的字符串 ( 可变参数 ) |
| appends | StringBuilder 拼接处理 |
| toGBKEncode | 字符串进行 GBK 编码 |
| toGBK2312Encode | 字符串进行 GBK2312 编码 |
| toUTF8Encode | 字符串进行 UTF-8 编码 |
| toStrEncode | 进行字符串编码 |
| toUrlEncode | 进行 URL 编码, 默认 UTF-8 |
| toUrlDecode | 进行 URL 解码, 默认 UTF-8 |
| toASCII | 将字符串转移为 ASCII 码 |
| toUnicode | 将字符串转移为 Unicode 码 |
| toUnicodeString | 将字符数组转移为 Unicode 码 |
| toDBC | 转化为半角字符 |
| toSBC | 转化为全角字符 如: a => ａ A => Ａ |
| checkChineseToString | 检测字符串是否全是中文 |
| isChinese | 判定输入汉字 |
| upperFirstLetter | 首字母大写 |
| lowerFirstLetter | 首字母小写 |
| reverse | 反转字符串 |
| concat | 字符串连接, 将参数列表拼接为一个字符串 |
| concatSpiltWith | 字符串连接, 将参数列表拼接为一个字符串 |
| underScoreCaseToCamelCase | 下划线命名转为驼峰命名 |
| camelCaseToUnderScoreCase | 驼峰命名法转为下划线命名 |
| sqliteEscape | 字符串数据库字符转义 |


* **异常处理工具类 ->** [ThrowableUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ThrowableUtils.java)

| 方法 | 注释 |
| :- | :- |
| getThrowable | 获取异常信息 |
| getThrowableStackTrace | 获取异常栈信息 |


* **压缩相关工具类 ->** [ZipUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/ZipUtils.java)

| 方法 | 注释 |
| :- | :- |
| zipFiles | 批量压缩文件 |
| zipFile | 压缩文件 |
| unzipFile | 解压文件 |
| unzipFileByKeyword | 解压带有关键字的文件 |
| getFilesPath | 获取压缩文件中的文件路径链表 |
| getComments | 获取压缩文件中的注释链表 |


## <span id="devutilscommonassist">**`dev.utils.common.assist`**</span>


* **均值计算 ( 用以统计平均数 ) 辅助类 ->** [Averager.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/assist/Averager.java)

| 方法 | 注释 |
| :- | :- |
| add | 添加一个数字 |
| clear | 清除全部 |
| size | 获取参与均值计算的数字个数 |
| getAverage | 获取平均数 |
| print | 输出参与均值计算的数字 |


* **时间均值计算辅助类 ->** [TimeAverager.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/assist/TimeAverager.java)

| 方法 | 注释 |
| :- | :- |
| start | 开始计时 ( 毫秒 ) |
| end | 结束计时 ( 毫秒 ) |
| endAndRestart | 结束计时, 并重新启动新的计时 |
| average | 求全部计时均值 |
| print | 输出全部时间值 |
| clear | 清除计时数据 |


* **时间计时辅助类 ->** [TimeCounter.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/assist/TimeCounter.java)

| 方法 | 注释 |
| :- | :- |
| start | 开始计时 ( 毫秒 ) |
| durationRestart | 获取持续的时间并重新启动 ( 毫秒 ) |
| duration | 获取持续的时间 ( 毫秒 ) |
| getStartTime | 获取开始时间 ( 毫秒 ) |


* **堵塞时间辅助类 ->** [TimeKeeper.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/assist/TimeKeeper.java)

| 方法 | 注释 |
| :- | :- |
| waitForEndAsyn | 设置等待一段时间后, 通知方法 ( 异步 ) |
| waitForEnd | 设置等待一段时间后, 通知方法 ( 同步 ) |


## <span id="devutilscommonassistsearch">**`dev.utils.common.assist.search`**</span>


* **文件广度优先搜索算法 ( 多线程 + 队列, 搜索某个目录下的全部文件 ) ->** [FileBreadthFirstSearchUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/assist/search/FileBreadthFirstSearchUtils.java)

| 方法 | 注释 |
| :- | :- |
| setSearchHandler | 设置搜索处理接口 |
| getQueueSameTimeNumber | 获取任务队列同时进行数量 |
| setQueueSameTimeNumber | 任务队列同时进行数量 |
| isRunning | 是否搜索中 |
| stop | 停止搜索 |
| isStop | 是否停止搜索 |
| getStartTime | 获取开始搜索时间 ( 毫秒 ) |
| getEndTime | 获取结束搜索时间 ( 毫秒 ) |
| getDelayTime | 获取延迟校验时间 ( 毫秒 ) |
| setDelayTime | 设置延迟校验时间 ( 毫秒 ) |
| query | 搜索目录 |


* **文件深度优先搜索算法 ( 递归搜索某个目录下的全部文件 ) ->** [FileDepthFirstSearchUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/assist/search/FileDepthFirstSearchUtils.java)

| 方法 | 注释 |
| :- | :- |
| setSearchHandler | 设置搜索处理接口 |
| isRunning | 是否搜索中 |
| stop | 停止搜索 |
| isStop | 是否停止搜索 |
| getStartTime | 获取开始搜索时间 ( 毫秒 ) |
| getEndTime | 获取结束搜索时间 ( 毫秒 ) |
| query | 搜索目录 |


## <span id="devutilscommoncipher">**`dev.utils.common.cipher`**</span>


* **Base64 工具类 ->** [Base64.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/cipher/Base64.java)

| 方法 | 注释 |
| :- | :- |
| decode | Decode the Base64-encoded data in input and return the data in |
| encodeToString | Base64-encode the given data and return a newly allocated |
| encode | Base64-encode the given data and return a newly allocated |


* **Base64 编解码 ( 并进行 ) 加解密 ->** [Base64Cipher.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/cipher/Base64Cipher.java)

| 方法 | 注释 |
| :- | :- |
| decrypt | 解码 |
| encrypt | 编码 |


* **加密工具类 ->** [CipherUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/cipher/CipherUtils.java)

| 方法 | 注释 |
| :- | :- |
| encrypt | 加密方法 |
| decrypt | 解密方法 |


## <span id="devutilscommonencrypt">**`dev.utils.common.encrypt`**</span>


* **AES 对称加密工具类 ->** [AESUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/AESUtils.java)

| 方法 | 注释 |
| :- | :- |
| initKey | 生成密钥 |
| encrypt | AES 加密 |
| decrypt | AES 解密 |


* **CRC 工具类 ->** [CRCUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/CRCUtils.java)

| 方法 | 注释 |
| :- | :- |
| getCRC32 | 获取 CRC32 值 |
| getCRC32ToHexString | 获取 CRC32 值 |
| getFileCRC32 | 获取文件 CRC32 值 |


* **DES 对称加密工具类 ->** [DESUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/DESUtils.java)

| 方法 | 注释 |
| :- | :- |
| getDESKey | 获取可逆算法 DES 的密钥 |
| encrypt | DES 加密 |
| decrypt | DES 解密 |


* **加解密通用工具类 ->** [EncryptUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/EncryptUtils.java)

| 方法 | 注释 |
| :- | :- |
| encryptMD2 | MD2 加密 |
| encryptMD2ToHexString | MD2 加密 |
| encryptMD5 | MD5 加密 |
| encryptMD5ToHexString | MD5 加密 |
| encryptMD5File | 获取文件 MD5 值 |
| encryptMD5FileToHexString | 获取文件 MD5 值 |
| encryptSHA1 | SHA1 加密 |
| encryptSHA1ToHexString | SHA1 加密 |
| encryptSHA224 | SHA224 加密 |
| encryptSHA224ToHexString | SHA224 加密 |
| encryptSHA256 | SHA256 加密 |
| encryptSHA256ToHexString | SHA256 加密 |
| encryptSHA384 | SHA384 加密 |
| encryptSHA384ToHexString | SHA384 加密 |
| encryptSHA512 | SHA512 加密 |
| encryptSHA512ToHexString | SHA512 加密 |
| encryptHmacMD5 | HmacMD5 加密 |
| encryptHmacMD5ToHexString | HmacMD5 加密 |
| encryptHmacSHA1 | HmacSHA1 加密 |
| encryptHmacSHA1ToHexString | HmacSHA1 加密 |
| encryptHmacSHA224 | HmacSHA224 加密 |
| encryptHmacSHA224ToHexString | HmacSHA224 加密 |
| encryptHmacSHA256 | HmacSHA256 加密 |
| encryptHmacSHA256ToHexString | HmacSHA256 加密 |
| encryptHmacSHA384 | HmacSHA384 加密 |
| encryptHmacSHA384ToHexString | HmacSHA384 加密 |
| encryptHmacSHA512 | HmacSHA512 加密 |
| encryptHmacSHA512ToHexString | HmacSHA512 加密 |
| encryptDES | DES 加密 |
| encryptDESToBase64 | DES 加密 |
| encryptDESToHexString | DES 加密 |
| decryptDES | DES 解密 |
| decryptDESToBase64 | DES 解密 |
| decryptDESToHexString | DES 解密 |
| encrypt3DES | 3DES 加密 |
| encrypt3DESToBase64 | 3DES 加密 |
| encrypt3DESToHexString | 3DES 加密 |
| decrypt3DES | 3DES 解密 |
| decrypt3DESToBase64 | 3DES 解密 |
| decrypt3DESToHexString | 3DES 解密 |
| encryptAES | AES 加密 |
| encryptAESToBase64 | AES 加密 |
| encryptAESToHexString | AES 加密 |
| decryptAES | AES 解密 |
| decryptAESToBase64 | AES 解密 |
| decryptAESToHexString | AES 解密 |
| encryptRSA | RSA 加密 |
| encryptRSAToBase64 | RSA 加密 |
| encryptRSAToHexString | RSA 加密 |
| decryptRSA | RSA 解密 |
| decryptRSAToBase64 | RSA 解密 |
| decryptRSAToHexString | RSA 解密 |


* **字符串 ( 编解码 ) 工具类 ->** [EscapeUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/EscapeUtils.java)

| 方法 | 注释 |
| :- | :- |
| escape | 编码 |
| unescape | 解码 - 本方法不论参数 data 是否经过 escape() 编码, 均能获取正确的 ( 解码 ) 结果 |


* **MD5 加密工具类 ->** [MD5Utils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/MD5Utils.java)

| 方法 | 注释 |
| :- | :- |
| md5 | 加密内容 - 32 位 MD5 - 小写 |
| md5Upper | 加密内容 - 32 位 MD5 - 大写 |
| getFileMD5 | 获取文件 MD5 值 |
| getFileMD5ToHexString | 获取文件 MD5 值 - 小写 |


* **SHA 加密工具类 ->** [SHAUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/SHAUtils.java)

| 方法 | 注释 |
| :- | :- |
| sha1 | 加密内容 SHA1 |
| sha224 | 加密内容 SHA224 |
| sha256 | 加密内容 SHA256 |
| sha384 | 加密内容 SHA384 |
| sha512 | 加密内容 SHA512 |
| getFileSHA1 | 获取文件 SHA1 值 |
| getFileSHA256 | 获取文件 SHA256 值 |
| shaHex | 加密内容 SHA 模板 |
| getFileSHA | 获取文件 SHA 值 |


* **3DES 对称加密工具类 ->** [TripleDESUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/TripleDESUtils.java)

| 方法 | 注释 |
| :- | :- |
| initKey | 生成密钥 |
| encrypt | 3DES 加密 |
| decrypt | 3DES 解密 |


* **异或 ( 加密 ) 工具类 ->** [XorUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/encrypt/XorUtils.java)

| 方法 | 注释 |
| :- | :- |
| encryptAsFix | 加解密 ( 固定 Key 方式 ) - 这种方式 加解密 方法共用 |
| encrypt | 加密 ( 非固定 Key 方式 ) |
| decrypt | 解密 ( 非固定 Key 方式 ) |


## <span id="devutilscommonrandom">**`dev.utils.common.random`**</span>


* **随机概率采样算法 ->** [AliasMethod.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/random/AliasMethod.java)

| 方法 | 注释 |
| :- | :- |
| next | 获取随机索引 ( 对应几率索引 ) |


## <span id="devutilscommonthread">**`dev.utils.common.thread`**</span>


* **线程池管理工具类 ->** [DevThreadManager.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/thread/DevThreadManager.java)

| 方法 | 注释 |
| :- | :- |
| getInstance | 获取 DevThreadManager 实例 |
| initConfig | 初始化配置信息 |
| putConfig | 添加配置信息 |
| removeConfig | 移除配置信息 |


* **线程池 ( 构建类 ) ->** [DevThreadPool.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/thread/DevThreadPool.java)

| 方法 | 注释 |
| :- | :- |
| getThreads | 获取线程数 |
| getCalcThreads | 获取线程数 |
| execute | 加入到线程池任务队列 |
| shutdown | shutdown 会等待所有提交的任务执行完成, 不管是正在执行还是保存在任务队列中的已提交任务 |
| shutdownNow | shutdownNow 会尝试中断正在执行的任务 ( 其主要是中断一些指定方法如 sleep 方法 ), 并且停止执行等待队列中提交的任务 |
| isShutdown | 判断线程池是否已关闭 - isShutDown 当调用 shutdown() 方法后返回为 true |
| isTerminated | 若关闭后所有任务都已完成, 则返回 true |
| awaitTermination | 请求关闭、发生超时或者当前线程中断 |
| submit | 提交一个 Callable 任务用于执行 |
| invokeAll | 执行给定的任务 |
| invokeAny | 执行给定的任务 |
| schedule | 延迟执行 Runnable 命令 |
| scheduleWithFixedRate | 延迟并循环执行命令 |
| scheduleWithFixedDelay | 延迟并以固定休息时间循环执行命令 |


## <span id="devutilscommonvalidator">**`dev.utils.common.validator`**</span>


* **银行卡管理工具类 ->** [BankCheckUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/validator/BankCheckUtils.java)

| 方法 | 注释 |
| :- | :- |
| checkBankCard | 校验银行卡卡号是否合法 |
| getBankCardCheckCode | 从不含校验位的银行卡卡号采用 Luhm 校验算法获取校验位 |
| getNameOfBank | 通过银行卡的 前六位确定 判断银行开户行及卡种 |


* **居民身份证工具类 ->** [IDCardUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/validator/IDCardUtils.java)

| 方法 | 注释 |
| :- | :- |
| validateIdCard15 | 身份证校验规则, 验证 15 位身份编码是否合法 |
| validateIdCard18 | 身份证校验规则, 验证 18 位身份编码是否合法 |
| convert15CardTo18 | 将 15 位身份证号码转换为 18 位 |
| validateTWCard | 验证台湾身份证号码 |
| validateHKCard | 验证香港身份证号码 ( 部份特殊身份证无法检查 ) |
| validateIdCard10 | 判断 10 位数的身份证号, 是否合法 |
| validateCard | 验证身份证是否合法 |
| getAgeByIdCard | 根据身份编号获取年龄 |
| getBirthByIdCard | 根据身份编号获取生日 |
| getBirthdayByIdCard | 根据身份编号获取生日 |
| getYearByIdCard | 根据身份编号获取生日 - 年份 |
| getMonthByIdCard | 根据身份编号获取生日 - 月份 |
| getDateByIdCard | 根据身份编号获取生日 - 天数 |
| getGenderByIdCard | 根据身份编号获取性别 |
| getProvinceByIdCard | 根据身份编号获取户籍省份 |
| getPowerSum | 将身份证的每位和对应位的加权因子相乘之后, 再获取和值 |
| getCheckCode18 | 将 POWER 和值与 11 取模获取余数进行校验码判断 |


* **校验工具类 ->** [ValidatorUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/validator/ValidatorUtils.java)

| 方法 | 注释 |
| :- | :- |
| match | 通用匹配函数 |
| isNumber | 检验数字 |
| isNumberDecimal | 检验数字或包含小数点 |
| isLetter | 判断字符串是不是全是字母 |
| isContainNumber | 判断字符串是不是包含数字 |
| isNumberLetter | 判断字符串是不是只含字母和数字 |
| isSpec | 检验特殊符号 |
| isWx | 检验微信号 |
| isRealName | 检验真实姓名 |
| isNickName | 校验昵称 |
| isUserName | 校验用户名 |
| isPassword | 校验密码 |
| isEmail | 校验邮箱 |
| isUrl | 校验 URL |
| isIPAddress | 校验 IP 地址 |
| isChinese | 校验汉字 ( 无符号, 纯汉字 ) |
| isChineseAll | 判断字符串是不是全是中文 |
| isContainChinese | 判断字符串中包含中文、包括中文字符标点等 |


* **检验联系 ( 手机号, 座机 ) 工具类 ->** [ValiToPhoneUtils.java](https://github.com/afkT/DevUtils/blob/master/DevLibUtils/src/main/java/dev/utils/common/validator/ValiToPhoneUtils.java)

| 方法 | 注释 |
| :- | :- |
| isPhoneCheck | 中国手机号格式验证, 在输入可以调用该方法, 点击发送验证码, 使用 isPhone |
| isPhone | 是否中国手机号 |
| isPhoneToChinaTelecom | 是否中国电信手机号码 |
| isPhoneToChinaUnicom | 是否中国联通手机号码 |
| isPhoneToChinaMobile | 是否中国移动手机号码 |
| isPhoneToHkMobile | 判断是否香港手机号 |
| isPhoneCallNum | 验证电话号码的格式 |