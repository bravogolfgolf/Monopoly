package main;

import controllers.View;
import entitiies.Board;
import factories.ControllerFactoryImpl;
import factories.InteractorFactoryImpl;
import factories.PresenterFactoryImpl;
import interactors.BoardGateway;
import repositories.PlayerRepository;
import view.Console;

public final class Monopoly {

    public static View console = new Console();
    public static BoardGateway boardGateway = new Board();
    public static PlayerGateway playerGateway = new PlayerRepository();
    public static ControllerFactory controllerFactory = new ControllerFactoryImpl();
    public static InteractorFactory interactorFactory = new InteractorFactoryImpl();
    public static PresenterFactory presenterFactory = new PresenterFactoryImpl();

}