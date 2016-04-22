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
import java.util.ArrayList;
import java.util.List;

public final class Monopoly {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final ConsoleImpl console = new ConsoleImpl(reader, writer);
    private static final PresenterEn presenter = new PresenterEn();
    private static final UIManager manager = new UIManagerImpl(presenter);
    private static final ViewImpl view = new ViewImpl(console, manager);
    private static final ControllerFactoryImpl factory = new ControllerFactoryImpl(view, presenter);
    public static final List<ControllerImpl> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
        monopoly.loop();
    }

    private void setup() {
        manager.setUiState(UIStateImpl.SETUP_GAME);
        addControllerToStack("SetupGame");
    }

    private void loop() throws IOException {
        while (list.size() > 0) {
            ControllerImpl controller = list.remove(0);
            view.setController(controller);
            manager.initialize();
            controller.execute();
            view.read();
        }
    }

    public static void addControllerToStack(String commandString) {
        list.add(factory.make(commandString));
    }
}