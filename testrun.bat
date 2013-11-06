adb shell "am force-stop com.guardian"
adb shell am start -n "com.guardian/com.theguardian.nextgen.proto.ui.HomeActivity"
ant build

adb push bin\nga-automation-android.jar /data/local/tmp

adb shell "uiautomator runtest nga-automation-android.jar -c tests.navigation.CheckBackStackInNavDrawer"

pause