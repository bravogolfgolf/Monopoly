package game.interactors.createplayer;

public interface CreatePlayerPresenter {
    void playerCreatedMessage(CreatePlayerResponse response);

    void tokenInUseMessage(CreatePlayerResponse response);

    void exceededPlayerLimitMessage();

    void playerPromptMessage();
}
