package game.interactors.tokenoptions;

public class TokenOptionsMinimumToMaximum extends TokenOptions {

    public TokenOptionsMinimumToMaximum(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens, TokenOptionsPlayersGateway players) {
        super(presenter, tokens, players);
    }

    @Override
    void sendUserInterfacePrompt() {
        presenter.createPlayerPromptMessageMinimumToMaximumMessage();
    }
}
