package game.manager;

import game.Monopoly;

public class UIManagerImpl extends UIManager {

    public UIManagerImpl(UIManagerPresenter presenter) {
        super(presenter);
    }

    @Override
    public void promptMessage(UIStateImpl state) {

        switch (state) {
            case SETUP_GAME:
                presenter.setupGamePromptMessage();
                break;
            default:
                presenter.createPlayerPromptMessage();
                break;
        }
    }

    @Override
    public void addCommandToStack(String commandString) {
        Monopoly.addCommandToStack(commandString);
    }
}
