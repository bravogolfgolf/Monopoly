package game;

import game.factories.ControllerFactoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static game.manager.StateImpl.SETUP_GAME;

public final class Monopoly {

    private static final List<Command> list = new ArrayList<>();
    private Command controller;

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup();
        monopoly.loop();
    }

    private void setup() {
        ControllerFactoryImpl factory = new ControllerFactoryImpl();

        controller = factory.make("SetupGame", SETUP_GAME);
        addControllerToStack(controller);
    }

    private void loop() throws IOException {
        while (list.size() > 0) {
            controller = list.remove(0);
            controller.execute();
        }
    }

    public static void addControllerToStack(Command controller) {
        list.add(controller);
    }
}