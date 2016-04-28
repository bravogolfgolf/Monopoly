package game.interactors.selectfirst;

import game.controllers.writer.ReaderRequest;
import game.controllers.writer.WriterInteractor;
import game.entities.Token;

public class SelectFirst implements WriterInteractor {

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
    public void handle(ReaderRequest request) {

    }
}
