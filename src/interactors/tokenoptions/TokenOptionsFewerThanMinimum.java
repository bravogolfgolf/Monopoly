package game.interactors.tokenoptions;

public class TokenOptionsFewerThanMinimum extends TokenOptions {

    public TokenOptionsFewerThanMinimum(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens, TokenOptionsPlayersGateway players) {
        super(presenter, tokens, players);
    }

    @Override
    void sendUserInterfacePrompt() {
        presenter.createPlayerPromptMessageFewerThanMinimumMessage();
    }
}
