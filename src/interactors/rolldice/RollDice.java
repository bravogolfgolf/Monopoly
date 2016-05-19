package game.interactors.rolldice;

import game.interactors.Interactor;
import game.presenters.Presenter;

import static game.Context.currentPlayer;
import static game.Context.dice;

public class RollDice extends Interactor {

    private final RollDicePresenter presenter;
    private final RollDiceResponse response = new RollDiceResponse();

    public RollDice(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        dice.roll();
        if (dice.isDoubles())
            response.isDoubles = dice.isDoubles();
        currentPlayer.setMove(dice.rolled());
        response.rolled = dice.rolled();
        presenter.rollMessage(response);
    }
}
