package usecases;

class CreateBoardPresenterSpy implements Presenter {
    private CreateBoardResponse intendedResponse;

    @Override
    public void present(Response OutputResponse) {
        intendedResponse = (CreateBoardResponse) OutputResponse;
    }

    CreateBoardResponse getIntendedResponse() {
        return intendedResponse;
    }
}
