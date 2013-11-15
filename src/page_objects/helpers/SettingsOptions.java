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

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 15/11/13
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 */
public enum SettingsOptions {

//    Feedback
    SendFeedback("Send feedback", "menu"),

//    Account
    YourAccount("Your account", "menu"),

//    General
    EditHomepage("Edit homepage", "menu"),
    Edition("menu"),
    Help("menu"),
    About("About this app", "menu"),

//    Content Download
    UpdateFrequency("Update frequency", "menu"),
    ExternalCache("External cache", "tick"),
    CacheSize("Cache size", "menu"),
    ClearCache("Clear cache", "menu"),

//    Offline Reading
    ScheduleDownload("Schedule download", "tick"),
    DownloadTime("Download time", "menu"),
    WifiOnly("Wifi only", "tick"),
    IncludeImages("Include article images", "tick"),
    IncludeGalleryImages("Include gallery images", "tick"),
    IncludeComment("Include comments", "tick"),
    ViewDownloadLog("View download log", "menu"),

//    Notifications
    NewsAlerts("Guardian", "tick")
    ;


    public final String uiName;
    public final String type;

    SettingsOptions(String type){
        this.uiName=this.toString();
        this.type=type;
    }

    SettingsOptions(String uiName, String type){
        this.uiName=uiName;
        this.type=type;
    }


}
