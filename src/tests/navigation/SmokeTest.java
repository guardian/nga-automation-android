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
import page_objects.sections.Comment;
import page_objects.subsections.comment.CommentCIFAmerica;
import page_objects.subsections.sport.SportUSSport;
import page_objects.subsections.travel.TravelHotels;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 20/09/13
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public class SmokeTest extends UiAutomatorTestCase {

    public void testSmokeTest () throws UiObjectNotFoundException {

        HomePage homePage = Utility.appStart();
        Comment comment = homePage.navigateToSectionComment();
        assertTrue(comment.getSectionTitle().equals("Comment"));

        SportUSSport usSport = comment.navigateToSubsectionSportUSSport();
        assertTrue(usSport.getSectionTitle().equals("US Sport"));

        TravelHotels hotels = usSport.navigateToSubsectionTravelHotels();
        assertTrue(hotels.getSectionTitle().equals("Hotels"));
    }
}
