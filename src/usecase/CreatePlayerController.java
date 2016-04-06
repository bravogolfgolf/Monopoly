package usecase;

class CreatePlayerController implements Controller {
    private final Interactor interactor;

    CreatePlayerController(Interactor interactor) {
        this.interactor = interactor;
    }

    public void sendRequest(CreatePlayerRequest request) {
        interactor.handle(request);
    }
}
