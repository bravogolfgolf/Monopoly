package usecases;

class CreatePlayerController implements Controller {
    private final Interactor interactor;

    CreatePlayerController(Interactor interactor) {
        this.interactor = interactor;
    }

    public void sendRequest(Request request) {
        interactor.handle(request);
    }
}
