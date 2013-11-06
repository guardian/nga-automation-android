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
import page_objects.helpers.ItemTypes;
import page_objects.helpers.SectionNames;
import page_objects.helpers.Utility;
import page_objects.navigation.GlobalNav;
import page_objects.pages.*;
import page_objects.subsections.uknews.UKPolitics;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 19/09/13
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class SectionSuper extends GlobalNav {

//=====================================================
// Navigation
//=====================================================

    @Override
    public void openSection(SectionNames sectionName) throws UiObjectNotFoundException{
        pressNavDrawerButton();
        super.openSection(sectionName);
    }

//=====================================================
// Actions
//=====================================================

    public ArticlePage openFirstStandardArticle() throws UiObjectNotFoundException {
        openFirstItemOfType(ItemTypes.Article);
        return new ArticlePage();
    }

    public LiveBlogPage openFirstLiveblog () throws UiObjectNotFoundException {
        openFirstItemOfType(ItemTypes.Live);
        return new LiveBlogPage();
    }

    public VideoArticlePage openFirstVideoArticle () throws UiObjectNotFoundException {
        openFirstItemOfType(ItemTypes.Video);
        return new VideoArticlePage();
    }

    public AudioArticlePage openFirstAudioArticle () throws UiObjectNotFoundException {
        openFirstItemOfType(ItemTypes.Audio);
        return new AudioArticlePage();
    }

    public GalleryPage openFirstGallery () throws UiObjectNotFoundException {
        openFirstItemOfType(ItemTypes.Gallery);
        return new GalleryPage();
    }

    public CommentArticlePage openFirstCommentArticle () throws UiObjectNotFoundException {
        openFirstItemOfType(ItemTypes.Comment);
        return new CommentArticlePage();
    }

    public ArticlePage navigateToAndOpenStandardArticle () throws UiObjectNotFoundException {
        navigateToAndOpenItemOfType(ItemTypes.Article);
        return new ArticlePage();
    }

    public LiveBlogPage navigateToAndOpenLiveBlog () throws UiObjectNotFoundException {
        navigateToAndOpenItemOfType(ItemTypes.Live);
        return new LiveBlogPage();
    }

    public LiveBlogPage navigateToAndOpenLiveBlogGuided() throws UiObjectNotFoundException {
//        More specific version of navigateToAndOpenLiveBlog. Starts with business and politics sections to increase chance of immediately finding a liveblog

        Business business = this.navigateToSectionBusiness();
        if (!business.isLiveBlogPresent()){
            UKPolitics politics = business.navigateToSubsectionUKPolitics();
            if (politics.isLiveBlogPresent()){
                politics.openFirstLiveblog();
                return new LiveBlogPage();
            }
            else {
                politics.navigateToAndOpenLiveBlog();
                return new LiveBlogPage();
            }
        }
        else{
            business.openFirstLiveblog();
            return new LiveBlogPage();
        }
    }

    public VideoArticlePage navigateToAndOpenVideoArticle () throws UiObjectNotFoundException {
        navigateToAndOpenItemOfType(ItemTypes.Video);
        return new VideoArticlePage();
    }

    public AudioArticlePage navigateToAndOpenAudioArticle () throws UiObjectNotFoundException {
        navigateToAndOpenItemOfType(ItemTypes.Audio);
        return new AudioArticlePage();
    }

    public GalleryPage navigateToAndOpenGallery () throws UiObjectNotFoundException {
        navigateToAndOpenItemOfType(ItemTypes.Gallery);
        return new GalleryPage();
    }

    public CommentArticlePage navigateToAndOpenCommentArticle () throws UiObjectNotFoundException {
        navigateToAndOpenItemOfType(ItemTypes.Comment);
        return new CommentArticlePage();
    }

    public void openFirstItemOfType(ItemTypes itemTypes) throws UiObjectNotFoundException {
        new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionStartsWith(itemTypes.toString()));
        new UiObject(new UiSelector().descriptionStartsWith(itemTypes.toString())).click();
    }

    public void navigateToAndOpenItemOfType (ItemTypes itemTypes) throws UiObjectNotFoundException{
        boolean found = findItemOfType(itemTypes);
        if (found){
            openFirstItemOfType(itemTypes);
        }
        Utility.logMessageFailure("CANNOT FIND ITEM OF TYPE: " +itemTypes);
    }

    public boolean findItemOfType (ItemTypes itemTypes) throws UiObjectNotFoundException {
        for (SectionNames sectionNames : SectionNames.values()){
            openSection(sectionNames);
            Utility.logMessage("Searching section: = " +sectionNames);
            if (isItemOfTypePresent(itemTypes)){
                return true;
            }
        }
        return false;
    }


//=====================================================
// Checks
//=====================================================

    public boolean isItemOfTypePresent (ItemTypes itemType) throws UiObjectNotFoundException {
        UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
        return scrollList.scrollIntoView(new UiSelector().descriptionStartsWith(itemType.toString()));
    }

    public boolean isStandardArticlePresent () throws UiObjectNotFoundException{
        return isItemOfTypePresent(ItemTypes.Article);
    }

    public boolean isLiveBlogPresent () throws UiObjectNotFoundException{
        return isItemOfTypePresent(ItemTypes.Live);
    }

    public boolean isVideoArticlePresent () throws UiObjectNotFoundException{
        return isItemOfTypePresent(ItemTypes.Video);
    }

    public boolean isAudioArticlePresent () throws UiObjectNotFoundException{
        return isItemOfTypePresent(ItemTypes.Audio);
    }

    public boolean isGalleryPresent () throws UiObjectNotFoundException{
        return isItemOfTypePresent(ItemTypes.Gallery);
    }

    public boolean isCommentArticlePresent () throws UiObjectNotFoundException{
        return isItemOfTypePresent(ItemTypes.Comment);
    }

    public boolean isSectionMatchingRandomSection(SectionNames randomSection) throws UiObjectNotFoundException {
        Utility.logMessage("Intended section = " +randomSection.uiName);
        Utility.logMessage("Actual section =" +this.getSectionTitle());

        String actualSectionTitle = this.getSectionTitle().toLowerCase();

        if (actualSectionTitle.equals(randomSection.uiName.toLowerCase())){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isAnyContentPresent () throws UiObjectNotFoundException{
        boolean present = false;
        for (ItemTypes item : ItemTypes.values()){
            present = isItemOfTypePresent(item);
            if (present){
                break;
            }
        }
        Utility.logMessage("Content present = "+present);
        return present;
    }

}
