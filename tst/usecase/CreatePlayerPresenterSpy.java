package usecase;

class CreatePlayerPresenterSpy implements Presenter {
    private CreatePlayerResponse intendedResponse;

    @Override
    public void presentResponse(CreatePlayerResponse createPlayerResponse) {
        intendedResponse = createPlayerResponse;
    }

    CreatePlayerResponse getIntendedResponse() {
        return intendedResponse;
    }
}
