package game.manager;

import game.controllers.Controller;
import game.controllers.Options;
import game.factories.InteractorFactory;
import game.interactors.Interactor;
import game.interactors.movetoken.MoveTokenStateManager;
import game.interactors.rolldice.RollDiceManagerGateway;
import game.parser.ParserManager;

import java.io.IOException;

public class StateManager implements ParserManager, RollDiceManagerGateway, MoveTokenStateManager {

    private State state;
    private ManagerControllerFactory controllerFactory;
    private InteractorFactory interactorFactory;
    private Controller controller;

    public void setControllerFactory(ManagerControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    public void setInteractorFactory(InteractorFactory interactorFactory) {
        this.interactorFactory = interactorFactory;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    public void initialize() throws IOException {
        state.initialize(this);
    }

    @Override
    public void invalidEntry() throws IOException {
        initialize();
    }

    @Override
    public void validTextEntry(String result) throws IOException {
        ((Options) controller).handle(result);
        state.validTextEntry(this);
    }

    @Override
    public void zeroEntered() throws IOException {
        state.zeroEntered(this);
    }

    @Override
    public void oneEntered() throws IOException {
        state.oneEntered(this);
    }

    @Override
    public void twoEntered() throws IOException {
        state.twoEntered(this);

    }

    public void createAndExecuteController(String contollerString) throws IOException {
        controller = controllerFactory.make(contollerString);
        controller.execute();
    }

    public void createAndExecuteInteractor(String interactorString){
        Interactor interactor = interactorFactory.make(interactorString);
        interactor.handle();
    }
}
