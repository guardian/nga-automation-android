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

package tests.performance;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.Utility;
import page_objects.pages.HomePage;
import page_objects.pages.SettingsOptions.UpdateFrequency;
import page_objects.pages.SettingsPage;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 15/11/13
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public class PauseOnHomePageWithDifferentPolling extends UiAutomatorTestCase {

    public void testPauseOnHomePage() throws UiObjectNotFoundException {

//        THIS TEST SHOULD BE RUN THROUGH LITTLE EYE TO MONITOR PERFORMANCE

//        GIVEN I have set the update frequency

        HomePage homePage = Utility.appStart();
        SettingsPage settings = homePage.openSettingsPage();
        UpdateFrequency updateFrequency = settings.openUpdateFrequency();
        updateFrequency.setUpdateFrequency1min();

//        WHEN I leave the app on the homepage
        HomePage homePage1 = settings.pressNavigateUpButton();
        Utility.waitForTime(120);

//        THEN memory usage is acceptable - check LittleEye reports

        SettingsPage settings1 = homePage1.openSettingsPage();
        UpdateFrequency updateFrequency1 = settings1.openUpdateFrequency();
        updateFrequency1.setUpdateFrequency10min();
        HomePage homePage2 = settings1.pressNavigateUpButton();
        Utility.waitForTime(720);



    }
}
