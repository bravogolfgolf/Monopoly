package game.interactors.tokenoptions;

public class TokenOptionsMinimumToMaximum extends TokenOptions {

    public TokenOptionsMinimumToMaximum(TokenOptionsPresenter presenter, TokenOptionsTokensGateway tokens, TokenOptionsPlayersGateway players, TokenOptionsBoardGateway board) {
        super(presenter, tokens, players, board);
    }

    @Override
    void sendUserInterfacePrompt() {
        presenter.createPlayerPromptMessageMinimumToMaximumMessage();
    }
}
