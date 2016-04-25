package game.interactors.options;

import game.controllers.basic.BasicInteractor;
import game.controllers.basic.BasicRequest;
import game.controllers.setmap.MenuInteractor;
import game.entities.Token;

import java.util.Set;

public class VersionOptions implements BasicInteractor, MenuInteractor {

    private final VersionOptionsPresenter presenter;
    private final VersionOptionsFactory factory;
    private final OptionsTokensGateway tokens;
    private final VersionOptionsResponse response = new VersionOptionsResponse();

    public VersionOptions(VersionOptionsPresenter presenter, VersionOptionsFactory factory, OptionsTokensGateway tokens) {
        this.presenter = presenter;
        this.factory = factory;
        this.tokens = tokens;
    }

    @Override
    public void handle(BasicRequest request) {
        switch (request.string) {
            case "Versions":
                response.versions = factory.getAvailableVersions();
                presenter.availableVersionsMessage(response);
                break;
            case "Tokens":
                tokenOptions();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void handle() {
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
