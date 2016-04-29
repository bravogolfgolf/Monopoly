package game.interactors.propertyoptions;

import game.interactors.Interactor;

public class PropertyOptions extends Interactor {

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
