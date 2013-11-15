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

package page_objects.pages.SettingsOptions;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 15/11/13
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
public class UpdateFrequency {

//=====================================================
// Actions
//=====================================================

    public void setUpdateFrequency1min() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.OneMinute);
    }

    public void setUpdateFrequency10min() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.TenMinutes);
    }

    public void setUpdateFrequency15min() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.FifteenMinutes);
    }

    public void setUpdateFrequency20min() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.TwentyMinutes);
    }

    public void setUpdateFrequency30min() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.ThirtyMinutes);
    }

    public void setUpdateFrequency1hour() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.OneHour);
    }

    public void setUpdateFrequency2hours() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.TwoHours);
    }

    public void setUpdateFrequencyNever() throws UiObjectNotFoundException {
        setUpdateFrequency(Frequencies.Never);
    }

    public void setUpdateFrequency(Frequencies frequencies) throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text(frequencies.uiName)).click();
    }

}

enum Frequencies {

    OneMinute("1 min"),
    TenMinutes("10 mins"),
    FifteenMinutes("15 mins"),
    TwentyMinutes("20 mins"),
    ThirtyMinutes("30 mins"),
    OneHour("1 hour"),
    TwoHours("2 hours"),
    Never;

    public final String uiName;

    private Frequencies(){
        this.uiName=this.toString();
    }

    private Frequencies(String uiName){
        this.uiName=uiName;
    }

}
