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

package page_objects.UIAutomatorLogging;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 26/09/13
 * Time: 09:57
 * To change this template use File | Settings | File Templates.
 */
public class UiObjectLog extends UiObject {
    /**
     * Constructs a UiObject to represent a specific UI element matched by the specified
     * {@link com.android.uiautomator.core.UiSelector} selector properties.
     *
     * @param selector
     * @since API Level 16
     */
    public UiObjectLog(UiSelector selector) {
        super(selector);
    }

    String actionType = null;
    Boolean loggingOn = true;

    @Override
    public boolean click() throws UiObjectNotFoundException {
        if (loggingOn){
            actionType = "clicked";
            objectLogger();
        }
        return super.click();
    }

    @Override
    public boolean setText(String text) throws UiObjectNotFoundException {
        actionType = "text entered: " +text;
        return super.setText(text);
    }

    private void objectLogger (){
        String strMessage = "***OBJ LOG: " + getSelector().toString() + " " + actionType;
        System.out.println(strMessage);
    }
}
