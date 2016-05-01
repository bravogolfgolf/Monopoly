package game.factories;

import game.entities.Board;

import java.util.ArrayList;
import java.util.List;

public class SpacesUSA {
    public static List<Board.Space> create() {
        return new ArrayList<Board.Space>() {{
            add(new Board.Space.Go(0, "GO"));
            add(new Board.Space.RealEstate(1, "Mediterranean Avenue"));
            add(new Board.Space.CommunityChest(2, "Community Chest"));
            add(new Board.Space.RealEstate(3, "Baltic Avenue"));
            add(new Board.Space.IncomeTax(4, "Income Tax"));
            add(new Board.Space.Railroad(5, "Reading Railroad"));
            add(new Board.Space.RealEstate(6, "Oriental Avenue"));
            add(new Board.Space.Chance(7, "Chance"));
            add(new Board.Space.RealEstate(8, "Vermont Avenue"));
            add(new Board.Space.CommunityChest(9, "Connecticut Avenue"));
            add(new Board.Space.JustVisiting(10, "Just Visiting/Jail"));
            add(new Board.Space.RealEstate(11, "St. Charles Place"));
            add(new Board.Space.Utility(12, "Electric Company"));
            add(new Board.Space.RealEstate(13, "States Avenue"));
            add(new Board.Space.RealEstate(14, "Virginia Avenue"));
            add(new Board.Space.Railroad(15, "Pennsylvania Railroad"));
            add(new Board.Space.RealEstate(16, "St. James Place"));
            add(new Board.Space.CommunityChest(17, "Community Chest"));
            add(new Board.Space.RealEstate(18, "Tennessee Avenue"));
            add(new Board.Space.RealEstate(19, "New York Avenue"));
            add(new Board.Space.FreeParking(20, "Free Parking"));
            add(new Board.Space.RealEstate(21, "Kentucky Avenue"));
            add(new Board.Space.Chance(22, "Chance"));
            add(new Board.Space.RealEstate(23, "Indiana Avenue"));
            add(new Board.Space.RealEstate(24, "Illinois Avenue"));
            add(new Board.Space.Railroad(25, "B & O Railroad"));
            add(new Board.Space.RealEstate(26, "Atlantic Avenue"));
            add(new Board.Space.RealEstate(27, "Ventnor Avenue"));
            add(new Board.Space.Utility(28, "Water Works"));
            add(new Board.Space.RealEstate(29, "Marvin Gardens"));
            add(new Board.Space.GoToJail(30, "Go to Jail"));
            add(new Board.Space.RealEstate(31, "Pacific Avenue"));
            add(new Board.Space.RealEstate(32, "North Carolina Avenue"));
            add(new Board.Space.CommunityChest(33, "Community Chest"));
            add(new Board.Space.RealEstate(34, "Pennsylvania Avenue"));
            add(new Board.Space.Railroad(35, "Short Line"));
            add(new Board.Space.Chance(36, "Chance"));
            add(new Board.Space.RealEstate(37, "Park Place"));
            add(new Board.Space.LuxuryTax(38, "Luxury Tax"));
            add(new Board.Space.RealEstate(39, "Boardwalk"));
        }};
    }
}
