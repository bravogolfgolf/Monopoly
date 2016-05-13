package game.entities;

import game.interactors.paysalary.PaySalaryBankerGateway;

import static game.Context.currentPlayer;
import static game.entities.Token.TransactionType.RECIEVE_CASH;

public class Banker implements PaySalaryBankerGateway {

    public void paySalary() {
        currentPlayer.transaction(200, RECIEVE_CASH);
    }
}
