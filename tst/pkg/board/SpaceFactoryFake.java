package pkg.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpaceFactoryFake implements SpaceFactory {

    @Override
    public List<Space> load(String localization) throws IOException {
        List<Space> spaces = new ArrayList<>();
        spaces.add(new Go("Go"));
        spaces.add(new RealEstate("Mediterranean Avenue", "Brown", 60, 2, 10, 30, 90, 160, 250));
        spaces.add(new CommunityChest("Community Chest"));
        spaces.add(new RealEstate("Baltic Avenue", "Brown", 60, 4, 20, 60, 180, 320, 450));
        spaces.add(new IncomeTax("Income Tax"));
        spaces.add(new Railroad("Reading Railroad", "Railroad", 200, 25));
        spaces.add(new RealEstate("Oriental Avenue", "Light Blue", 100, 6, 30, 90, 270, 400, 550));
        spaces.add(new Chance("Chance"));
        spaces.add(new RealEstate("Vermont Avenue", "Light Blue", 100, 6, 30, 90, 270, 400, 550));
        spaces.add(new RealEstate("Connecticut Avenue", "Light Blue", 120, 8, 40, 100, 300, 450, 600));
        spaces.add(new Jail("Just Visiting/Jail"));
        spaces.add(new RealEstate("St. Charles Place", "Purple", 140, 10, 50, 150, 450, 625, 750));
        spaces.add(new Utility("Electric Company", "Utility", 150));
        spaces.add(new RealEstate("States Avenue", "Purple", 140, 10, 50, 150, 450, 625, 750));
        spaces.add(new RealEstate("Virginia Avenue", "Purple", 160, 12, 60, 180, 500, 700, 900));
        spaces.add(new Railroad("Pennsylvania Railroad", "Railroad", 200, 25));
        spaces.add(new RealEstate("St. James Place", "Orange", 180, 14, 70, 200, 550, 750, 950));
        spaces.add(new CommunityChest("Community Chest"));
        spaces.add(new RealEstate("Tennessee Avenue", "Orange", 180, 14, 70, 200, 550, 750, 950));
        spaces.add(new RealEstate("New York Avenue", "Orange", 200, 16, 80, 220, 600, 800, 1000));
        spaces.add(new FreeParking("Free Parking"));
        spaces.add(new RealEstate("Kentucky Avenue", "Red", 220, 18, 90, 250, 700, 875, 1050));
        spaces.add(new Chance("Chance"));
        spaces.add(new RealEstate("Indiana Avenue", "Red", 220, 18, 90, 250, 700, 875, 1050));
        spaces.add(new RealEstate("Illinois Avenue", "Red", 240, 20, 100, 300, 750, 925, 1100));
        spaces.add(new Railroad("B & O Railroad", "Railroad", 200, 25));
        spaces.add(new RealEstate("Atlantic Avenue", "Yellow", 260, 22, 110, 330, 800, 975, 1150));
        spaces.add(new RealEstate("Ventnor Avenue", "Yellow", 260, 22, 110, 330, 800, 975, 1150));
        spaces.add(new Utility("Water Works", "Utility", 150));
        spaces.add(new RealEstate("Marvin Gardens", "Yellow", 280, 24, 120, 360, 850, 1025, 1200));
        spaces.add(new GoToJail("Go to Jail"));
        spaces.add(new RealEstate("Pacific Avenue","Green",300,26,130,390,900,1100,1275));
        spaces.add(new RealEstate("North Carolina Avenue","Green",300,26,130,390,900,1100,1275));
        spaces.add(new CommunityChest("Community Chest"));
        spaces.add(new RealEstate("North Carolina Avenue","Green",300,26,130,390,900,1100,1275));
        spaces.add(new Railroad("Short Line", "Railroad", 200, 25));
        spaces.add(new Chance("Chance"));
        spaces.add(new RealEstate("Park Place","Blue",350,35,175,500,1100,1300,1500));
        spaces.add(new LuxuryTax("Luxury Tax"));
        spaces.add(new RealEstate("Boardwalk","Blue",400,40,200,600,1400,1700,2000));
        return spaces;
    }
}
