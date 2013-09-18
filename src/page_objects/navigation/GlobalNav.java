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

package page_objects.navigation;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.SectionNames;
import page_objects.helpers.Utility;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 16/09/13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class GlobalNav extends UiAutomatorTestCase {

//=====================================================
// Navigation
//=====================================================

    public void openSection(SectionNames sectionName) throws UiObjectNotFoundException {

        new UiObject(new UiSelector().description("Navigate up")).click();

        if (sectionName.parent != null) {
            clickSection(sectionName.parent.uiName);
        }
        clickSection(sectionName.uiName);
    }

    public void clickSection(String sectionNameStr) throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().text(sectionNameStr)).exists()) {
            new UiObject(new UiSelector().text(sectionNameStr)).click();
            Utility.logMessage(sectionNameStr + " section opened");
        } else {

            if (new UiScrollable(new UiSelector().scrollable(true)).exists()) {
                UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));

                boolean found = scrollList.scrollIntoView(new UiObject(new UiSelector().text(sectionNameStr)));

                if (!found) {
                    found = scrollList.scrollIntoView(new UiObject(new UiSelector().text("Home")));
                    if (!found)
                        throw new UiObjectNotFoundException("CANNOT FIND OBJECT");
                    new UiObject(new UiSelector().text("Home")).click();
                }
            } else {
                new UiObject(new UiSelector().text("Home")).click();
            }

            new UiObject(new UiSelector().text(sectionNameStr)).click();
            Utility.logMessage(sectionNameStr + " section opened");
        }


    }
}