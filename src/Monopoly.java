package game;

import game.display.ConsoleImpl;
import game.factories.CommandFactoryImpl;
import game.manager.UIManager;
import game.manager.UIManagerImpl;
import game.manager.UIStateImpl;
import game.presenters.PresenterEn;
import game.view.Controller;
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
    private static final CommandFactoryImpl factory = new CommandFactoryImpl(view, presenter);
    public static final List<Command> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
        monopoly.loop();
    }

    private void setup() {
        manager.setUiState(UIStateImpl.SETUP_GAME);
        addCommandToStack("SetupGame");
        view.setController((Controller) list.get(0));
    }

    private void loop() throws IOException {
        while (list.size() > 0) {
            Command command = list.remove(0);
            view.setController((Controller) command);
            view.userInterfacePrompt();
            command.execute();
        }
    }

    public static void addCommandToStack(String commandString) {
        list.add(factory.make(commandString));
    }
}