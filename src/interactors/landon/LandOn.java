package game.interactors.landon;

import game.interactors.Interactor;
import game.manager.StateManager;
import game.presenters.Presenter;

import static game.Context.currentPlayer;

public class LandOn extends Interactor {

    private final LandOnStateManager manager;
    private final LandOnPresenter presenter;
    private final LandOnResponse response = new LandOnResponse();

    public LandOn(StateManager manager, Presenter presenter) {
        this.manager = manager;
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        manager.setState(currentPlayer.getSpace().determineState());
        response.space = currentPlayer.getSpace().getDescription();
        presenter.landOnMessage(response);
    }
}
