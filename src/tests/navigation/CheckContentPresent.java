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

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.Utility;
import page_objects.pages.HomePage;
import page_objects.sections.Sport;
import page_objects.subsections.sport.SportCricket;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 28/10/13
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
public class CheckContentPresent extends UiAutomatorTestCase{

    public void testCheckContentPresent() throws UiObjectNotFoundException {

//        GIVEN: I am in the app
//        WHEN: I navigate to a Front / list
//        THEN: Items are displayed

        HomePage homePage = Utility.appStart();
        assertTrue(homePage.isAnyContentPresent());

        Sport sport = homePage.navigateToSectionSport();
        assertTrue(sport.isAnyContentPresent());

        SportCricket cricket = sport.navigateToSubsectionSportCricket();
        assertTrue(cricket.isAnyContentPresent());

    }
}
