package presenters.createboard;

import interactors.Response;
import interactors.createboard.CreateBoardResponse;
import presenters.Presenter;

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
