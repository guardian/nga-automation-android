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

package page_objects.sections;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import page_objects.navigation.GlobalNav;
import page_objects.pages.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 19/09/13
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class SectionSuper extends GlobalNav {

//=====================================================
// Actions
//=====================================================

    public ArticlePage openFirstArticle () throws UiObjectNotFoundException {
        new UiObject(new UiSelector().descriptionStartsWith("Article")).click();
        return new ArticlePage();
    }

    public LiveBlogPage openFirstLiveblog () throws UiObjectNotFoundException {
        new UiObject(new UiSelector().descriptionStartsWith("Live")).click();
        return new LiveBlogPage();
    }

    public VideoArticlePage openFirstVideoArticle () throws UiObjectNotFoundException {
        new UiObject(new UiSelector().descriptionStartsWith("Video")).click();
        return new VideoArticlePage();
    }

    public AudioArticlePage openFirstAudioArticle () throws UiObjectNotFoundException {
        new UiObject(new UiSelector().descriptionStartsWith("Audio")).click();
        return new AudioArticlePage();
    }

    public GalleryPage openFirstGallery () throws UiObjectNotFoundException {
        new UiObject(new UiSelector().descriptionStartsWith("Gallery")).click();
        return new GalleryPage();
    }


//=====================================================
// Checks
//=====================================================

    public String getSectionTitle() throws UiObjectNotFoundException {
        String sectionTitle = new UiObject(new UiSelector().className("android.widget.FrameLayout").index(1).childSelector(new UiSelector().className("android.widget.TextView").index(0))).getText();
        return sectionTitle;
    }

    public boolean isStandardArticlePresent () throws UiObjectNotFoundException{
        UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
        return scrollList.scrollIntoView(new UiSelector().descriptionStartsWith("Article"));
    }

    public boolean isLiveBlogPresent () throws UiObjectNotFoundException{
        UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
        return scrollList.scrollIntoView(new UiSelector().descriptionStartsWith("Live"));
    }

    public boolean isVideoArticlePresent () throws UiObjectNotFoundException{
        UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
        return scrollList.scrollIntoView(new UiSelector().descriptionStartsWith("Video"));
    }

    public boolean isAudioArticlePresent () throws UiObjectNotFoundException{
        UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
        return scrollList.scrollIntoView(new UiSelector().descriptionStartsWith("Audio"));
    }

    public boolean isGalleryPresent () throws UiObjectNotFoundException{
        UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
        return scrollList.scrollIntoView(new UiSelector().descriptionStartsWith("Gallery"));
    }

}
