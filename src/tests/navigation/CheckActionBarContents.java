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
import page_objects.pages.ArticlePage;
import page_objects.pages.HomePage;
import page_objects.pages.LiveBlogPage;
import page_objects.sections.Business;
import page_objects.subsections.uknews.UKPolitics;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 29/10/13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class CheckActionBarContents extends UiAutomatorTestCase {

    public void testCheckActionBarContents() throws UiObjectNotFoundException {

//        GIVEN I open a front / list / article / liveblog
//        WHEN I view the action bar
//        THEN the correct options are available

//        FRONT
        HomePage homePage = Utility.appStart();
        assertTrue(homePage.checkActionBarContents());

//        LIST
        UKPolitics politics = homePage.navigateToSubsectionUKPolitics();
        assertTrue(politics.checkActionBarContents());

//        ARTICLE
        ArticlePage article = politics.openFirstStandardArticle();
        assertTrue(article.checkActionBarContents());

//        LIVEBLOG

        article.pressBackButton();
        LiveBlogPage liveBlog = politics.navigateToAndOpenLiveBlog();
        assertTrue(liveBlog.checkActionBarContents());

//        TODO: Optimise navigateToAndOpenLiveBlog method to use likely sections eg business, politics first

    }
}
