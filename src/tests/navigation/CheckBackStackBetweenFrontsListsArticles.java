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
import page_objects.pages.ArticlePage;
import page_objects.pages.HomePage;
import page_objects.sections.Sport;
import page_objects.subsections.sport.SportCricket;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 05/11/13
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public class CheckBackStackBetweenFrontsListsArticles extends UiAutomatorTestCase {

    public void testCheckBackStackBetweenFrontsListsArticles() throws UiObjectNotFoundException {

//        GIVEN I have navigated from the homepage, to a front, then a list, then an article
//        WHEN I press the device back button
//        THEN I am taken to the list
//        THEN the front
//        THEN the homepage

        HomePage homePage = Utility.appStart();
        Sport sport = homePage.navigateToSectionSport();
        SportCricket cricket = sport.navigateToSubsectionSportCricket();
        ArticlePage article = cricket.openFirstStandardArticle();

        UiDevice.getInstance().pressBack();
        assertTrue(cricket.getLowerCaseSectionTitle().equals("cricket"));
        UiDevice.getInstance().pressBack();
        assertTrue(sport.getLowerCaseSectionTitle().equals("sport"));
        UiDevice.getInstance().pressBack();
        assertTrue(homePage.getLowerCaseSectionTitle().equals("home"));

//        GIVEN I have navigated from the homepage, directly to a list, then an article
//        WHEN I press the device back button
//        THEN I am taken to the list
//        THEN the homepage

        SportCricket cricket2 = homePage.navigateToSubsectionSportCricket();
        ArticlePage article2 = cricket.openFirstStandardArticle();

        UiDevice.getInstance().pressBack();
        assertTrue(cricket.getLowerCaseSectionTitle().equals("cricket"));
        UiDevice.getInstance().pressBack();
        assertTrue(homePage.getLowerCaseSectionTitle().equals("home"));


    }
}
