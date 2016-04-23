package game.factories;

import game.entities.Board;
import game.entities.Players;
import game.interactors.selectversion.SelectVersionFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static game.factories.ControllerFactoryImpl.board;
import static game.factories.ControllerFactoryImpl.playerGateway;
import static game.factories.TokenFactory.tokenSet;

class SelectVersionFactoryImpl implements SelectVersionFactory {

    @Override
    public String[] getAvailableVersions() {
        String[] result = new String[]{"USA", "TEST"};
        Arrays.sort(result);
        return result;
    }

    @Override
    public void make(String version) {
        switch (version) {
            case "USA":
                setup(version);
                break;
            case "TEST":
                setup(version);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setup(String version) {
        board = new Board(boardList(version));
        playerGateway = new Players(tokenSet(version));
    }

    private List<Board.Space> boardList(String version) {
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
