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

package page_objects.navigation;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import page_objects.helpers.SectionNames;
import page_objects.helpers.Utility;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 16/09/13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class GlobalNav extends UiAutomatorTestCase {

//=====================================================
// Navigation
//=====================================================

    public void openSection(SectionNames sectionName) throws UiObjectNotFoundException {

        new UiObject(new UiSelector().description("Navigate up")).click();

        if (sectionName.parent != null) {
            clickSection(sectionName.parent.uiName);
        }
        clickSection(sectionName.uiName);
    }

    public void clickSection(String sectionNameStr) throws UiObjectNotFoundException {
        if (new UiObject(new UiSelector().description(sectionNameStr)).exists()) {
            new UiObject(new UiSelector().description(sectionNameStr)).click();
            Utility.logMessage(sectionNameStr + " section opened");
        } else {

            if (new UiScrollable(new UiSelector().scrollable(true)).exists()) {
                UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));

                boolean found = scrollList.scrollIntoView(new UiObject(new UiSelector().description(sectionNameStr)));

                if (!found) {
                    found = scrollList.scrollIntoView(new UiObject(new UiSelector().description("Home")));
                    if (!found)
                        throw new UiObjectNotFoundException("CANNOT FIND OBJECT");
                    new UiObject(new UiSelector().description("Home")).click();
                }
            } else {
                new UiObject(new UiSelector().description("Home")).click();
            }

            new UiObject(new UiSelector().description(sectionNameStr)).click();
            Utility.logMessage(sectionNameStr + " section opened");
        }
    }

//=====================================================
// Sections
//=====================================================

    public void navigateToSectionHome () throws UiObjectNotFoundException {
        openSection(SectionNames.Home);
    }

    public void navigateToSectionUKNews () throws UiObjectNotFoundException {
        openSection(SectionNames.UKNews);
    }

    public void navigateToSectionWorld () throws UiObjectNotFoundException {
        openSection(SectionNames.World);
    }

    public void navigateToSectionComment () throws UiObjectNotFoundException {
        openSection(SectionNames.Comment);
    }

    public void navigateToSectionSport () throws UiObjectNotFoundException {
        openSection(SectionNames.Sport);
    }

    public void navigateToSectionFootball () throws UiObjectNotFoundException {
        openSection(SectionNames.Football);
    }

    public void navigateToSectionLifeStyle () throws UiObjectNotFoundException {
        openSection(SectionNames.LifeStyle);
    }

    public void navigateToSectionCulture () throws UiObjectNotFoundException {
        openSection(SectionNames.Culture);
    }

    public void navigateToSectionBusiness () throws UiObjectNotFoundException {
        openSection(SectionNames.Business);
    }

    public void navigateToSectionMoney () throws UiObjectNotFoundException {
        openSection(SectionNames.Money);
    }

    public void navigateToSectionTravel () throws UiObjectNotFoundException {
        openSection(SectionNames.Travel);
    }

    public void navigateToSectionTech () throws UiObjectNotFoundException {
        openSection(SectionNames.Tech);
    }

    public void navigateToSectionEnvironment () throws UiObjectNotFoundException {
        openSection(SectionNames.Environment);
    }

