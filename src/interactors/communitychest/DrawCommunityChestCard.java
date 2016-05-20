package game.interactors.communitychest;

import game.entities.CommunityChestDeck;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class DrawCommunityChestCard extends Interactor {

    private final DrawCommunityChestCardCommunityChestDeckGateway deck;
    private final DrawCommunityChestCardPresenter presenter;
    private final DrawCommunityChestCardResponse response = new DrawCommunityChestCardResponse();

    public DrawCommunityChestCard(CommunityChestDeck deck, Presenter presenter) {
        this.deck = deck;
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        response.cardText = deck.drawCard();
        presenter.cardMessage(response);
    }
}
