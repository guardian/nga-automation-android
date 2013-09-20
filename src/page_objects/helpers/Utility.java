/*
 * Copyright 2013 Guardian News & Media
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package page_objects.helpers;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.pages.HomePage;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 16/09/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class Utility extends UiAutomatorTestCase {

//=====================================================
// Setup
//=====================================================

    public static HomePage appStart () throws UiObjectNotFoundException {

        Utility.waitFiveSeconds();
        return new HomePage();
    }

//=====================================================
// Waits
//=====================================================

    private static void waitHalfSecond() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitOneSeconds() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitFiveSeconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitTenSeconds() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitSixtySeconds() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//=====================================================
// Logging
//=====================================================

    public static void logMessage(String logMessage) {
        String strLogMessage = "*** GNM: " + logMessage;
        System.out.println(strLogMessage);
    }

    public static void logMessageFailure(String logMessage) {
        String strLogMessage = "*** GNM: FAILURE: " + logMessage;
        System.out.println(strLogMessage);
    }

    public static void logPageBreak() {
        String strLogPageBreak = "     *****    ";
        System.out.println(strLogPageBreak);
    }

//=====================================================
// Checks
//=====================================================



//=====================================================
// Device
//=====================================================

    public static void swipeDownNotificationBar() {
        int deviceHeight = UiDevice.getInstance().getDisplayHeight();
        int deviceWidth = UiDevice.getInstance().getDisplayWidth();
        System.out.println("device height = " + deviceHeight);
        System.out.println("device width = " + deviceWidth);
        int xScrollPosition = deviceWidth/2;
        int yScrollStart = 0;
        int yScrollStop = deviceHeight/2;
        UiDevice.getInstance().swipe(xScrollPosition, yScrollStart, xScrollPosition, yScrollStop, 100);
    }

//=====================================================
// Actions
//=====================================================


}
