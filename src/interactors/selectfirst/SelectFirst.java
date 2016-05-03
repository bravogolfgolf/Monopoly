package game.interactors.selectfirst;

import game.Context;
import game.entities.Token;
import game.interactors.Interactor;

public class SelectFirst extends Interactor {

    private final SelectFirstPresenter presenter;
    private final SelectFirstPlayerGateway players;
    private final SelectFirstResponse response = new SelectFirstResponse();

    public SelectFirst(SelectFirstPresenter presenter, SelectFirstPlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
    }

    @Override
    public void handle() {
        players.randomizePlayers();
        Token token = Context.currentPlayer;
        response.token = token.getDescription();
        presenter.playerSelectedToGoFirstMessage(response);
    }
}
