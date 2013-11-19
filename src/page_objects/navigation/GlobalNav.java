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

package page_objects.navigation;

import com.android.uiautomator.core.*;
import page_objects.helpers.SectionNames;
import page_objects.helpers.Utility;
import page_objects.pages.HomePage;
import page_objects.pages.SettingsPage;
import page_objects.sections.*;
import page_objects.subsections.business.*;
import page_objects.subsections.comment.*;
import page_objects.subsections.culture.*;
import page_objects.subsections.environment.*;
import page_objects.subsections.football.*;
import page_objects.subsections.lifestyle.*;
import page_objects.subsections.money.*;
import page_objects.subsections.sport.*;
import page_objects.subsections.tech.*;
import page_objects.subsections.travel.*;
import page_objects.subsections.uknews.*;
import page_objects.subsections.world.*;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 16/09/13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class GlobalNav {

//=====================================================
// Navigation
//=====================================================

    public SectionSuper openSection(SectionNames sectionName) throws UiObjectNotFoundException {

        String currentSection = getCapitalisedSectionTitle();
//        Utility.logMessage("Current section = " +currentSection);

        if (sectionName.parent != null && sectionName.parent.toString().equals(currentSection)){
            clickSection(sectionName.uiName);

            Utility.waitForContentToBePresent();
        }

        else if (sectionName.parent != null && !sectionName.parent.toString().equals(currentSection)) {
            clickSection(sectionName.parent.uiName);
            clickSection(sectionName.uiName);

            Utility.waitForContentToBePresent();
        }
        else {
            clickSection(sectionName.uiName);
            new UiObject(new UiSelector().descriptionStartsWith("Guardian,")).click();

            Utility.waitForContentToBePresent();
        }

        return new SectionSuper();
    }

    public void clickSection(String sectionNameStr) throws UiObjectNotFoundException {
        if (sectionNameStr.equals("Home")){
            new UiObject(new UiSelector().description(sectionNameStr)).clickAndWaitForNewWindow();
            Utility.logMessage(sectionNameStr + " section opened");
        }

        else if (new UiObject(new UiSelector().description(sectionNameStr)).exists()) {
            new UiObject(new UiSelector().description(sectionNameStr)).clickAndWaitForNewWindow();
            Utility.logMessage(sectionNameStr + " section opened");
        }
        else {

            if (new UiScrollable(new UiSelector().scrollable(true)).exists()) {
                UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
                scrollList.flingToBeginning(10);

                boolean found = scrollList.scrollIntoView(new UiObject(new UiSelector().description(sectionNameStr)));

                if (!found) {
                    found = scrollList.scrollIntoView(new UiObject(new UiSelector().description("Home")));
                    if (!found)
                        throw new UiObjectNotFoundException("CANNOT FIND OBJECT "+sectionNameStr );
                    new UiObject(new UiSelector().description("Home")).click();
                }
            }
               else {
                new UiObject(new UiSelector().description("Home")).click();
            }

            if (new UiScrollable(new UiSelector().scrollable(true)).exists()) {
                new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(sectionNameStr));
            }

            new UiObject(new UiSelector().description(sectionNameStr)).clickAndWaitForNewWindow();
            Utility.logMessage(sectionNameStr + " section opened");
        }
    }

//=====================================================
// Sections
//=====================================================

    public SectionSuper navigateToRandomSection (SectionNames randomSection) throws UiObjectNotFoundException {
        openSection(randomSection);
        return new SectionSuper();
    }


//=====================================================
// Checks
//=====================================================

    public boolean checkActionBarContents() throws UiObjectNotFoundException {
        if (isNavDrawerButtonPresent() && isRefreshButtonPresent() && isSettingsButtonPresent()){
            return true;
        }

        else {
            return false;
        }
    }

