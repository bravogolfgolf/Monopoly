package game.manager;

public class UIManagerImpl extends UIManager {

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
    public void addControllerToStack(String controller) {
        UIManager.controller = factory.make(controller);
    }
}
