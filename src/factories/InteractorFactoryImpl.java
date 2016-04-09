package factories;

import interactors.Interactor;
import interactors.createboard.CreateBoardInteractor;
import interactors.createplayer.CreatePlayerInteractor;
import main.InteractorFactory;
import main.Monopoly;
import presenters.createboard.CreateBoardPresenter;
import presenters.createplayer.CreatePlayerPresenter;

public class InteractorFactoryImpl implements InteractorFactory {

    @Override
    public Interactor make(String interactor) {
        if (interactor.equals("CreateBoardInteractor")) {
            CreateBoardPresenter presenter = new CreateBoardPresenter();
            return new CreateBoardInteractor(presenter, Monopoly.boardGateway);
        }

        if (interactor.equals("CreatePlayerInteractor")) {
            CreatePlayerPresenter presenter = new CreatePlayerPresenter();
            return new CreatePlayerInteractor(presenter, Monopoly.playerGateway);
        }

        throw new IllegalArgumentException();
    }
}
