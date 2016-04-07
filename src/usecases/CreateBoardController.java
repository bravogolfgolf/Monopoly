package usecases;

class CreateBoardController implements Controller {
    private Interactor interactor;

    CreateBoardController(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void sendRequest(Request request) {
        interactor.handle(request);

    }
}
