package game.interactors.tokenoptions;

public class TokenOptionsMinimumToMaximum extends TokenOptions {

    public TokenOptionsMinimumToMaximum(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens) {
        super(presenter, tokens);
    }

    @Override
    void sendUserInterfacePrompt() {
        presenter.createPlayerPromptMessageMinimumToMaximum();
    }
}
