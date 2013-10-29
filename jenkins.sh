set -e

runTest() {
	#stop and start the app
	sh ./stopStart.sh

	#run the tests
	output=`adb shell "uiautomator runtest nga-automation-android.jar -c $1"`
	echo "$output"

	#exit if there were failures
	if echo "$output" |grep -q "FAILURES!!!"; then 
	        exit 1
	else
	        echo "All tests passed for $1"
	fi
}
#Push the tests jar
adb push bin/nga-automation-android.jar /data/local/tmp

#Run some tests
runTest "tests.navigation.CheckContentPresent"



