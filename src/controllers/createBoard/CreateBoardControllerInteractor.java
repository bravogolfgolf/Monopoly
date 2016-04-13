package game.controllers.createBoard;

import game.interactors.createboard.CreateBoardRequest;

public interface CreateBoardControllerInteractor {
    void handle(CreateBoardRequest request);
}
