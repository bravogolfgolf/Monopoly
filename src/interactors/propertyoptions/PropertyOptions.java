package game.interactors.propertyoptions;

import game.interactors.Interactor;

public class PropertyOptions extends Interactor {

    private final PropertyOptionsPresenter presenter;
    private final PropertyOptionsResponse response = new PropertyOptionsResponse();

    public PropertyOptions(PropertyOptionsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        presenter.selectPropertyPromptMessage();
        presenter.propertyOptionsMessage(response);
    }
}
