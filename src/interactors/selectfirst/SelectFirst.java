package game.interactors.selectfirst;

import game.controllers.ControllerInteractor;
import game.controllers.ControllerRequest;
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
    public void handle() {
        players.randomizePlayers();
        Token token = players.getCurrentPlayer();
        response.token = token.getDescription();
        presenter.playerSelectedToGoFirstMessage(response);
    }

    @Override
    public void handle(ControllerRequest request) {

    }
}
