package main;

import interactors.Interactor;

public interface InteractorFactory {
    Interactor make(String interactor);
}
