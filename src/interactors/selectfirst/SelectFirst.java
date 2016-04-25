package game.interactors.selectfirst;

import game.controllers.ControllerInteractor;
import game.controllers.InteractorRequest;
import game.entities.Token;

public class SelectFirst implements ControllerInteractor {

    private final SelectFirstPresenter presenter;
    private final SelectFirstPlayerGateway players;
    private final SelectFirstResponse response = new SelectFirstResponse();

    public SelectFirst(SelectFirstPresenter presenter, SelectFirstPlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
    }

    @Override
    public void handle(InteractorRequest request) {
        if (request.string.equals("")) selectPlayerToGoFirst();
        else throw new IllegalArgumentException();
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
