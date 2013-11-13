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

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 13/11/13
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class BackgroundAppAndWait extends UiAutomatorTestCase {

    public void doBackgroundAppAndWait() throws UiObjectNotFoundException, RemoteException {

        Utility.backgroundApp();
        Utility.waitTwoMinutes();
        Utility.openAppFromRecentApps();
    }

    public void testBackgroundAppAndWait() throws UiObjectNotFoundException, RemoteException {

//        GIVEN I have backgrounded the app
//        WHEN I leave the device for a period of time
//        THEN the device performance is not adversely affected

//        THIS TEST SHOULD BE RUN THROUGH LITTLE EYE TO MONITOR PERFORMANCE, PREFERABLY AFTER OTHER TESTS HAVE BEEN RUN

        doBackgroundAppAndWait();
    }
}
