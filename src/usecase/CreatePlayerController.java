package usecase;

class CreatePlayerController {
    private final CreatePlayerInteractor interactor;

    CreatePlayerController(CreatePlayerInteractor interactor) {
        this.interactor = interactor;
    }

    void sendRequest(CreatePlayerRequest request) {
        interactor.createPlayer(request);
    }
}
