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
 * Date: 17/09/13
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public enum SectionNames {

        Home,

        UKNews("UK news"),
            Politics (UKNews),
            Media (UKNews),
            Science (UKNews),
            Society (UKNews),
            Health (UKNews),
            Education (UKNews),
        World,
            US (World),
            Europe (World),
            Africa (World),
            Asia (World),
            Australia (World),
            Americas (World),
        Comment,
            CIFAmerica ("CIF America", Comment),
            CIFBelief ("CIF Belief", Comment),
            Cartoon (Comment),
        Sport,
            Cricket(Sport),
            RugbyUnion ("Rugby Union", Sport),
            MotorSport ("Motor sport", Sport),
            Tennis ("Tennis", Sport),
            Golf (Sport),
            HorseRacing ("Horse racing", Sport),
            RugbyLeague ("Rugby League", Sport),
            USSport ("US Sport", Sport),
            Boxing (Sport),
            Cycling (Sport),
        Football,
            LiveScores ("Live scores", Football),
            Clubs (Football),
            Competitions (Football),
            Results (Football),
            Fixtures (Football),
            Tables (Football),
        LifeStyle("Life & style"),
            FoodDrink ("Food & drink", LifeStyle),
            Fashion (LifeStyle),
            Homes (LifeStyle),
            Women (LifeStyle),
            LoveFamily ("Love & family", LifeStyle),
            Wellbeing (LifeStyle),
        Culture,
            TVRadio ("TV & radio", Culture),
            Film (Culture),
            Music (Culture),
            Stage (Culture),
            Books (Culture),
            ArtDesign ("Art & design", Culture),
        Business,
            Economics (Business),
            EuroCrisis ("Eurozone crisis", Business),
            Euro (Business),
            Banking (Business),
            Retail (Business),
        Money,
            Consumer (Money),
            Property (Money),
            Work (Money),
            FamilyFin ("Family finances", Money),
            Saving (Money),
            Borrowing (Money),
        Travel,
            ShortBreaks ("Short breaks", Travel),
            TopsTens ("Top 10s", Travel),
            UK (Travel),
            EuropeTr (Travel),
            Hotels (Travel),
            FoodDr ("Food & drink", Travel),
        Tech,
            Games (Tech),
            MobTab ("Mobiles & tablets", Tech),
            Apps (Tech),
            Apple (Tech),
            Google (Tech),
        Environment,
            ClimChange ("Climate change", Environment),
            Wildlife (Environment),
            Energy (Environment),
            Conservation (Environment),
            Food (Environment);


    public final SectionNames parent;
    public final String uiName;

    SectionNames(String uiName){
        parent = null;
        this.uiName = uiName;
    }

    SectionNames(){
        parent = null;
        uiName = this.toString();
    }

    SectionNames(SectionNames parent){
        this.parent = parent;
        this.uiName = this.toString();
    }

    SectionNames(String uiName, SectionNames parent){
        this.parent = parent;
        this.uiName = uiName;
    }
}
