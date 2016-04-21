package game.manager;

import game.Command;
import game.Monopoly;

public class UIManagerImpl extends UIManager {

    public UIManagerImpl(UIManagerPresenter presenter, ControllerFactory factory) {
        super(presenter, factory);
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
    public void addCommandToStack(String commandString, UIStateImpl state) {
        Command command = factory.make(commandString, state);
        Monopoly.addCommandToStack(command);
    }
}
