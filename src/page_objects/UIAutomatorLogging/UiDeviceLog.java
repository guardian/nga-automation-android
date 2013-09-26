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

import com.android.uiautomator.core.UiDevice;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 26/09/13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class UiDeviceLog {

    public static void deviceLogger(String message){
        System.out.println("***DEVICE LOG: " + message);
    }

    public static void swipe (int startX, int startY, int endX, int endY, int steps){
        UiDevice.getInstance().swipe(startX,startY,endX,endY,steps);

        String swipeX = null;
        String swipeY = null;

        if (startX>endX){
            swipeX = "West";
        }
        if (startX<endX){
            swipeX = "East";
        }
        if (startX==endX){
            swipeX = "";
        }
        if (startY>endY){
            swipeY = "South";
        }
        if (startY<endY){
            swipeY = "North";
        }
        if (startY==endY){
            swipeY = "";
        }

        String message = swipeY + swipeX + " swipe";
        deviceLogger(message);
    }

    public static void pressBack(){
        UiDevice.getInstance().pressBack();
        String message = "button pressed - BACK";
        deviceLogger(message);
    }

    public static void pressEnter(){
        UiDevice.getInstance().pressEnter();
        String message = "button pressed - ENTER";
        deviceLogger(message);
    }

}
