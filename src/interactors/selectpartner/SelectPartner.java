package game.interactors.selectpartner;

import game.controllers.reader.ReaderInteractor;
import game.controllers.reader.ReaderRequest;
import game.interactors.propertyoptions.PropertyOptionsPresenter;
import game.interactors.propertyoptions.PropertyOptionsResponse;

public class SelectPartner implements ReaderInteractor {

    private final PropertyOptionsPresenter presenter;
    private final PropertyOptionsResponse response = new PropertyOptionsResponse();

    public SelectPartner(PropertyOptionsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle(ReaderRequest request) {
        response.properties = null;
        presenter.selectPropertyPromptMessage();
        presenter.propertyOptionsMessage(response);
    }
}