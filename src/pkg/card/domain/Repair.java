package pkg.card.domain;

import pkg.board.domain.Board;
import pkg.monopoly.Player;
import pkg.board.domain.RealEstate;

import java.util.List;

public class Repair extends Card {
    private static final int HOTEL = 5;
    private int hotelAssessmentAmount = 0;
    private int houseAssessmentAmount = 0;

    public Repair(String cardText, int house, int hotel) {
        this.cardText = cardText;
        houseAssessmentAmount = house;
        hotelAssessmentAmount = hotel;
    }

    @Override
    public boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        int assessment = 0;
        List<RealEstate> realEstateHoldings = Board.getAllRealEstateOf(player);
        for (RealEstate realEstate : realEstateHoldings) {
            int numberOfImprovements = realEstate.getImprovements();
            if (numberOfImprovements == HOTEL)
                assessment += hotelAssessmentAmount;
            else
                assessment += (numberOfImprovements * houseAssessmentAmount);
        }
        player.transaction(-assessment, -assessment, Player.TransactionType.CASH);
    }
}
