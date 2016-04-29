package game.interactors.partneroptions;

import game.interactors.Interactor;

public class PartnerOptions extends Interactor {

    private final PartnerOptionsPresenter presenter;
    private final PartnerOptionsGateway players;
    private final PartnerOptionsResponse response = new PartnerOptionsResponse();

    public PartnerOptions(PartnerOptionsPresenter presenter, PartnerOptionsGateway players) {
        this.presenter = presenter;
        this.players = players;
    }

    @Override
    public void handle() {
        presenter.selectTradingPartnerPromptMessage();
        response.players = players.getAllPlayersExceptCurrent();
        presenter.partnerOptionsMessage(response);
    }
}
