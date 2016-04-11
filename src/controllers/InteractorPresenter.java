package game.controllers;

import game.interactors.createboard.CreateBoardInteractorPresenter;
import game.interactors.createplayer.CreatePlayerInteractorPresenter;

public abstract class InteractorPresenter implements CreatePlayerInteractorPresenter, CreateBoardInteractorPresenter {
    public abstract String getViewRequest();
}
