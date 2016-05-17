package game.entities;

import game.interactors.incometax.CollectIncomeTaxBankerGateway;
import game.interactors.paysalary.PaySalaryBankerGateway;

import static game.Context.currentPlayer;
import static game.entities.Token.TransactionType.PAY_CASH;
import static game.entities.Token.TransactionType.RECIEVE_CASH;

public class Banker implements PaySalaryBankerGateway, CollectIncomeTaxBankerGateway {

    public void paySalary() {
        currentPlayer.transaction(200, RECIEVE_CASH);
    }

    public int collectIncomeTax() {
        int result = 200;
        if (currentPlayer.netWorth() < 2000){
            result = (int) (currentPlayer.netWorth() * .10);
            currentPlayer.transaction(result, PAY_CASH);
        }
        else currentPlayer.transaction(result, PAY_CASH);
        return result;
    }
}
