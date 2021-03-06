# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
 # 定位 的混淆代码
 -keep class com.amap.api.location.**{*;}
 -keep class com.amap.api.fence.**{*;}
 -keep class com.autonavi.aps.amapapi.model.**{*;}

 # glide 的混淆代码
 -keep public class * implements com.bumptech.glide.module.GlideModule
 -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
   **[] $VALUES;
   public *;
 }
 # banner 的混淆代码
 -keep class com.youth.banner.** {
     *;
  }
   # bugly 的混淆代码
  -dontwarn com.tencent.bugly.**
  -keep public class com.tencent.bugly.**{*;}
  -dontwarn com.tencent.bugly.**
  -keep public class com.tencent.bugly.**{*;}
  -keep class android.support.**{*;}
  -dontwarn com.tencent.bugly.**
  -keep public class com.tencent.bugly.**{*;}

  # tinker混淆规则
  -dontwarn com.tencent.tinker.**
  -keep class com.tencent.tinker.** { *; }

  #LRecyclerview
  -dontwarn com.github.jdsjlzx.**
  -keep class com.github.jdsjlzx.progressindicator.indicators.** { *; }