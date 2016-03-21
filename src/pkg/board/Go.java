package pkg.board;

import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

public class Go extends Space {

    private static final int SALARY = 200;

    public Go(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, SourceOfMoveMultiplier sourceOfMoveMultiplier, OwnershipMultiplier ownershipMultiplier) {
        collectSalary(player);
    }

    @Override
    public void passBy(Player player) {
        collectSalary(player);
    }

    private void collectSalary(Player player) {
        player.transaction(SALARY, SALARY, Player.TransactionType.CASH);
    }
}
