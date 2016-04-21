package game.manager;

import game.Command;
import game.Monopoly;

public class UIManagerSetupGame extends UIManager {

    public UIManagerSetupGame(ManagerUIPresenter presenter, ControllerFactory factory) {
        super(presenter, factory);
    }

    @Override
    public void promptMessage(UIStateImpl state) {
        presenter.setupGamePromptMessage();
    }

    @Override
    public void addCommandToStack(String commandString, UIStateImpl state) {
        Command command = factory.make(commandString, state);
        Monopoly.addCommandToStack(command);
    }
}
