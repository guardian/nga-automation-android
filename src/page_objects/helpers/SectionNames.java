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

        News,
            UK (News),
            Europe (News),
            US (News),
            Americas (News),
            Asia (News),
            Australia (News),
            Africa (News),
            MiddleEast ("Middle East", News),
        Comment,
        Sport,
            SportFootball ("Football", Sport),
            Rugby (Sport),
            Cricket(Sport),
            Tennis (Sport),
            Boxing (Sport),
            Cycling (Sport),
            USSport ("US Sport", Sport),
        Football,
        Tech,
            Games (Tech),
        Culture,
            Film (Culture),
            TVRadio ("TV & radio", Culture),
            Music (Culture),
            Books (Culture),
            ArtDesign ("Art & design", Culture),
            Theatre (Culture),
        Life,
            Food (Life),
            Health (Life),
            Sex (Life),
            Family (Life),
            Women (Life),
        Fashion,
            MenFashion ("Men's Fashion", Fashion),
        Economy,
            Markets (Economy),
            Media (Economy),
        Money,
            Property (Economy),
            Savings (Economy),
            Borrowing (Economy),
            Careers (Economy),
        Travel,
            UKTravel ("UK", Travel),
            EuropeTravel ("Europe", Travel),
            USATravel ("US", Travel),
        ScienceEnvironment ("Science & Environment"),
            Science (ScienceEnvironment),
            Development (ScienceEnvironment),
        Education,
            Students (Education);


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
