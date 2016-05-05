package game.interactors.tokenoptions;

public class TokenOptionsFewerThanMinimum extends TokenOptions {

    public TokenOptionsFewerThanMinimum(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens, TokenOptionsPlayersGateway players, TokenOptionsBoardGateway board) {
        super(presenter, tokens, players, board);
    }

    @Override
    void sendUserInterfacePrompt() {
        presenter.createPlayerPromptMessageFewerThanMinimumMessage();
    }
}
