package page_objects.pages;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import page_objects.helpers.Utility;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 23/09/13
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public class LiveBlogPage extends ItemSuper {

//=====================================================
// Checks
//=====================================================

    @Override
    public boolean checkActionBarContents() throws UiObjectNotFoundException {
        if (isBackButtonPresent() &&isRefreshButtonPresent() && isShareButtonPresent() && isSavePageButtonPresent() && isTextSizeeButtonPresent()){
            return true;
        }
        else {
            return false;
        }
    }

//=====================================================
// Action bar
//=====================================================

    public void pressRefresh() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("Refresh")).click();
        Utility.logMessage("Refresh button pressed");
    }

//=====================================================
// Action bar checks
//=====================================================

    public boolean isRefreshButtonPresent() throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description("Refresh")).exists()){
            Utility.logMessage("Refresh button present");
            return true;
        }
        else {
            Utility.logMessage("Refresh button NOT present");
            return false;
        }
    }
}
