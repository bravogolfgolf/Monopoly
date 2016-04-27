package game.interactors.startturn;

import game.controllers.menu.MenuInteractor;

public class StartTurn implements MenuInteractor {

    private final StartTurnPresenter presenter;

    public StartTurn(StartTurnPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        presenter.startTurn();
    }
}
