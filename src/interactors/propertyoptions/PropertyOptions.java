package game.interactors.propertyoptions;

import game.controllers.WriterInteractor;

public class PropertyOptions implements WriterInteractor {

    private final PropertyOptionsPresenter presenter;
    private final PropertyOptionsResponse response = new PropertyOptionsResponse();

    public PropertyOptions(PropertyOptionsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        response.properties = null;
        presenter.propertyOptionsMessage(response);
    }
}
