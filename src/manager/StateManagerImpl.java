package game.manager;

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
        super.basicController = factory.make(controller);
    }

    @Override
    public void callHandleOnController(String option) throws IOException {
        super.menuController.handle();
    }

    @Override
    public void readView() throws IOException {
        super.console.read();
    }
}
