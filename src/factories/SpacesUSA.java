package game.factories;

import game.entities.Board;

import java.util.ArrayList;
import java.util.List;

class SpacesUSA {
    static List<Board.Space> create() {
        return new ArrayList<Board.Space>() {{
            add(new Board.Space.Go("Go"));
            add(new Board.Space.RealEstate("Mediterranean Avenue"));
            add(new Board.Space.CommunityChest("Community Chest"));
            add(new Board.Space.RealEstate("Baltic Avenue"));
            add(new Board.Space.IncomeTax("Income Tax"));
            add(new Board.Space.Railroad("Reading Railroad"));
            add(new Board.Space.RealEstate("Oriental Avenue"));
            add(new Board.Space.Chance("Chance"));
            add(new Board.Space.RealEstate("Vermont Avenue"));
            add(new Board.Space.CommunityChest("Connecticut Avenue"));
            add(new Board.Space.JustVisiting("Just Visiting/Jail"));
            add(new Board.Space.RealEstate("St. Charles Place"));
            add(new Board.Space.Utility("Electric Company"));
            add(new Board.Space.RealEstate("States Avenue"));
            add(new Board.Space.RealEstate("Virginia Avenue"));
            add(new Board.Space.Railroad("Pennsylvania Railroad"));
            add(new Board.Space.RealEstate("St. James Place"));
            add(new Board.Space.CommunityChest("Community Chest"));
            add(new Board.Space.RealEstate("Tennessee Avenue"));
            add(new Board.Space.RealEstate("New York Avenue"));
            add(new Board.Space.FreeParking("Free Parking"));
            add(new Board.Space.RealEstate("Kentucky Avenue"));
            add(new Board.Space.Chance("Chance"));
            add(new Board.Space.RealEstate("Indiana Avenue"));
            add(new Board.Space.RealEstate("Illinois Avenue"));
            add(new Board.Space.Railroad("B & O Railroad"));
            add(new Board.Space.RealEstate("Atlantic Avenue"));
            add(new Board.Space.RealEstate("Ventnor Avenue"));
            add(new Board.Space.Utility("Water Works"));
            add(new Board.Space.RealEstate("Marvin Gardens"));
            add(new Board.Space.GoToJail("Go to Jail"));
            add(new Board.Space.RealEstate("Pacific Avenue"));
            add(new Board.Space.RealEstate("North Carolina Avenue"));
            add(new Board.Space.CommunityChest("Community Chest"));
            add(new Board.Space.RealEstate("Pennsylvania Avenue"));
            add(new Board.Space.Railroad("Short Line"));
            add(new Board.Space.Chance("Chance"));
            add(new Board.Space.RealEstate("Park Place"));
            add(new Board.Space.LuxuryTax("Luxury Tax"));
            add(new Board.Space.RealEstate("Boardwalk"));
        }};
    }
}
