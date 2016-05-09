package game.entities;

import game.Context;
import game.interactors.passgo.PassGoBankerGateway;

import static game.entities.Token.TransactionType.RECIEVE_CASH;

public class Banker implements PassGoBankerGateway {

    public void paySalary() {
        Context.currentPlayer.turnState.passedGO = false;
        Context.currentPlayer.transaction(200, RECIEVE_CASH);
    }
}
