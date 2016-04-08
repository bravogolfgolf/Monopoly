package presenters.createplayer;

import presenters.Presenter;
import usecases.Response;
import usecases.createplayer.CreatePlayerResponse;

import java.io.BufferedWriter;
import java.io.IOException;

public class CreatePlayerPresenter implements Presenter {
    private CreatePlayerResponse response;
    private BufferedWriter view;

    public void setView(BufferedWriter view) {
        this.view = view;
    }

    @Override
    public void present(Response outputResponse) throws IOException {
        response = (CreatePlayerResponse) outputResponse;
        String s = String.format("%s", response.message);
        view.write(s);
        view.flush();
    }
}
