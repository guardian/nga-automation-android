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

package tests.navigation;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.Utility;
import page_objects.navigation.GlobalNav;
import page_objects.pages.HomePage;
import page_objects.sections.SectionSuper;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 06/11/13
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
public class CheckBackStackInNavDrawer extends UiAutomatorTestCase {

    public void testCheckBackStackInNavDrawer() throws UiObjectNotFoundException {

//        GIVEN That I have navigated to a section
//        WHEN I press the device back button
//        THEN the navigation drawer updates to reflect the new location

        HomePage homePage = Utility.appStart();

//        Homepage nav drawer
        GlobalNav nav = homePage.swipeInNavDrawer();
        String firstMenu = nav.getFirstThreeCellsText();

        SectionSuper section = nav.navigateToRandomSection(Utility.generateRandomFrontSection());

//        Section page nav drawer
        GlobalNav nav2 = section.swipeInNavDrawer();
        String sectionMenu = nav2.getFirstThreeCellsText();

        assertFalse(sectionMenu.equals(firstMenu));

        nav2.swipeAwayNavDrawer();
        UiDevice.getInstance().pressBack();

//        Second homepage nav drawer
        GlobalNav nav3 = homePage.swipeInNavDrawer();
        String finalMenu = nav3.getFirstThreeCellsText();

        Utility.logMessage("First texxt = " +firstMenu);
        Utility.logMessage("Section text =" +sectionMenu);
        Utility.logMessage("Final text = " +finalMenu);

        assertTrue(finalMenu.equals(firstMenu));
    }
}
