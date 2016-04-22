package game;

import game.display.ConsoleImpl;
import game.factories.ControllerFactoryImpl;
import game.manager.ControllerFactory;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.manager.StateManagerImpl;
import game.presenters.PresenterEn;
import game.view.ViewImpl;

import java.io.*;

final class Monopoly {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final ConsoleImpl console = new ConsoleImpl(reader, writer);

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
    }

    private void setup() throws IOException {
        ViewImpl view = new ViewImpl(console);
        PresenterEn presenter = new PresenterEn();
        ControllerFactory factory = new ControllerFactoryImpl(view, presenter);
        StateManager manager = new StateManagerImpl(view,presenter,factory);
        manager.setState(StateImpl.SETUP_GAME);
        manager.initialize();

    }
}