package pkg.board;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

public class IncomeTax extends Space {

    public IncomeTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        final double TEN_PERCENT = .10;

        int tax;
        if (player.getNetWorth() <= 2000)
            tax = (int) (player.getNetWorth() * TEN_PERCENT);
        else tax = 200;
        player.transaction(-tax, -tax, Player.TransactionType.CASH);
    }
}
