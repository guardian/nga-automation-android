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

import android.os.RemoteException;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.Utility;
import page_objects.pages.ArticlePage;
import page_objects.pages.HomePage;
import page_objects.pages.LiveBlogPage;
import page_objects.sections.Business;
import page_objects.sections.SectionSuper;
import page_objects.subsections.business.BusinessEuro;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 07/11/13
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class StandardUseWithOrientationSwitches extends UiAutomatorTestCase {

    public void doRunThroughFrontListItemWithRotationChange () throws UiObjectNotFoundException, RemoteException {

        Utility.changeOrientationNatural();
        HomePage homePage = Utility.appStart();

        ArticlePage article1 = homePage.openFirstStandardArticle();
        Utility.changeOrientation();
        article1.pressBackButton();
        Utility.changeOrientationNatural();

        SectionSuper front = homePage.navigateToRandomSection(Utility.generateRandomFrontSection());
        Utility.changeOrientation();
        Utility.changeOrientationNatural();

        ArticlePage article2 = front.openFirstStandardArticle();
        Utility.changeOrientation();
        article2.pressBackButton();
        Utility.changeOrientationNatural();

        SectionSuper list = front.navigateToRandomSection(Utility.generateRandomListSection());

        ArticlePage article3 = front.openFirstStandardArticle();
        Utility.changeOrientation();
        article3.pressBackButton();
        Utility.changeOrientationNatural();

        HomePage homePage2 = list.navigateToSectionHome();

    }

    public void testStandardUseWithOrientationSwitches() throws UiObjectNotFoundException, RemoteException {

//        GIVEN I am navigating through fronts, lists and items
//        WHEN I repeatedly change the device orientation
//        THEN the device performance is not adversely affected

//        THIS TEST SHOULD BE RUN THROUGH LITTLE EYE TO MONITOR PERFORMANCE

        int i=0;
        while (i<4){
            doRunThroughFrontListItemWithRotationChange();
            i++;
        }

    }

//    TODO: Refactor this class for Page Object Model
}
