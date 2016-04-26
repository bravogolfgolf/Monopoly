package game.interactors.tokenoptions;

public interface TokenOptionsPresenter {

    void createPlayerPromptMessageFewerThanMinimumMessage();

    void createPlayerPromptMessageMinimumToMaximumMessage();

    void availableTokensMessage(TokenOptionsResponse response);
}
