package main;

import controllers.Controller;
import controllers.ControllerFactory;
import interactors.Interactor;
import interactors.InteractorFactory;
import presenters.Presenter;
import presenters.PresenterFactory;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private static List<Presenter> presenters = new ArrayList<>();
    private static List<Interactor> interactors = new ArrayList<>();
    private static List<Controller> controllers = new ArrayList<>();

    public static void main(String[] args) {
        PresenterFactory presenterFactory = new PresenterFactoryImpl();
        presenters.add(presenterFactory.make("CreateBoardPresenterSpy"));

        InteractorFactory interactorFactory = new InteractorFactoryImpl();
        interactors.add(interactorFactory.make("CreateBoard"));

        ControllerFactory controllerFactory = new ControllerFactoryImpl();
        controllers.add(controllerFactory.make("CreateBoardController"));
    }

}
