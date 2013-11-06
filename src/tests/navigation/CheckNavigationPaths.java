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
import page_objects.helpers.SectionNames;
import page_objects.helpers.Utility;
import page_objects.pages.HomePage;
import page_objects.sections.SectionSuper;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 01/11/13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class CheckNavigationPaths extends UiAutomatorTestCase {

    public void testCheckNavigationProgress() throws UiObjectNotFoundException {

//        GIVEN I have am using the global nav
//        WHEN I navigate to a random section
//        THEN that section is displayed

        SectionNames randomSection = Utility.generateRandomSection();

        HomePage homePage = Utility.appStart();
        SectionSuper randomPage = homePage.navigateToRandomSection(Utility.generateRandomSection());
        assertTrue(randomPage.isSectionMatchingRandomSection(randomSection));

    }
}
