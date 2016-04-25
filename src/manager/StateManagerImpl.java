package game.manager;

import game.controllers.menu.Menu;

import java.io.IOException;

public class StateManagerImpl extends StateManager {

    public StateManagerImpl(ManagerPresenter presenter, ControllerFactory factory, ManagerConsole console) {
        super(presenter, factory, console);
    }

    @Override
    public void promptMessage(String state) {

        switch (state) {
            case "SelectVersion":
                super.presenter.selectVersionPromptMessage();
                break;
            case "CreatePlayer_0":
            case "CreatePlayer_1":
                super.presenter.createPlayerPromptMessageFewerThanTwo();
                break;
            default:
                super.presenter.createPlayerPromptMessageTwoOrMore();
                break;
        }
    }

    @Override
    public void createController(String controller) {
        super.controller = factory.make(controller);
    }

    @Override
    public void callHandleOnController() throws IOException {
        ((Menu) controller).handle();
    }

    @Override
    public void readView() throws IOException {
        super.console.read();
    }
}
