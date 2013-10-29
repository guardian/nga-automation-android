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

import com.android.uiautomator.core.*;
import page_objects.helpers.SectionNames;
import page_objects.helpers.Utility;
import page_objects.pages.HomePage;
import page_objects.sections.*;
import page_objects.subsections.business.*;
import page_objects.subsections.comment.*;
import page_objects.subsections.culture.*;
import page_objects.subsections.environment.*;
import page_objects.subsections.football.*;
import page_objects.subsections.lifestyle.*;
import page_objects.subsections.money.*;
import page_objects.subsections.sport.*;
import page_objects.subsections.tech.*;
import page_objects.subsections.travel.*;
import page_objects.subsections.uknews.*;
import page_objects.subsections.world.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jharewinton
 * Date: 16/09/13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class GlobalNav {

//=====================================================
// Navigation
//=====================================================

    public void openSection(SectionNames sectionName) throws UiObjectNotFoundException {

        SectionSuper sectionSuper = new SectionSuper();

        new UiObject(new UiSelector().description("Navigate up")).click();

        String currentSection = getCapitalisedSectionTitle();
        Utility.logMessage("Current section = " +currentSection);

        if (sectionName.parent != null && sectionName.parent.toString().equals(currentSection)){
            clickSection(sectionName.uiName);

            int i = 0;

            while (!sectionSuper.isAnyContentPresent() && i<10){
                Utility.waitTwoSeconds();
                i++;
            }

            if (i>=10 && !sectionSuper.isAnyContentPresent()) {
                throw new UiObjectNotFoundException("No content present");
            }
        }

        else if (sectionName.parent != null && !sectionName.parent.toString().equals(currentSection)) {
            clickSection(sectionName.parent.uiName);
            clickSection(sectionName.uiName);

            int i = 0;

            while (!sectionSuper.isAnyContentPresent() && i<10){
                Utility.waitTwoSeconds();
                i++;
            }

            if (i>=10 && !sectionSuper.isAnyContentPresent()) {
                throw new UiObjectNotFoundException("No content present");
            }
        }
        else {
            clickSection(sectionName.uiName);
            new UiObject(new UiSelector().descriptionStartsWith("Guardian,")).click();

            int i = 0;

            while (!sectionSuper.isAnyContentPresent() && i<10){
                Utility.waitTwoSeconds();
                i++;
            }

            if (i>=10 && !sectionSuper.isAnyContentPresent()) {
                throw new UiObjectNotFoundException("No content present");
            }
        }
    }

    public void clickSection(String sectionNameStr) throws UiObjectNotFoundException {
        if (sectionNameStr.equals("Home")){
            new UiObject(new UiSelector().description(sectionNameStr)).clickAndWaitForNewWindow();
            Utility.logMessage(sectionNameStr + " section opened");
        }

        else if (new UiObject(new UiSelector().description(sectionNameStr)).exists()) {
            new UiObject(new UiSelector().description(sectionNameStr)).clickAndWaitForNewWindow();
            Utility.logMessage(sectionNameStr + " section opened");
        }
        else {

            if (new UiScrollable(new UiSelector().scrollable(true)).exists()) {
                UiScrollable scrollList = new UiScrollable(new UiSelector().scrollable(true));
                scrollList.flingToBeginning(10);

                boolean found = scrollList.scrollIntoView(new UiObject(new UiSelector().description(sectionNameStr)));

                if (!found) {
                    found = scrollList.scrollIntoView(new UiObject(new UiSelector().description("Home")));
                    if (!found)
                        throw new UiObjectNotFoundException("CANNOT FIND OBJECT "+sectionNameStr );
                    new UiObject(new UiSelector().description("Home")).click();
                }
            }
               else {
                new UiObject(new UiSelector().description("Home")).click();
            }

            if (new UiScrollable(new UiSelector().scrollable(true)).exists()) {
                new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(sectionNameStr));
            }

            new UiObject(new UiSelector().description(sectionNameStr)).clickAndWaitForNewWindow();
            Utility.logMessage(sectionNameStr + " section opened");
        }
    }

