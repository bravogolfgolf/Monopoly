package presenters.createboard;

import presenters.Presenter;
import usecases.Response;
import usecases.createboard.CreateBoardResponse;

import java.io.BufferedWriter;
import java.io.IOException;

public class CreateBoardPresenter implements Presenter {
    private CreateBoardResponse response;
    private BufferedWriter view;

    public CreateBoardPresenter(BufferedWriter view) {
        this.view = view;
    }

    @Override
    public void present(Response OutputResponse) throws IOException {
        response = (CreateBoardResponse) OutputResponse;
        String s = String.format("%s version of board created.", response.message);
        view.write(s);
        view.flush();}
}
