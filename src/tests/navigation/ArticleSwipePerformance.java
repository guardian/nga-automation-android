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

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 01/10/13
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class ArticleSwipePerformance extends UiAutomatorTestCase {

    public void testArticleSwipePerformance() throws UiObjectNotFoundException {

//        GIVEN: I have accessed an article from a front

        HomePage homePage = Utility.appStart();
        ArticlePage articlePage = homePage.openFirstStandardArticle();

//        WHEN: I swipe between several articles
//        THEN: Item content is loaded
//        AND: No crashes are reported

        int i = 1;

        while (i<21){
            Utility.logMessage("Article"+i);
            assertTrue(articlePage.isItemContentPresent());
            articlePage.swipePerformanceCheck();
            i++;
        }
    }
}
