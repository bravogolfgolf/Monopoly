package pkg.card;

import pkg.monopoly.Player;
import pkg.monopoly.RealEstate;
import pkg.monopoly.Space;

import java.util.List;

class Repair extends Card {
    private static final int HOTEL = 5;
    private int hotelAssessmentAmount = 0;
    private int houseAssessmentAmount = 0;

    Repair(String cardText, int house, int hotel) {
        setCardText(cardText);
        houseAssessmentAmount = house;
        hotelAssessmentAmount = hotel;
    }

    @Override
    boolean isGetOutOfJailCard() {
        return false;
    }

    @Override
    public void action(Player player) {
        int assessment = 0;
        List<RealEstate> realEstateHoldings = Space.getAllRealEstateOf(player);
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
