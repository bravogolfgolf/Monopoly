package game.interactors.startturn;

import game.controllers.WriterInteractor;

public class StartTurn implements WriterInteractor {

    private final StartTurnPresenter presenter;

    public StartTurn(StartTurnPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        presenter.startTurn();
    }
}
