package game.controllers.createBoard;

import game.interactors.createboard.CreateBoardRequest;

public interface CreateBoardInteractor {
    void boardPromptAndAvailableBoardsMessages();
    void handle(CreateBoardRequest request);
}
