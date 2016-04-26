package game.interactors.tokenoptions;

public class TokenOptionsFewerThanMinimum extends TokenOptions {

    public TokenOptionsFewerThanMinimum(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens) {
        super(presenter, tokens);
    }

    @Override
    void sendUserInterfacePrompt() {
        presenter.createPlayerPromptMessageFewerThanMinimumMessage();
    }
}
