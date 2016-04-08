package usecases;

import presenters.Presenter;
import usecases.createboard.CreateBoardResponse;

import java.io.BufferedWriter;
import java.io.IOException;

class CreateBoardPresenterSpy implements Presenter {
    private CreateBoardResponse response;
    private BufferedWriter view;
    private String outputToView;

    public void setView(BufferedWriter view) {
        this.view = view;
    }

    @Override
    public void present(Response OutputResponse) throws IOException {
        response = (CreateBoardResponse) OutputResponse;
        outputToView = String.format("%s version of board created.", response.message);
    }

    String getResponse() {
        return outputToView;
    }
}
