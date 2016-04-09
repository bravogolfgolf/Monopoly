package main;

import usecases.Interactor;
import usecases.InteractorFactory;
import usecases.createboard.CreateBoard;
import usecases.createplayer.CreatePlayer;

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
