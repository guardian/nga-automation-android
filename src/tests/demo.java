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

package tests;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.Utility;
import page_objects.pages.ArticlePage;
import page_objects.pages.HomePage;
import page_objects.sections.Sport;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 17/09/13
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class demo extends UiAutomatorTestCase {

    public void testDemo () throws UiObjectNotFoundException {

        HomePage homePage = Utility.appStart();
        Sport sport = homePage.navigateToSectionSport();
        ArticlePage article = sport.openFirstStandardArticle();

    }
}
