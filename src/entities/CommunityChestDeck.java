package game.entities;

import game.interactors.communitychest.DrawCommunityChestCardCommunityChestDeckGateway;

public class CommunityChestDeck implements DrawCommunityChestCardCommunityChestDeckGateway {

    public Card drawCard() {
        return new Card("Bank error in your favor – Collect 200.");
    }
}
