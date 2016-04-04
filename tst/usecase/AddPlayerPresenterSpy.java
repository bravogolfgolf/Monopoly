package usecase;

class AddPlayerPresenterSpy implements AddPlayerPresenter {
    private AddPlayerResponse intendedResponse;

    @Override
    public void presentResponse(AddPlayerResponse addPlayerResponse) {
        intendedResponse = addPlayerResponse;
    }

    AddPlayerResponse getIntendedResponse() {
        return intendedResponse;
    }
}
