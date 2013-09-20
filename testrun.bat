adb shell "am force-stop com.guardian"
adb shell am start -n "com.guardian/com.guardian.ui.activities.HomePageActivity"
ant build

adb push bin\nga-automation-android.jar /data/local/tmp

adb shell "uiautomator runtest nga-automation-android.jar -c tests.navigation.SmokeTest"

pause