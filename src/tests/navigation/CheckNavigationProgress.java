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

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 01/11/13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class CheckNavigationProgress extends UiAutomatorTestCase {

    public SectionNames randomSection(){
        int pick = new Random().nextInt(SectionNames.values().length);
        return SectionNames.values()[pick];
    }

    public void testCheckNavigationProgress() throws UiObjectNotFoundException {

//        GIVEN I have am using the global nav
//        WHEN I navigate to a random section
//        THEN that section is displayed

        HomePage homePage = Utility.appStart();

        SectionNames selectedSection = randomSection();

        homePage.openSection(selectedSection);

        SectionSuper sectionSuper = new SectionSuper();

        assertTrue(sectionSuper.getCapitalisedSectionTitle().equals(selectedSection));

//        TODO: Fix this so it works! Current assertion failure - possibly due to capitalisation?

    }
}
