package game.interactors.options;

import game.controllers.ControllerInteractor;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

public class Options implements ControllerInteractor {

    private final OptionsPresenter presenter;
    private final OptionsFactory factory;
    private final OptionsPlayerGateway players;
    private final InteractorResponse response = new InteractorResponse();

    public Options(OptionsPresenter presenter, OptionsFactory factory, OptionsPlayerGateway players) {
        this.presenter = presenter;
        this.factory = factory;
        this.players = players;
    }

    @Override
    public void handle(InteractorRequest request) {
        switch (request.string) {
            case "Versions":
                versionOptions();
                break;
            case "Tokens":
                tokenOptions();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void tokenOptions() {
        response.options = players.getAvailableTokens();
        presenter.availableTokensMessage(response);
    }

    private void versionOptions() {
        response.options = factory.getAvailableVersions();
        presenter.availableVersionsMessage(response);
    }
}
