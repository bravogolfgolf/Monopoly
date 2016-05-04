package game.fitnesse;

import game.controllers.Controller;
import game.controllers.Options;
import game.display.Console;
import game.factories.ControllerFactory;
import game.factories.VersionFactory;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;
import game.repositories.Players;

import java.io.IOException;

public class SelectOptions {

    private final Parser parser = new ParserFitnesse();
    private final Console console = new ConsoleFitnesee(parser);
    private final Players players = new Players();
    private final VersionFactory factory = new VersionFactory();
    private final Presenter presenter = new PresenterEn(console, parser);
    private final ControllerFactory controllerFactory = new ControllerFactory(presenter, factory, players, console);
    private final Controller controller;

    public SelectOptions(String interactor) throws IOException {
        controller = controllerFactory.make(interactor);
        ((ParserFitnesse) parser).controller = ((Options) controller);
        controller.execute();
    }

    private void sendInput(String input) throws IOException {
        parser.parse(input);
    }

    public void userEntersText() throws IOException {
        sendInput("a");
    }

    public void userEntersZero() throws IOException {
        sendInput("0");
    }

    public void userEntersOne() throws IOException {
        sendInput("1");
    }

    public void userEntersTwo() throws IOException {
        sendInput("2");
    }

    public void userPromptShouldChange() throws IOException {
        controller.execute();
    }

    public String expectedOutput() throws IOException {
        return ((ConsoleFitnesee) console).expectedOutput;
    }
}