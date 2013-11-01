package page_objects.pages;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import page_objects.helpers.Utility;
import page_objects.navigation.GlobalNav;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 23/09/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class ItemSuper {

//=====================================================
// Checks
//=====================================================

    public boolean checkActionBarContents() throws UiObjectNotFoundException {
        return isBackButtonPresent() && isShareButtonPresent() && isSavePageButtonPresent() && isTextSizeeButtonPresent();
    }

//=====================================================
// Actions
//=====================================================

    public void swipeToNextArticle() {
        int startX = (UiDevice.getInstance().getDisplayWidth()-5);
        int endX = 0;
        int y = (UiDevice.getInstance().getDisplayHeight())/2;
        UiDevice.getInstance().swipe(startX, y, endX, y, 50);
    }

    public void swipeToPreviousArticle() {
        int startX = 0;
        int endX = (UiDevice.getInstance().getDisplayWidth()-5);
        int y = (UiDevice.getInstance().getDisplayHeight())/2;
        UiDevice.getInstance().swipe(startX, y, endX, y, 50);
    }

    public boolean isItemContentPresent() throws UiObjectNotFoundException{
        if (new UiObject(new UiSelector().className("android.webkit.WebView")).exists()){
            Utility.logMessage("Item content present");
            return true;
        }
        else{
            throw new UiObjectNotFoundException("No content is present");
        }
    }

    public void swipePerformanceCheck() {
            swipeToNextArticle();
            swipeToPreviousArticle();
            swipeToNextArticle();

    }

//=====================================================
// Action bar
//=====================================================

    public void pressBackButton() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("Navigate up")).click();
        Utility.logMessage("Action bar BACK button pressed");
    }

    public void pressShareButton() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("Share")).click();
        Utility.logMessage("Action bar SHARE button pressed");
    }

    public void pressSavePageButton() throws UiObjectNotFoundException {
        Utility.selectOverflowOrDeviceMenuButton();
        new UiObject(new UiSelector().text("Save page")).click();
        Utility.logMessage("Save page button pressed");
    }

    public void pressTextSizeButton() throws UiObjectNotFoundException {
        Utility.selectOverflowOrDeviceMenuButton();
        new UiObject(new UiSelector().text("Text size")).click();
        Utility.logMessage("Text size button pressed");
    }

//=====================================================
// Action bar checks
//=====================================================

    public boolean isBackButtonPresent() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description("Navigate up")).exists()){
            Utility.logMessage("Back button present");
            return true;
        }
        else {
            Utility.logMessage("Back button NOT present");
            throw new UiObjectNotFoundException("Back button not present");
        }
    }

    public boolean isShareButtonPresent() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description("Share")).exists()){
            Utility.logMessage("Share button present");
            return true;
        }
        else {
            Utility.logMessage("Share button NOT present");
            throw new UiObjectNotFoundException("Share button not present");
        }
    }

    public boolean isSavePageButtonPresent() throws UiObjectNotFoundException {
        Utility.selectOverflowOrDeviceMenuButton();
        if (new UiObject(new UiSelector().text("Save page")).exists()){
            Utility.logMessage("Save page button present");
            UiDevice.getInstance().pressBack();
            return true;
        }
        else {
            Utility.logMessage("Save page button NOT present");
            UiDevice.getInstance().pressBack();
            throw new UiObjectNotFoundException("Save page button not present");
        }
    }

    public boolean isTextSizeeButtonPresent() throws UiObjectNotFoundException {
        Utility.selectOverflowOrDeviceMenuButton();
        if (new UiObject(new UiSelector().text("Text size")).exists()){
            Utility.logMessage("Text size button present");
            UiDevice.getInstance().pressBack();
            return true;
        }
        else {
            Utility.logMessage("Text size button NOT present");
            UiDevice.getInstance().pressBack();
            throw new UiObjectNotFoundException("Text size button not present");
        }
    }
}
