package usecase;

class CreatePlayerController {
    private CreatePlayerInteractor interactor;

    CreatePlayerController(CreatePlayerInteractor interactor) {
        this.interactor = interactor;
    }

    void sendRequest(CreatePlayerRequest request) {
        interactor.createPlayer(request);
    }
}
