package game.interactors.createboard;

public interface CreateBoardPresenter {
    void boardPromptMessage();
    void boardCreatedMessage(CreateBoardResponse response);
}
