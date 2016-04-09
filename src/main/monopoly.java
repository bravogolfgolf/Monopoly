package main;

import factories.ControllerFactoryImpl;
import factories.InteractorFactoryImpl;
import factories.PresenterFactoryImpl;

public class Monopoly {

    public static PresenterFactory presenterFactory = new PresenterFactoryImpl();
    public static InteractorFactory interactorFactory = new InteractorFactoryImpl();
    public static ControllerFactory controllerFactory = new ControllerFactoryImpl();

    public static void main(String[] args) {
    }

}
