package main;

import interactors.Interactor;
import interactors.InteractorFactory;
import interactors.createboard.CreateBoard;
import interactors.createplayer.CreatePlayer;

public class InteractorFactoryImpl implements InteractorFactory {
    @Override
    public Interactor make(String interactor) {
        if (interactor.equals("CreateBoard"))
            return new CreateBoard();
        if (interactor.equals("CreatePlayer"))
            return new CreatePlayer();
        throw new IllegalArgumentException();
    }
}