//=====================================================
// Actions
//=====================================================

    public String getSectionTitle () throws UiObjectNotFoundException {
        String text = new UiObject(new UiSelector().description("pageTitle")).getText();
        String sectionName;
        if (text.equals("guardian")){
            sectionName = "Home";
        }
        else{
            sectionName = text;
        }
        return sectionName;
    }

    public String getLowerCaseSectionTitle () throws UiObjectNotFoundException {
        String text = new UiObject(new UiSelector().description("pageTitle")).getText();
        String sectionName;
        if (text.equals("guardian")){
            sectionName = "Home";
        }
        else{
            sectionName = text;
        }
        return sectionName.toLowerCase();
    }

    public String getCapitalisedSectionTitle() throws UiObjectNotFoundException {
        String input = getSectionTitle();
        String output;
        if (input.equals("uk")){
            output = "UK";
        }
        else if (input.equals("us")){
            output = "US";
        }
        else {
            output = input.substring(0, 1).toUpperCase() + input.substring(1);
        }
        return output;
    }

    public GlobalNav swipeInNavDrawer () throws UiObjectNotFoundException {
        int deviceHeight = UiDevice.getInstance().getDisplayHeight();
        int deviceWidth = UiDevice.getInstance().getDisplayWidth();
        int yPosition = deviceHeight/2;
        int xStartPosition = 0;
        int xStopPosition =  deviceWidth/2;
        UiDevice.getInstance().swipe(xStartPosition, yPosition, xStopPosition, yPosition, 25);
        Utility.waitOneSeconds();
        return new GlobalNav();
    }

    public void swipeAwayNavDrawer () throws UiObjectNotFoundException {
        int deviceHeight = UiDevice.getInstance().getDisplayHeight();
        int deviceWidth = UiDevice.getInstance().getDisplayWidth();
        int yPosition = deviceHeight/2;
        int xStartPosition = deviceWidth/2;
        int xStopPosition =  0;
        UiDevice.getInstance().swipe(xStartPosition, yPosition, xStopPosition, yPosition, 25);
        Utility.waitOneSeconds();
    }

    public String getCellText (UiObject object) throws UiObjectNotFoundException {
        String string = object.getText().toLowerCase();
        return string;
    }

    public String getFirstThreeCellsText() throws UiObjectNotFoundException {
        UiObject firstCell = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(0)).getChild(new UiSelector().className("android.widget.TextView"));
        UiObject secondCell = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(1)).getChild(new UiSelector().className("android.widget.TextView"));
        UiObject thirdCell = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(2)).getChild(new UiSelector().className("android.widget.TextView"));

        String firstText = getCellText(firstCell);
        String secondText = getCellText(secondCell);
        String thirdText = getCellText(thirdCell);

        return firstText + ", " + secondText + ", " + thirdText;
    }

//=====================================================
// Action Bar
//=====================================================

    public void pressNavDrawerButton() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("Navigate up")).click();
        Utility.logMessage("Nav drawer opened");
    }

    public void pressRefresh() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("Refresh")).click();
        Utility.logMessage("Refresh button clicked");
    }

    public SettingsPage openSettingsPage() throws UiObjectNotFoundException {
        Utility.selectOverflowOrDeviceMenuButton();
        new UiObject(new UiSelector().text("Settings")).click();
        Utility.logMessage("Settings page opened");
        return new SettingsPage();
    }

//=====================================================
// Action Bar Checks
//=====================================================

    public boolean isNavDrawerButtonPresent() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description("Navigate up")).exists()){
            Utility.logMessage("Nav drawer button present");
            return true;
        }
        else {
            Utility.logMessage("Nav drawer button NOT present");
            throw new UiObjectNotFoundException("Nav drawer button not present");
        }
    }

    public boolean isRefreshButtonPresent() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description("Refresh")).exists()){
            Utility.logMessage("Refresh button present");
            return true;
        }
        else {
            Utility.logMessage("Refresh button NOT present");
            throw new UiObjectNotFoundException("Refresh button not present");
        }
    }

    public boolean isSettingsButtonPresent() throws UiObjectNotFoundException {
        Utility.selectOverflowOrDeviceMenuButton();
        if (new UiObject(new UiSelector().text("Settings")).exists()){
            Utility.logMessage("Settings button present");
            UiDevice.getInstance().pressBack();
            return true;
        }
        else {
            Utility.logMessage("Settings button NOT present");
            UiDevice.getInstance().pressBack();
            throw new UiObjectNotFoundException("Settings button not present");
        }
    }

}