//=====================================================
// Sections
//=====================================================

    public HomePage navigateToSectionHome () throws UiObjectNotFoundException {
        openSection(SectionNames.Home);
        return new HomePage();
    }

    public UKNews navigateToSectionUKNews () throws UiObjectNotFoundException {
        openSection(SectionNames.UKNews);
        return new UKNews();
    }

    public World navigateToSectionWorld () throws UiObjectNotFoundException {
        openSection(SectionNames.World);
        return new World();
    }

    public Comment navigateToSectionComment () throws UiObjectNotFoundException {
        openSection(SectionNames.Comment);
        return new Comment();
    }

    public Sport navigateToSectionSport () throws UiObjectNotFoundException {
        openSection(SectionNames.Sport);
        return new Sport();
    }

    public Football navigateToSectionFootball () throws UiObjectNotFoundException {
        openSection(SectionNames.Football);
        return new Football();
    }

    public LifeStyle navigateToSectionLifeStyle () throws UiObjectNotFoundException {
        openSection(SectionNames.LifeStyle);
        return new LifeStyle();
    }

    public Culture navigateToSectionCulture () throws UiObjectNotFoundException {
        openSection(SectionNames.Culture);
        return new Culture();
    }

    public Business navigateToSectionBusiness () throws UiObjectNotFoundException {
        openSection(SectionNames.Business);
        return new Business();
    }

    public Money navigateToSectionMoney () throws UiObjectNotFoundException {
        openSection(SectionNames.Money);
        return new Money();
    }

    public Travel navigateToSectionTravel () throws UiObjectNotFoundException {
        openSection(SectionNames.Travel);
        return new Travel();
    }

    public Tech navigateToSectionTech () throws UiObjectNotFoundException {
        openSection(SectionNames.Tech);
        return new Tech();
    }

    public Environment navigateToSectionEnvironment () throws UiObjectNotFoundException {
        openSection(SectionNames.Environment);
        return new Environment();
    }

