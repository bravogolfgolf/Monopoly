package game;

import game.controllers.ControllerImpl;
import game.display.ConsoleImpl;
import game.factories.ControllerFactoryImpl;
import game.manager.UIManager;
import game.manager.UIManagerImpl;
import game.manager.UIStateImpl;
import game.presenters.PresenterEn;
import game.view.ViewImpl;

import java.io.*;

public final class Monopoly {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final ConsoleImpl console = new ConsoleImpl(reader, writer);
    private static final PresenterEn presenter = new PresenterEn();
    private static final UIManager manager = new UIManagerImpl();
    private static final ViewImpl view = new ViewImpl(console, manager);
    public static final ControllerFactoryImpl factory = new ControllerFactoryImpl(view, presenter);
    public static ControllerImpl controller;

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
    }

    private void setup() throws IOException {
        controller = factory.make("SetupGame");
        manager.setUiState(UIStateImpl.SETUP_GAME);
        manager.setPresenter(presenter);
        manager.setController(controller);
        manager.setView(view);

        manager.initialize();
        controller.execute();
        view.read();
    }
}