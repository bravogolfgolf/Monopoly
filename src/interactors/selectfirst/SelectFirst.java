package game.interactors.selectfirst;

import game.interactors.Interactor;

import static game.Context.currentPlayer;

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
        response.token = currentPlayer.getDescription();
        presenter.playerSelectedToGoFirstMessage(response);
    }
}
