package page_objects.pages;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import page_objects.navigation.GlobalNav;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 23/09/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class ItemSuper extends GlobalNav {

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

    public boolean isItemContentPresent(){
        Boolean present = null;
        if (new UiObject(new UiSelector().className("android.webkit.WebView")).exists()){
            present = true;
        }
        return present;
    }

    public void swipePerformanceCheck() {
            swipeToNextArticle();
            swipeToPreviousArticle();
            swipeToNextArticle();

    }
}
