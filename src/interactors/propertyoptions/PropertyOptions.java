package game.interactors.propertyoptions;

import game.controllers.WriterInteractor;

public class PropertyOptions implements WriterInteractor {

    private final PropertyOptionsPresenter presenter;
    private final PropertyOptionsPlayerGateway players;
    private final PropertyOptionsResponse response = new PropertyOptionsResponse();

    public PropertyOptions(PropertyOptionsPresenter presenter, PropertyOptionsPlayerGateway players) {
        this.presenter = presenter;
        this.players = players;
    }

    @Override
    public void handle() {
        response.properties = null;
        players.getCurrentPlayer();
        presenter.selectPropertyPromptMessage();
        presenter.propertyOptionsMessage(response);
    }
}
