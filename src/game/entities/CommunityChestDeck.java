package game.entities;

import game.interactors.communitychest.DrawCommunityChestCardCommunityChestDeckGateway;
import game.manager.State;

public class CommunityChestDeck implements DrawCommunityChestCardCommunityChestDeckGateway {

    public Card drawCard() {
        return new Card("Bank error in your favor – Collect 200.") {
            @Override
            public State determineState() {
                return null;
            }
        };
    }
}
