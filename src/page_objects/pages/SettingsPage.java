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

package page_objects.pages;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import page_objects.helpers.SettingsOptions;
import page_objects.pages.SettingsOptions.UpdateFrequency;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 29/10/13
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class SettingsPage {

//=====================================================
// Setup
//=====================================================

    private UiScrollable scrollableMenu = new UiScrollable(new UiSelector().className("android.widget.ListView").scrollable(true));

//=====================================================
// Action bar actions
//=====================================================

    public HomePage pressNavigateUpButton() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("Navigate up")).click();
        return new HomePage();
    }

//=====================================================
// Actions
//=====================================================

    public UpdateFrequency openUpdateFrequency() throws UiObjectNotFoundException {
        openSettingOption(SettingsOptions.UpdateFrequency);
        return new UpdateFrequency();
    }

//=====================================================
// Checks
//=====================================================

//=====================================================
// Private
//=====================================================

    public void openSettingOption(SettingsOptions settingsOption) throws UiObjectNotFoundException {

        if (settingsOption.type.equals("menu")){
            scrollableMenu.scrollIntoView(new UiSelector().text(settingsOption.uiName));
            new UiObject(new UiSelector().text(settingsOption.uiName)).click();
        }

        else if (settingsOption.type.equals("tick")){
            throw new UiObjectNotFoundException("Cannot open option - this setting is a tick box");
        }

        else{
            throw new UiObjectNotFoundException("Do no recognise this setting type");
        }
    }

    public void tickSettingsOption(SettingsOptions settingsOption) throws UiObjectNotFoundException {

        if (settingsOption.type.equals("tick")){
            scrollableMenu.scrollIntoView(new UiSelector().text(settingsOption.uiName));
            new UiObject(new UiSelector().text(settingsOption.uiName)).click();
        }

        else if (settingsOption.type.equals("menu")){
            throw new UiObjectNotFoundException("Cannot tick option - this setting is a menu");
        }

        else{
            throw new UiObjectNotFoundException("Do no recognise this setting type");
        }
    }


}
