package factories;

import interactors.Interactor;
import interactors.createboard.CreateBoardInteractor;
import interactors.createplayer.CreatePlayerInteractor;
import main.InteractorFactory;

public class InteractorFactoryImpl implements InteractorFactory {
    @Override
    public Interactor make(String interactor) {
        if (interactor.equals("CreateBoardInteractor"))
            return new CreateBoardInteractor();
        if (interactor.equals("CreatePlayerInteractor"))
            return new CreatePlayerInteractor();
        throw new IllegalArgumentException();
    }
}
