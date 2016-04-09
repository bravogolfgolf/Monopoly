package presenters.createplayer;

import interactors.Response;
import interactors.createplayer.CreatePlayerResponse;
import presenters.Presenter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreatePlayerPresenter implements Presenter {
    private CreatePlayerResponse response;
    private OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private BufferedWriter view = new BufferedWriter(outputStreamWriter);

    public void setView(BufferedWriter view) {
        this.view = view;
    }

    @Override
    public void present(Response response) throws IOException {
        this.response = (CreatePlayerResponse) response;
        view.write(this.response.message);
        view.flush();
    }

    public CreatePlayerResponse getResponse() {
        return response;
    }
}
