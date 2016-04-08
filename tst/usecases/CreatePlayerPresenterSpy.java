package usecases;

import presenters.Presenter;
import usecases.createplayer.CreatePlayerResponse;

import java.io.BufferedWriter;
import java.io.IOException;

class CreatePlayerPresenterSpy implements Presenter {
    private CreatePlayerResponse response;

    CreatePlayerPresenterSpy(BufferedWriter view) {
    }

    @Override
    public void present(Response OutputResponse) throws IOException {
        response = (CreatePlayerResponse) OutputResponse;

    }

    CreatePlayerResponse getResponse() {
        return response;
    }
}
