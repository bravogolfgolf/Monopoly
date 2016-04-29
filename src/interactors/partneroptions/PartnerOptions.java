package game.interactors.partneroptions;

import game.controllers.ControllerInteractor;
import game.controllers.ControllerRequest;

public class PartnerOptions implements ControllerInteractor {

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

    @Override
    public void handle(ControllerRequest request) {

    }
}
