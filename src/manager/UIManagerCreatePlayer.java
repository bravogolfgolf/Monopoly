package game.manager;

import game.Command;
import game.Monopoly;

public class UIManagerCreatePlayer extends UIManager {

    public UIManagerCreatePlayer(UIManagerPresenter presenter, ControllerFactory factory) {
        super(presenter, factory);
    }

    @Override
    public void promptMessage(UIStateImpl state) {
        presenter.createPlayerPromptMessage();
    }

    @Override
    public void addCommandToStack(String commandString, UIStateImpl state) {
        Command command = factory.make(commandString, state);
        Monopoly.addCommandToStack(command);
    }
}
