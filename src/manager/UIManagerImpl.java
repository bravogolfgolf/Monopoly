package game.manager;

import game.factories.ControllerFactoryImpl;
import game.presenters.PresenterEn;
import game.view.ViewImpl;

import java.io.IOException;

public class UIManagerImpl extends UIManager {

    public UIManagerImpl(ViewImpl view, PresenterEn presenter, ControllerFactoryImpl factory) {
        super(view, presenter, factory);
    }

    @Override
    public void promptMessage(UIStateImpl state) {

        switch (state) {
            case SETUP_GAME:
                presenter.setupGamePromptMessage();
                break;
            case CREATE_PLAYER_0:
            case CREATE_PLAYER_1:
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
    public void setViewController() {
        super.view.setController(super.controller);
    }

    @Override
    public void readView() throws IOException {
        super.view.read();
    }
}
