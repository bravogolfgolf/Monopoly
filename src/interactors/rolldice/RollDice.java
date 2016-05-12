package game.interactors.rolldice;

import game.interactors.Interactor;
import game.presenters.Presenter;

import static game.Context.dice;
import static game.manager.StateImpl.NOT_ROLL_DOUBLE;
import static game.manager.StateImpl.ROLL_DOUBLE_1;

public class RollDice extends Interactor {

    private final RollDicePresenter presenter;
    private final RollDiceManagerGateway manager;
    private final RollDiceResponse response = new RollDiceResponse();

    public RollDice(Presenter presenter, RollDiceManagerGateway manager) {
        this.presenter = presenter;
        this.manager = manager;
    }

    @Override
    public void handle() {
        dice.roll();
        if (dice.isDoubles()) {
            response.isDoubles = dice.isDoubles();
            manager.setState(ROLL_DOUBLE_1);
        } else
            manager.setState(NOT_ROLL_DOUBLE);
        response.rolled = dice.rolled();
        presenter.rollMessage(response);
    }
}
