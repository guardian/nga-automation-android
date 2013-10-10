package page_objects.pages;

import com.android.uiautomator.core.UiDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.UIAutomatorLogging.UiDeviceLog;
import page_objects.navigation.GlobalNav;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 23/09/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class ItemSuper extends GlobalNav {

    Logger logger = LoggerFactory.getLogger("page_objects.pages.ItemSuper");

    public void swipeToNextArticle() {
        int startX = (UiDevice.getInstance().getDisplayWidth()-5);
        int endX = 0;
        int y = (UiDevice.getInstance().getDisplayHeight())/2;
        UiDeviceLog.swipe(startX, y, endX, y, 50);
    }

    public void swipeToPreviousArticle() {
        int startX = 0;
        int endX = (UiDevice.getInstance().getDisplayWidth()-5);
        int y = (UiDevice.getInstance().getDisplayHeight())/2;
        UiDeviceLog.swipe(startX, y, endX, y, 50);
    }

    public void swipePerformanceCheck() {
        int i = 1;

        while (i<21){
            swipeToNextArticle();
            swipeToPreviousArticle();
            swipeToNextArticle();
            i++;
            logger.debug("Article checked: "+i);

//            TODO: Assert content present with each swipe
//            TODO: Catch crash as test failure - not reliant on objectnotfound crash
        }

    }
}
