package game.interactors.createboard;

public interface CreateBoardInteractorPresenter {
    void boardPromptMessage();
    void boardCreatedMessage(CreateBoardResponse response);
}
