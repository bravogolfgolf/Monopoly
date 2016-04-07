package usecases;

import entitiies.Board;

class CreateBoard implements Interactor {
    private final Presenter presenter;
    private final Factory factory;

    CreateBoard(Presenter presenter, Factory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public void handle(Request inputRequest) {
        CreateBoardRequest request = (CreateBoardRequest) inputRequest;
        CreateBoardResponse response = new CreateBoardResponse();
        Board board = (Board) factory.make(request.version);
        response.message = formatResponseMessage(board);
        presenter.present(response);
    }

    private String formatResponseMessage(Board board) {
        return String.format("%s version of board created.", board.getVersion());
    }
}
