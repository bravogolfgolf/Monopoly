package game.entities;

import game.interactors.passgo.PassGoBankerGateway;

import static game.Context.currentPlayer;
import static game.entities.Token.TransactionType.RECIEVE_CASH;

public class Banker implements PassGoBankerGateway {

    public void paySalary() {
        currentPlayer.turnState.passedGO = false;
        currentPlayer.transaction(200, RECIEVE_CASH);
    }
}
