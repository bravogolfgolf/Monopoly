package game.interactors.options;

import game.interactors.InteractorResponse;

public interface OptionsPresenter {

    void availableVersionsMessage(InteractorResponse response);

    void availableTokensMessage(InteractorResponse response);
}
