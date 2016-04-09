package presenters.createboard;

import interactors.Response;
import interactors.createboard.CreateBoardResponse;
import presenters.Presenter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateBoardPresenterSpy implements Presenter {
    private CreateBoardResponse response;
    private OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private BufferedWriter view = new BufferedWriter(outputStreamWriter);

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
