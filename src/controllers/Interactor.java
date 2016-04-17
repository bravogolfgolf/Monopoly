package game.controllers;

import game.interactors.InteractorRequest;

public interface Interactor {

    void handle(InteractorRequest request);

    void userInterfacePrompt();

    void userInterfaceOptions();
}