//=====================================================
// Sub Sections
//=====================================================

    public void navigateToSubsectionUKPolitics () throws UiObjectNotFoundException {
        openSection(SectionNames.Politics);
    }

    public void navigateToSubsectionUKMedia () throws UiObjectNotFoundException {
        openSection(SectionNames.Media);
    }

    public void navigateToSubsectionUKScience () throws UiObjectNotFoundException {
        openSection(SectionNames.Science);
    }

    public void navigateToSubsectionUKSociety () throws UiObjectNotFoundException {
        openSection(SectionNames.Society);
    }

    public void navigateToSubsectionUKHealth () throws UiObjectNotFoundException {
        openSection(SectionNames.Health);
    }

    public void navigateToSubsectionUKEducation () throws UiObjectNotFoundException {
        openSection(SectionNames.Education);
    }

    public void navigateToSubsectionWorldUS () throws UiObjectNotFoundException {
        openSection(SectionNames.US);
    }

    public void navigateToSubsectionWorldEurope () throws UiObjectNotFoundException {
        openSection(SectionNames.Europe);
    }

    public void navigateToSubsectionWorldAfrica () throws UiObjectNotFoundException {
        openSection(SectionNames.Africa);
    }

    public void navigateToSubsectionWorldAsia () throws UiObjectNotFoundException {
        openSection(SectionNames.Asia);
    }

    public void navigateToSubsectionWorldAustralia () throws UiObjectNotFoundException {
        openSection(SectionNames.Australia);
    }

    public void navigateToSubsectionWorldAmericas () throws UiObjectNotFoundException {
        openSection(SectionNames.Americas);
    }

    public void navigateToSubsectionCommentCIFAmerica () throws UiObjectNotFoundException {
        openSection(SectionNames.CIFAmerica);
    }

    public void navigateToSubsectionCommentCIFBelief () throws UiObjectNotFoundException {
        openSection(SectionNames.CIFBelief);
    }

    public void navigateToSubsectionCommentCartoon () throws UiObjectNotFoundException {
        openSection(SectionNames.Cartoon);
    }

    public void navigateToSubsectionSportCricket () throws UiObjectNotFoundException {
        openSection(SectionNames.Cricket);
    }

    public void navigateToSubsectionSportRugbyUnion () throws UiObjectNotFoundException {
        openSection(SectionNames.RugbyUnion);
    }

    public void navigateToSubsectionSportMotorSport () throws UiObjectNotFoundException {
        openSection(SectionNames.MotorSport);
    }

    public void navigateToSubsectionSportTennis () throws UiObjectNotFoundException {
        openSection(SectionNames.Tennis);
    }

    public void navigateToSubsectionSportGolf () throws UiObjectNotFoundException {
        openSection(SectionNames.Golf);
    }

    public void navigateToSubsectionSportHorseRacing () throws UiObjectNotFoundException {
        openSection(SectionNames.HorseRacing);
    }

    public void navigateToSubsectionSportRugbyLeague () throws UiObjectNotFoundException {
        openSection(SectionNames.RugbyLeague);
    }

    public void navigateToSubsectionSportUSSport () throws UiObjectNotFoundException {
        openSection(SectionNames.USSport);
    }

    public void navigateToSubsectionSportBoxing () throws UiObjectNotFoundException {
        openSection(SectionNames.Boxing);
    }

    public void navigateToSubsectionSportCycling () throws UiObjectNotFoundException {
        openSection(SectionNames.Cycling);
    }

    public void navigateToSubsectionFootballLiveScores () throws UiObjectNotFoundException {
        openSection(SectionNames.LiveScores);
    }

    public void navigateToSubsectionFootballClubs () throws UiObjectNotFoundException {
        openSection(SectionNames.Clubs);
    }

    public void navigateToSubsectionFootballCompetitions () throws UiObjectNotFoundException {
        openSection(SectionNames.Competitions);
    }

    public void navigateToSubsectionFootballResults () throws UiObjectNotFoundException {
        openSection(SectionNames.Results);
    }

    public void navigateToSubsectionFootballFixtures () throws UiObjectNotFoundException {
        openSection(SectionNames.Fixtures);
    }

    public void navigateToSubsectionFootballTables () throws UiObjectNotFoundException {
        openSection(SectionNames.Tables);
    }

    public void navigateToSubsectionLifeStyleFoodDrink () throws UiObjectNotFoundException {
        openSection(SectionNames.FoodDrink);
    }

    public void navigateToSubsectionLifeStyleFashion () throws UiObjectNotFoundException {
        openSection(SectionNames.Fashion);
    }

    public void navigateToSubsectionLifeStyleHomes () throws UiObjectNotFoundException {
        openSection(SectionNames.Homes);
    }

    public void navigateToSubsectionLifeStyleWomen () throws UiObjectNotFoundException {
        openSection(SectionNames.Women);
    }

    public void navigateToSubsectionLifeStyleLoveFamily () throws UiObjectNotFoundException {
        openSection(SectionNames.LoveFamily);
    }

    public void navigateToSubsectionLifeStyleWellbeing () throws UiObjectNotFoundException {
        openSection(SectionNames.Wellbeing);
    }

    public void navigateToSubsectionCultureTVRadio () throws UiObjectNotFoundException {
        openSection(SectionNames.TVRadio);
    }

    public void navigateToSubsectionCultureFilm () throws UiObjectNotFoundException {
        openSection(SectionNames.Film);
    }

    public void navigateToSubsectionCultureMusic () throws UiObjectNotFoundException {
        openSection(SectionNames.Music);
    }

    public void navigateToSubsectionCultureStage () throws UiObjectNotFoundException {
        openSection(SectionNames.Stage);
    }

    public void navigateToSubsectionCultureBooks () throws UiObjectNotFoundException {
        openSection(SectionNames.Books);
    }

    public void navigateToSubsectionCultureArtDesign () throws UiObjectNotFoundException {
        openSection(SectionNames.ArtDesign);
    }

    public void navigateToSubsectionBusinessEconomics () throws UiObjectNotFoundException {
        openSection(SectionNames.Economics);
    }

    public void navigateToSubsectionBusinessEuroCrisis () throws UiObjectNotFoundException {
        openSection(SectionNames.EuroCrisis);
    }

    public void navigateToSubsectionBusinessEuro () throws UiObjectNotFoundException {
        openSection(SectionNames.Euro);
    }

    public void navigateToSubsectionBusinessBanking () throws UiObjectNotFoundException {
        openSection(SectionNames.Banking);
    }

    public void navigateToSubsectionBusinessRetail () throws UiObjectNotFoundException {
        openSection(SectionNames.Retail);
    }

    public void navigateToSubsectionMoneyConsumer () throws UiObjectNotFoundException {
        openSection(SectionNames.Consumer);
    }

    public void navigateToSubsectionMoneyProperty () throws UiObjectNotFoundException {
        openSection(SectionNames.Property);
    }

    public void navigateToSubsectionMoneyWork () throws UiObjectNotFoundException {
        openSection(SectionNames.Work);
    }

    public void navigateToSubsectionMoneyFamilyFinances () throws UiObjectNotFoundException {
        openSection(SectionNames.FamilyFin);
    }

    public void navigateToSubsectionMoneySaving () throws UiObjectNotFoundException {
        openSection(SectionNames.Saving);
    }

    public void navigateToSubsectionMoneyBorrowing () throws UiObjectNotFoundException {
        openSection(SectionNames.Borrowing);
    }

    public void navigateToSubsectionTravelShortBreaks () throws UiObjectNotFoundException {
        openSection(SectionNames.ShortBreaks);
    }

    public void navigateToSubsectionTravelTopTens () throws UiObjectNotFoundException {
        openSection(SectionNames.TopsTens);
    }

    public void navigateToSubsectionTravelEurope () throws UiObjectNotFoundException {
        openSection(SectionNames.EuropeTr);
    }

    public void navigateToSubsectionTravelHotels () throws UiObjectNotFoundException {
        openSection(SectionNames.Hotels);
    }

    public void navigateToSubsectionTravelFoodDrink () throws UiObjectNotFoundException {
        openSection(SectionNames.FoodDr);
    }

    public void navigateToSubsectionTechGames () throws UiObjectNotFoundException {
        openSection(SectionNames.Games);
    }

    public void navigateToSubsectionTechMobilesTablets () throws UiObjectNotFoundException {
        openSection(SectionNames.MobTab);
    }

    public void navigateToSubsectionTechApps () throws UiObjectNotFoundException {
        openSection(SectionNames.Apps);
    }

    public void navigateToSubsectionTechApple () throws UiObjectNotFoundException {
        openSection(SectionNames.Apple);
    }

    public void navigateToSubsectionTechGoogle () throws UiObjectNotFoundException {
        openSection(SectionNames.Google);
    }

    public void navigateToSubsectionEnvironmentClimateChange () throws UiObjectNotFoundException {
        openSection(SectionNames.ClimChange);
    }

    public void navigateToSubsectionEnvironmentWildlife () throws UiObjectNotFoundException {
        openSection(SectionNames.Wildlife);
    }

    public void navigateToSubsectionEnvironmentEnergy () throws UiObjectNotFoundException {
        openSection(SectionNames.Energy);
    }

    public void navigateToSubsectionEnvironmentConservation () throws UiObjectNotFoundException {
        openSection(SectionNames.Conservation);
    }

    public void navigateToSubsectionEnvironmentFood () throws UiObjectNotFoundException {
        openSection(SectionNames.Food);
    }

}