package game.entities;

import game.interactors.communitychest.DrawCommunityChestCardCommunityChestDeckGateway;

public class CommunityChestDeck implements DrawCommunityChestCardCommunityChestDeckGateway {

    public String drawCard() {
        return "Bank error in your favor – Collect 200.";
    }
}
