package game.interactors.partneroptions;

import game.controllers.writer.ReaderRequest;
import game.controllers.writer.WriterInteractor;

public class PartnerOptions implements WriterInteractor {

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
    public void handle(ReaderRequest request) {

    }
}
