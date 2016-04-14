package game.controllers;

import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGameResponse;

public class PresenterEnDummy extends Presenter {
    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {

    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {

    }

    @Override
    public void exceededPlayerLimitMessage() {

    }

    @Override
    public void playerPromptMessage() {

    }

    @Override
    public void boardPromptMessage() {

    }

    @Override
    public void boardCreatedMessage(SetupGameResponse response) {

    }

    @Override
    public void availableBoardsMessage(SetupGameResponse response) {

    }
}
