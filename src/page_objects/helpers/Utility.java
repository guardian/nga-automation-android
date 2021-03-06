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

import android.os.RemoteException;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.pages.HomePage;
import page_objects.sections.SectionSuper;

import java.util.Random;

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

        clearBetaLaunchMessage();
        waitForContentToBePresent();
        return new HomePage();
    }

//=====================================================
// Waits
//=====================================================

    public static void waitHalfSecond() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitOneSeconds() {
        waitForTime(1);
    }

    public static void waitTwoSeconds() {
        waitForTime(2);
    }

    public static void waitFiveSeconds() {
        waitForTime(5);
    }

    public static void waitTenSeconds() {
        waitForTime(10);
    }

    public static void waitSixtySeconds() {
        waitForTime(60);
    }

    public static void waitTwoMinutes() {
        waitForTime(120);
    }

    public static void waitForTime (int timeInSecs) {
        try {
            Thread.sleep(timeInSecs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForContentToBePresent() throws UiObjectNotFoundException {

        SectionSuper sectionSuper = new SectionSuper();

        int i = 0;

        while (!sectionSuper.isAnyContentPresent() && i<10){
            Utility.waitTwoSeconds();
            i++;
        }

        if (i>=10 && !sectionSuper.isAnyContentPresent()) {
            throw new UiObjectNotFoundException("No content present");
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

    public static void selectOverflowOrDeviceMenuButton() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description("More options")).exists()){
            new UiObject(new UiSelector().description("More options")).click();
        }
        else {
            UiDevice.getInstance().pressMenu();
        }
    }

    public static String getOrientation(){
        int orientation = UiDevice.getInstance().getDisplayRotation();
        String state = null;

        if (orientation<90 || orientation>=180 && orientation<270){
            state="vertical";
        }
        if (orientation>=90 && orientation<180 || orientation>270){
            state="horizontal";
        }
        return state;
    }

    public static void changeOrientation() throws RemoteException {
        String state = getOrientation();
        if (state.equals("vertical")){
            UiDevice.getInstance().setOrientationRight();
        }
        else {
            UiDevice.getInstance().setOrientationLeft();
        }
    }

    public static void changeOrientationNatural() throws RemoteException {
        UiDevice.getInstance().setOrientationNatural();
    }

//=====================================================
// Actions
//=====================================================

    public static SectionNames generateRandomSection(){
        SectionNames section = SectionNames.Home;

        while (section.equals(SectionNames.Home)){
            int pick = new Random().nextInt(SectionNames.values().length);
            section = SectionNames.values()[pick];
        }
        return section;
    }

    public static SectionNames generateRandomFrontSection(){
        SectionNames section = SectionNames.Home;

        while (section.equals(SectionNames.Home) || (section.parent != null)){
            int pick = new Random().nextInt(SectionNames.values().length);
            section = SectionNames.values()[pick];
        }
        return section;
    }

    public static SectionNames generateRandomListSection(){
        SectionNames section = SectionNames.Home;

        while (section.equals(SectionNames.Home) || section.parent == null){
            int pick = new Random().nextInt(SectionNames.values().length);
            section = SectionNames.values()[pick];
        }
        return section;
    }

    public static void clearBetaLaunchMessage() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().text("Next-gen apps beta programme")).exists() && new UiObject(new UiSelector().className("android.widget.Button").text("OK")).exists()){
            new UiObject(new UiSelector().className("android.widget.Button").text("OK")).click();
        }
    }

    public static void backgroundApp() throws UiObjectNotFoundException{
        UiDevice.getInstance().pressHome();
        Utility.waitTwoSeconds();
    }

    public static void openAppFromRecentApps() throws UiObjectNotFoundException, RemoteException {
        UiDevice.getInstance().pressRecentApps();
        Utility.waitTwoSeconds();
        new UiObject(new UiSelector().className("android.widget.FrameLayout").description("Guardian")).click();
        Utility.waitTwoSeconds();
    }

}
