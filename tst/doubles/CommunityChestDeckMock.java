package game.doubles;

import game.entities.CommunityChestDeck;

public class CommunityChestDeckMock extends CommunityChestDeck {
    public boolean verifyDrawCardCalled = false;

    @Override
    public String drawCard() {
        verifyDrawCardCalled = true;
        return "";
    }
}
