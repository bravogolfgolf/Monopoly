package game.interactors.tokenoptions;

public interface TokenOptionsPresenter {

    void createPlayerPromptMessageFewerThanMinimum();

    void createPlayerPromptMessageMinimumToMaximum();

    void availableTokensMessage(TokenOptionsResponse response);
}
