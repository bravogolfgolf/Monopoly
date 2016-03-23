package pkg.board;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class SpaceFactory {
    public static Space create(String classType, String description, String group, int price, int rent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, int hotelRent) {
        if (classType.equals("RealEstate"))
            return new RealEstate(description, group, price, rent, house1Rent, house2Rent, house3Rent, house4Rent, hotelRent);
        throw new IllegalArgumentException("Incorrect value");
    }

    public static Space create(String classType, String description, String group, int price, int rent) {
        if (classType.equals("Railroad")) return new Railroad(description, group, price, rent);
        throw new IllegalArgumentException("Incorrect value");
    }

    public static Space create(String classType, String description, String group, int price) {
        if (classType.equals("Utility")) return new Utility(description, group, price);
        throw new IllegalArgumentException("Incorrect value");
    }

    public static Space create(String classType, String description) {
        if (classType.equals("Go")) return new Go(description);
        if (classType.equals("FreeParking")) return new FreeParking(description);
        if (classType.equals("Jail")) return new Jail(description);
        if (classType.equals("GoToJail")) return new GoToJail(description);
        if (classType.equals("IncomeTax")) return new IncomeTax(description);
        if (classType.equals("LuxuryTax")) return new LuxuryTax(description);
        if (classType.equals("CommunityChest")) return new CommunityChest(description);
        if (classType.equals("Chance")) return new Chance(description);
        throw new IllegalArgumentException("Incorrect value");
    }

    static List<Space> load(String localization) throws IOException {
        String fileName = String.format("Spaces_%s.txt", localization);
        List<String> content = Files.readAllLines(Paths.get(fileName));
        List<Space> spaces = new ArrayList<>();
        for (String line : content) {
            String[] tokens = line.split(";");
            switch (tokens[0]) {
                case "RealEstate":
                    spaces.add(create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9])));
                    break;
                case "Railroad":
                    spaces.add(create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                    break;
                case "Utility":
                    spaces.add(create(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3])));
                    break;
                default:
                    spaces.add(create(tokens[0], tokens[1]));
                    break;
            }
        }
        return spaces;
    }
}
