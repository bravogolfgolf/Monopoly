package game.doubles;

import game.entities.Card;
import game.entities.CommunityChestDeck;

public class CommunityChestDeckMock extends CommunityChestDeck {
    public boolean verifyDrawCardCalled = false;

    @Override
    public Card drawCard() {
        verifyDrawCardCalled = true;
        return new Card("");
    }
}
