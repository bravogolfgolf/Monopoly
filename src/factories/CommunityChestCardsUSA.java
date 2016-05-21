package game.factories;

import game.entities.Card;

import java.util.ArrayList;
import java.util.List;

public class CommunityChestCardsUSA {
    public static List<Card> create() {
        return new ArrayList<Card>() {{
            add(new Card.AdvanceToSpecific("Advance to Go (Collect 200)"));
            add(new Card.RecieveMoney("Bank error in your favor – Collect 200"));
            add(new Card.PayMoney("Doctor's fees – Pay 50"));
            add(new Card.RecieveMoney("From sale of stock you get 50"));
            add(new Card.GetOutOfJail("Get out of Jail Free – This card may be kept until needed or sold"));
            add(new Card.GoToJail("Go to Jail – Go directly to Jail – Do not pass Go – Do not collect 200"));
            add(new Card.RecieveMoney("Holiday Fund matures - Receive 100"));
            add(new Card.RecieveMoney("Income tax refund – Collect 20"));
            add(new Card.RecieveMoney("It is your birthday - Collect $10 from each player"));
            add(new Card.RecieveMoney("Life insurance matures – Collect 100"));
            add(new Card.PayMoney("Pay hospital fees of 100"));
            add(new Card.PayMoney("Pay school fees of 150"));
            add(new Card.RecieveMoney("Receive $25 consultancy fee"));
            add(new Card.PayMoney("You are assessed for street repairs – 40 per house – 115 per hotel"));
            add(new Card.RecieveMoney("You have won second prize in a beauty contest – Collect 10"));
            add(new Card.RecieveMoney("You inherit 100"));
        }};
    }
}