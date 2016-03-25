package pkg.card.domain;

import pkg.monopoly.Player;

import java.util.List;

public class Transaction extends Card {
    private int amount = 0;
    private String recipient = "";

    public Transaction(String cardText, int amount, String recipient) {
        this.cardText = cardText;
        this.amount = amount;
        this.recipient = recipient;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        if (recipient.equals("Bank"))
            player.transaction(amount, amount, Player.TransactionType.CASH);
        if (recipient.equals("Players")) {
            List<Player> otherPlayers = player.getAllOtherPlayersInGame();
            int thisPlayersAmount = determineHowMuchThisPlayerCollectsOrPays(otherPlayers);
            player.transaction(thisPlayersAmount, thisPlayersAmount, Player.TransactionType.CASH);
            for (Player otherPlayer : otherPlayers)
                otherPlayer.transaction(-amount, -amount, Player.TransactionType.CASH);
        }
    }

    private int determineHowMuchThisPlayerCollectsOrPays(List<Player> otherPlayers) {
        return amount * otherPlayers.size();
    }
}
