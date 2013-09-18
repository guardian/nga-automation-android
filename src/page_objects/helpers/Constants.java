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

package page_objects.helpers;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 16/09/13
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class Constants extends UiAutomatorTestCase {

    public static String [] getNavigationItemsTopLevel () {
       return new String[]{
               "Home",
               "UK news",
               "World",
               "Comment",
               "Sport",
               "Football",
               "Life & style",
               "Culture",
               "Business",
               "Money",
               "Travel",
               "Tech",
               "Environment"
       };
    }

    public static String [] getNavigationItemsUkNews () {
        return new String[] {
                "Politics",
                "Media",
                "Science",
                "Society",
                "Health",
                "Education"
        };
    }

    public static String [] getNavigationItemsWorld () {
        return new String[] {
                "US",
                "Europe",
                "Africa",
                "Asia",
                "Australia",
                "Americas"
        };
    }

    public static String [] getNavigationItemsComment () {
        return new String[] {
                "CIF America",
                "CIF Belief",
                "Cartoon"
        };
    }
}
