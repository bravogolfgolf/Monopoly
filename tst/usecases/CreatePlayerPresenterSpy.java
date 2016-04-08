package usecases;

import presenters.Presenter;
import usecases.createplayer.CreatePlayerResponse;

import java.io.BufferedWriter;
import java.io.IOException;

class CreatePlayerPresenterSpy implements Presenter {
    private CreatePlayerResponse response;
    private BufferedWriter view;

    public void setView(BufferedWriter view) {
        this.view = view;
    }

    @Override
    public void present(Response OutputResponse) throws IOException {
        response = (CreatePlayerResponse) OutputResponse;

    }

    CreatePlayerResponse getResponse() {
        return response;
    }
}
