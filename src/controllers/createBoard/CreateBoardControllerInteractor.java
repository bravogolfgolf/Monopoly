package game.controllers.createBoard;

import game.interactors.createboard.CreateBoardRequest;

public interface CreateBoardControllerInteractor {
    void boardPromptAndAvailableBoardsMessages();
    void handle(CreateBoardRequest request);
}
