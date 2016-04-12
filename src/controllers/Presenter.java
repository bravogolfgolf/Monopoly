package game.controllers;

import game.interactors.createboard.CreateBoardPresenter;
import game.interactors.createplayer.CreatePlayerPresenter;

public abstract class Presenter implements CreatePlayerPresenter, CreateBoardPresenter {
    public abstract String getMessage();
}
