package game.manager;

import java.io.IOException;

public class UIManagerImpl extends UIManager {

    public UIManagerImpl(ManagerView view, ManagerPresenter presenter, ControllerFactory factory) {
        super(view, presenter, factory);
    }

    @Override
    public void promptMessage(String state) {

        switch (state) {
            case "SetupGame":
                presenter.setupGamePromptMessage();
                break;
            case "CreatePlayer_0":
            case "CreatePlayer_1":
                presenter.createPlayerPromptMessageFewerThanTwo();
                break;
            default:
                presenter.createPlayerPromptMessageTwoOrMore();
                break;
        }
    }

    @Override
    public void createController(String controller) {
        super.controller = factory.make(controller);
    }

    @Override
    public void executeController() throws IOException {
        super.controller.execute();
    }

    @Override
    public void setViewManager() {
        super.view.setManager(this);
    }

    @Override
    public void readView() throws IOException {
        super.view.read();
    }
}
