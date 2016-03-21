package pkg.board;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

public class LuxuryTax extends Space {

    public LuxuryTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        final int LUXURY_TAX_AMOUNT = -75;
        player.transaction(LUXURY_TAX_AMOUNT, LUXURY_TAX_AMOUNT, Player.TransactionType.CASH);
    }
}
