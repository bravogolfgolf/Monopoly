package game.doubles;

import game.entities.Card;
import game.entities.CommunityChestDeck;
import game.manager.State;

public class CommunityChestDeckMock extends CommunityChestDeck {
    public boolean verifyDrawCardCalled = false;

    @Override
    public Card drawCard() {
        verifyDrawCardCalled = true;
        return new Card("") {
            @Override
            public State determineState() {
                return null;
            }
        };
    }
}
