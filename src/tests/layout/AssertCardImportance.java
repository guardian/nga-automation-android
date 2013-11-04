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

package tests.layout;

import com.android.uiautomator.core.*;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.Utility;
import page_objects.pages.HomePage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 01/11/13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class AssertCardImportance extends UiAutomatorTestCase {

    public void testAssertCardImportance() throws UiObjectNotFoundException {

        HomePage homePage = Utility.appStart();

        UiCollection homePageList = new UiCollection(new UiSelector().scrollable(true));
        UiSelector cardSelector = new UiSelector().descriptionContains("Article");

        ArrayList<UiObject> cards = new ArrayList();

        cards.add(homePageList.getChild(cardSelector));

        Utility.logMessage(String.valueOf(homePageList.getChildCount()));

//        TODO: Make this work

    }
}
