package game.interactors.setupgame;

public interface SetupGamePresenter {

    void setupGamePromptMessage();

    void versionCreatedMessage(SetupGameResponse response);

    void availableVersionsMessage(SetupGameResponse response);
}
