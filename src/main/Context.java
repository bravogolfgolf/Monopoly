package main;

import controllers.View;
import interactors.BoardGateway;

public class Context {
    public static View console;
    public static BoardGateway boardGateway;
    public static PlayerGateway playerGateway;
    public static ControllerFactory controllerFactory;
}
