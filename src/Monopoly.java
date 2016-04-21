package game;

import game.factories.CommandFactoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static game.manager.UIStateImpl.SETUP_GAME;

public final class Monopoly {

    private static final List<Command> list = new ArrayList<>();
    private Command command;

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
        monopoly.loop();
    }

    private void setup() {
        CommandFactoryImpl factory = new CommandFactoryImpl();

        command = factory.make("SetupGame", SETUP_GAME);
        addCommandToStack(command);
    }

    private void loop() throws IOException {
        while (list.size() > 0) {
            command = list.remove(0);
            command.execute();
        }
    }

    public static void addCommandToStack(Command command) {
        list.add(command);
    }
}