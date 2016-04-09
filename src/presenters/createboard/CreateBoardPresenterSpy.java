package presenters.createboard;

import presenters.Presenter;
import usecases.Response;
import usecases.createboard.CreateBoardResponse;

import java.io.BufferedWriter;
import java.io.IOException;

public class CreateBoardPresenterSpy implements Presenter {
    private CreateBoardResponse response;
    private BufferedWriter view;

    public void setView(BufferedWriter view) {
        this.view = view;
    }

    @Override
    public void present(Response response) throws IOException {
        this.response = (CreateBoardResponse) response;
        view.write(this.response.message);
        view.flush();
    }

    public CreateBoardResponse getResponse() {
        return response;
    }
}
