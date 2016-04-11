package game.interactors.createplayer;

public interface CreatePlayerInteractorPresenter {
    void playerCreatedMessage(CreatePlayerResponse response);

    void tokenInUseMessage(CreatePlayerResponse response);

    void exceededPlayerLimitMessage();

    void playerPromptMessage();
}
