package game.interactors.options;

import game.controllers.ControllerInteractor;
import game.entities.Token;
import game.interactors.InteractorRequest;
import game.interactors.InteractorResponse;

import java.util.Set;

public class Options implements ControllerInteractor {

    private final OptionsPresenter presenter;
    private final OptionsFactory factory;
    private final OptionsTokensGateway tokens;
    private final InteractorResponse response = new InteractorResponse();

    public Options(OptionsPresenter presenter, OptionsFactory factory, OptionsTokensGateway tokens) {
        this.presenter = presenter;
        this.factory = factory;
        this.tokens = tokens;
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

    private void versionOptions() {
        response.versions = factory.getAvailableVersions();
        presenter.availableVersionsMessage(response);
    }

    private void tokenOptions() {
        prepareResponse(tokens.getAvailableTokens());
    }

    private void prepareResponse(Set<Token> tokens) {
        int counter = 0;
        String[] strings = new String[tokens.size()];
        for (Token token : tokens) {
            strings[counter++] = token.getDescription();
        }
        response.tokens = strings;
        presenter.availableTokensMessage(response);
    }
}
