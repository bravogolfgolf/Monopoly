package game.interactors.setupgame;

public interface SetupGamePresenter {
    void boardPromptMessage();

    void boardCreatedMessage(SetupGameResponse response);

    void availableBoardsMessage(SetupGameResponse response);
}
