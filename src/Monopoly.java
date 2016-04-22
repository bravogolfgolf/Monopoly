package game;

import game.display.ConsoleImpl;
import game.factories.ControllerFactoryImpl;
import game.manager.UIManager;
import game.manager.UIManagerImpl;
import game.manager.UIStateImpl;
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
        ControllerFactoryImpl factory = new ControllerFactoryImpl(view, presenter);
        UIManager manager = new UIManagerImpl(view,presenter,factory);
        manager.setUiState(UIStateImpl.SETUP_GAME);
        manager.initialize();

//        UIManager.controller = UIManager.factory.make("SetupGame");
//        UIManager.manager.setUiState(UIStateImpl.SETUP_GAME);
//        UIManager.manager.setPresenter(UIManager.presenter);
//        UIManager.manager.setController(UIManager.controller);
//        UIManager.manager.setView(UIManager.view);
//
//        UIManager.manager.initialize();
//        UIManager.controller.execute();
//        UIManager.view.read();
    }
}