//=====================================================
// Sub Sections
//=====================================================

    public UKPolitics navigateToSubsectionUKPolitics () throws UiObjectNotFoundException {
        openSection(SectionNames.Politics);
        return new UKPolitics();
    }

    public UKMedia navigateToSubsectionUKMedia () throws UiObjectNotFoundException {
        openSection(SectionNames.Media);
        return new UKMedia();
    }

    public UKScience navigateToSubsectionUKScience () throws UiObjectNotFoundException {
        openSection(SectionNames.Science);
        return new UKScience();
    }

    public UKSociety navigateToSubsectionUKSociety () throws UiObjectNotFoundException {
        openSection(SectionNames.Society);
        return new UKSociety();
    }

    public UKHealth navigateToSubsectionUKHealth () throws UiObjectNotFoundException {
        openSection(SectionNames.Health);
        return new UKHealth();
    }

    public UKEducation navigateToSubsectionUKEducation () throws UiObjectNotFoundException {
        openSection(SectionNames.Education);
        return new UKEducation();
    }

    public WorldUS navigateToSubsectionWorldUS () throws UiObjectNotFoundException {
        openSection(SectionNames.US);
        return new WorldUS();
    }

    public WorldEurope navigateToSubsectionWorldEurope () throws UiObjectNotFoundException {
        openSection(SectionNames.Europe);
        return new WorldEurope();
    }

    public WorldAfrica navigateToSubsectionWorldAfrica () throws UiObjectNotFoundException {
        openSection(SectionNames.Africa);
        return new WorldAfrica();
    }

    public WorldAsia navigateToSubsectionWorldAsia () throws UiObjectNotFoundException {
        openSection(SectionNames.Asia);
        return new WorldAsia();
    }

    public WorldAustralia navigateToSubsectionWorldAustralia () throws UiObjectNotFoundException {
        openSection(SectionNames.Australia);
        return new WorldAustralia();
    }

    public WorldAmericas navigateToSubsectionWorldAmericas () throws UiObjectNotFoundException {
        openSection(SectionNames.Americas);
        return new WorldAmericas();
    }

    public CommentCIFAmerica navigateToSubsectionCommentCIFAmerica () throws UiObjectNotFoundException {
        openSection(SectionNames.CIFAmerica);
        return new CommentCIFAmerica();
    }

    public CommentCIFBelief navigateToSubsectionCommentCIFBelief () throws UiObjectNotFoundException {
        openSection(SectionNames.CIFBelief);
        return new CommentCIFBelief();
    }

    public CommentCartoon navigateToSubsectionCommentCartoon () throws UiObjectNotFoundException {
        openSection(SectionNames.Cartoon);
        return new CommentCartoon();
    }

    public SportCricket navigateToSubsectionSportCricket () throws UiObjectNotFoundException {
        openSection(SectionNames.Cricket);
        return new SportCricket();
    }

    public SportRugbyUnion navigateToSubsectionSportRugbyUnion () throws UiObjectNotFoundException {
        openSection(SectionNames.RugbyUnion);
        return new SportRugbyUnion();
    }

    public SportMotorSport navigateToSubsectionSportMotorSport () throws UiObjectNotFoundException {
        openSection(SectionNames.MotorSport);
        return new SportMotorSport();
    }

    public SportTennis navigateToSubsectionSportTennis () throws UiObjectNotFoundException {
        openSection(SectionNames.Tennis);
        return new SportTennis();
    }

    public SportGolf navigateToSubsectionSportGolf () throws UiObjectNotFoundException {
        openSection(SectionNames.Golf);
        return new SportGolf();
    }

    public SportHorseRacing navigateToSubsectionSportHorseRacing () throws UiObjectNotFoundException {
        openSection(SectionNames.HorseRacing);
        return new SportHorseRacing();
    }

    public SportRugbyLeague navigateToSubsectionSportRugbyLeague () throws UiObjectNotFoundException {
        openSection(SectionNames.RugbyLeague);
        return new SportRugbyLeague();
    }

    public SportUSSport navigateToSubsectionSportUSSport () throws UiObjectNotFoundException {
        openSection(SectionNames.USSport);
        return new SportUSSport();
    }

    public SportBoxing navigateToSubsectionSportBoxing () throws UiObjectNotFoundException {
        openSection(SectionNames.Boxing);
        return new SportBoxing();
    }

    public SportCycling navigateToSubsectionSportCycling () throws UiObjectNotFoundException {
        openSection(SectionNames.Cycling);
        return new SportCycling();
    }

    public FootballLiveScores navigateToSubsectionFootballLiveScores () throws UiObjectNotFoundException {
        openSection(SectionNames.LiveScores);
        return new FootballLiveScores();
    }

    public FootballClubs navigateToSubsectionFootballClubs () throws UiObjectNotFoundException {
        openSection(SectionNames.Clubs);
        return new FootballClubs();
    }

    public FootballCompetitions navigateToSubsectionFootballCompetitions () throws UiObjectNotFoundException {
        openSection(SectionNames.Competitions);
        return new FootballCompetitions();
    }

    public FootballResults navigateToSubsectionFootballResults () throws UiObjectNotFoundException {
        openSection(SectionNames.Results);
        return new FootballResults();
    }

    public FootballFixtures navigateToSubsectionFootballFixtures () throws UiObjectNotFoundException {
        openSection(SectionNames.Fixtures);
        return new FootballFixtures();
    }

    public FootballTables navigateToSubsectionFootballTables () throws UiObjectNotFoundException {
        openSection(SectionNames.Tables);
        return new FootballTables();
    }

    public LifeStyleFoodDrink navigateToSubsectionLifeStyleFoodDrink () throws UiObjectNotFoundException {
        openSection(SectionNames.FoodDrink);
        return new LifeStyleFoodDrink();
    }

    public LifeStyleFashion navigateToSubsectionLifeStyleFashion () throws UiObjectNotFoundException {
        openSection(SectionNames.Fashion);
        return new LifeStyleFashion();
    }

    public LifeStyleHomes navigateToSubsectionLifeStyleHomes () throws UiObjectNotFoundException {
        openSection(SectionNames.Homes);
        return new LifeStyleHomes();
    }

    public LifeStyleWomen navigateToSubsectionLifeStyleWomen () throws UiObjectNotFoundException {
        openSection(SectionNames.Women);
        return new LifeStyleWomen();
    }

    public LifeStyleLoveFamily navigateToSubsectionLifeStyleLoveFamily () throws UiObjectNotFoundException {
        openSection(SectionNames.LoveFamily);
        return new LifeStyleLoveFamily();
    }

    public LifeStyleWellbeing navigateToSubsectionLifeStyleWellbeing () throws UiObjectNotFoundException {
        openSection(SectionNames.Wellbeing);
        return new LifeStyleWellbeing();
    }

    public CultureTVRadio navigateToSubsectionCultureTVRadio () throws UiObjectNotFoundException {
        openSection(SectionNames.TVRadio);
        return new CultureTVRadio();
    }

    public CultureFilm navigateToSubsectionCultureFilm () throws UiObjectNotFoundException {
        openSection(SectionNames.Film);
        return new CultureFilm();
    }

    public CultureMusic navigateToSubsectionCultureMusic () throws UiObjectNotFoundException {
        openSection(SectionNames.Music);
        return new CultureMusic();
    }

    public CultureStage navigateToSubsectionCultureStage () throws UiObjectNotFoundException {
        openSection(SectionNames.Stage);
        return new CultureStage();
    }

    public CultureBooks navigateToSubsectionCultureBooks () throws UiObjectNotFoundException {
        openSection(SectionNames.Books);
        return new CultureBooks();
    }

    public CultureArtDesign navigateToSubsectionCultureArtDesign () throws UiObjectNotFoundException {
        openSection(SectionNames.ArtDesign);
        return new CultureArtDesign();
    }

    public BusinessEconomics navigateToSubsectionBusinessEconomics () throws UiObjectNotFoundException {
        openSection(SectionNames.Economics);
        return new BusinessEconomics();
    }

    public BusinessEuroCrisis navigateToSubsectionBusinessEuroCrisis () throws UiObjectNotFoundException {
        openSection(SectionNames.EuroCrisis);
        return new BusinessEuroCrisis();
    }

    public BusinessEuro navigateToSubsectionBusinessEuro () throws UiObjectNotFoundException {
        openSection(SectionNames.Euro);
        return new BusinessEuro();
    }

    public BusinessBanking navigateToSubsectionBusinessBanking () throws UiObjectNotFoundException {
        openSection(SectionNames.Banking);
        return new BusinessBanking();
    }

    public BusinessRetail navigateToSubsectionBusinessRetail () throws UiObjectNotFoundException {
        openSection(SectionNames.Retail);
        return new BusinessRetail();
    }

    public MoneyConsumer navigateToSubsectionMoneyConsumer () throws UiObjectNotFoundException {
        openSection(SectionNames.Consumer);
        return new MoneyConsumer();
    }

    public MoneyProperty navigateToSubsectionMoneyProperty () throws UiObjectNotFoundException {
        openSection(SectionNames.Property);
        return new MoneyProperty();
    }

    public MoneyWork navigateToSubsectionMoneyWork () throws UiObjectNotFoundException {
        openSection(SectionNames.Work);
        return new MoneyWork();
    }

    public MoneyFamilyFinances navigateToSubsectionMoneyFamilyFinances () throws UiObjectNotFoundException {
        openSection(SectionNames.FamilyFin);
        return new MoneyFamilyFinances();
    }

    public MoneySaving navigateToSubsectionMoneySaving () throws UiObjectNotFoundException {
        openSection(SectionNames.Saving);
        return new MoneySaving();
    }

    public MoneyBorrowing navigateToSubsectionMoneyBorrowing () throws UiObjectNotFoundException {
        openSection(SectionNames.Borrowing);
        return new MoneyBorrowing();
    }

    public TravelShortBreaks navigateToSubsectionTravelShortBreaks () throws UiObjectNotFoundException {
        openSection(SectionNames.ShortBreaks);
        return new TravelShortBreaks();
    }

    public TravelTopTens navigateToSubsectionTravelTopTens () throws UiObjectNotFoundException {
        openSection(SectionNames.TopsTens);
        return new TravelTopTens();
    }

    public TravelEurope navigateToSubsectionTravelEurope () throws UiObjectNotFoundException {
        openSection(SectionNames.EuropeTr);
        return new TravelEurope();
    }

    public TravelHotels navigateToSubsectionTravelHotels () throws UiObjectNotFoundException {
        openSection(SectionNames.Hotels);
        return new TravelHotels();
    }

    public TravelFoodDrink navigateToSubsectionTravelFoodDrink () throws UiObjectNotFoundException {
        openSection(SectionNames.FoodDr);
        return new TravelFoodDrink();
    }

    public TechGames navigateToSubsectionTechGames () throws UiObjectNotFoundException {
        openSection(SectionNames.Games);
        return new TechGames();
    }

    public TechMobilesTablets navigateToSubsectionTechMobilesTablets () throws UiObjectNotFoundException {
        openSection(SectionNames.MobTab);
        return new TechMobilesTablets();
    }

    public TechApps navigateToSubsectionTechApps () throws UiObjectNotFoundException {
        openSection(SectionNames.Apps);
        return new TechApps();
    }

    public TechApple navigateToSubsectionTechApple () throws UiObjectNotFoundException {
        openSection(SectionNames.Apple);
        return new TechApple();
    }

    public TechGoogle navigateToSubsectionTechGoogle () throws UiObjectNotFoundException {
        openSection(SectionNames.Google);
        return new TechGoogle();
    }

    public EnvironmentClimateChange navigateToSubsectionEnvironmentClimateChange () throws UiObjectNotFoundException {
        openSection(SectionNames.ClimChange);
        return new EnvironmentClimateChange();
    }

    public EnvironmentWildlife navigateToSubsectionEnvironmentWildlife () throws UiObjectNotFoundException {
        openSection(SectionNames.Wildlife);
        return new EnvironmentWildlife();
    }

    public EnvironmentEnergy navigateToSubsectionEnvironmentEnergy () throws UiObjectNotFoundException {
        openSection(SectionNames.Energy);
        return new EnvironmentEnergy();
    }

    public EnvironmentConservation navigateToSubsectionEnvironmentConservation () throws UiObjectNotFoundException {
        openSection(SectionNames.Conservation);
        return new EnvironmentConservation();
    }

    public EnvironmentFood navigateToSubsectionEnvironmentFood () throws UiObjectNotFoundException {
        openSection(SectionNames.Food);
        return new EnvironmentFood();
    }

//=====================================================
// Actions
//=====================================================

    public String getSectionTitle () throws UiObjectNotFoundException {
        String text = new UiObject(new UiSelector().description("pageTitle")).getText();
        String sectionName;
        if (text.equals("guardian")){
            sectionName = "Home";
        }
        else{
            sectionName = text;
        }
        return sectionName;
    }

    public String getCapitalisedSectionTitle() throws UiObjectNotFoundException {
        String input = getSectionTitle();
        String output = input.substring(0, 1).toUpperCase() + input.substring(1);
        return output;
    }

    public void swipeInNavDrawer () throws UiObjectNotFoundException {
        int deviceHeight = UiDevice.getInstance().getDisplayHeight();
        int deviceWidth = UiDevice.getInstance().getDisplayWidth();
        int yPosition = deviceHeight/2;
        int xStartPosition = 0;
        int xStopPosition =  deviceWidth/2;
        UiDevice.getInstance().swipe(xStartPosition, yPosition, xStopPosition, yPosition, 100);
    }

}