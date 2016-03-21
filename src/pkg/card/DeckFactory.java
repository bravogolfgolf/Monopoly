package pkg.card;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    public enum DeckType{
        CHEST, CHANCE
    }

    public static Card create(String cardText, String classType, String space) {
        if (classType.equals("MoveForwardNext")) return new MoveForwardNext(cardText, space);
        if (classType.equals("MoveForwardSpecific")) return new MoveForwardSpecific(cardText, space);
        if (classType.equals("MoveJail")) return new MoveJail(cardText, space);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardText, String classType, int amount, String recipient) {
        if (classType.equals("Transaction")) return new Transaction(cardText, amount, recipient);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardText, String classType, int house, int hotel) {
        if (classType.equals("Repairs")) return new Repair(cardText, house, hotel);
        throw new IllegalArgumentException();
    }

    public static Card create(String cardText, String classType) {
        if (classType.equals("MoveBack")) return new MoveBack(cardText);
        if (classType.equals("GetOutOfJail")) return new GetOutOfJail(cardText);
        throw new IllegalArgumentException();
    }

    public static List<Card> load(DeckType deckType, String localization) throws IOException {
        String format = String.format("%s_%s.txt", deckType, localization);
        List<String> content = Files.readAllLines(Paths.get(format));
        List<Card> cards = new ArrayList<>();
        for (String line : content) {
            String[] tokens = line.split(";");
            switch (tokens[1]) {
                case "GetOutOfJail":
                    cards.add(create(tokens[0], tokens[1]));
                    break;
                case "MoveForwardSpecific":
                    cards.add(create(tokens[0], tokens[1], tokens[2]));
                    break;
                case "MoveForwardNext":
                    cards.add(create(tokens[0], tokens[1], tokens[2]));
                    break;
                case "MoveBack":
                    cards.add(create(tokens[0], tokens[1]));
                    break;
                case "MoveJail":
                    cards.add(create(tokens[0], tokens[1], tokens[2]));
                    break;
                case "Repairs":
                    cards.add(create(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                    break;
                case "Transaction":
                    cards.add(create(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3]));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return cards;
    }
}
