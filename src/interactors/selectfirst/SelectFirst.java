package game.interactors.selectfirst;

import game.controllers.ControllerInteractor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class SelectFirst implements ControllerInteractor {

    private final SelectFirstPresenter presenter;
    private final SelectFirstPlayerGateway players;
    private final InteractorResponse response = new InteractorResponse();

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
        response.token = players.getNextPlayer();
        presenter.playerSelectedToGoFirstMessage(response);
    }
}