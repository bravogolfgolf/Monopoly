package game.interactors.selectfirst;

import game.controllers.setmap.MenuInteractor;
import game.entities.Token;

public class SelectFirst implements MenuInteractor {

    private final SelectFirstPresenter presenter;
    private final SelectFirstPlayerGateway players;
    private final SelectFirstResponse response = new SelectFirstResponse();

    public SelectFirst(SelectFirstPresenter presenter, SelectFirstPlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
    }

    @Override
    public void handle() {
        selectPlayerToGoFirst();
    }

    private void selectPlayerToGoFirst() {
        players.randomizePlayers();
        Token token = players.getNextPlayer();
        prepareResponse(token);
    }

    private void prepareResponse(Token token) {
        response.token = token.getDescription();
        presenter.playerSelectedToGoFirstMessage(response);
    }
}
