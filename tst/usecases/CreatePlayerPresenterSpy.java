package usecases;

class CreatePlayerPresenterSpy implements Presenter {
    private CreatePlayerResponse intendedResponse;

    @Override
    public void present(Response OutputResponse) {
        intendedResponse = (CreatePlayerResponse) OutputResponse;
    }

    CreatePlayerResponse getIntendedResponse() {
        return intendedResponse;
    }
}
