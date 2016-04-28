package game.controllers;

class InteractorMock implements WriterInteractor {

    boolean verifyHandleWithArgumentCalled = false;
    boolean verifyHandleWithOutArgumentCalled = false;

    @Override
    public void handle(ReaderRequest request) {
        verifyHandleWithArgumentCalled = true;
    }

    @Override
    public void handle() {
        verifyHandleWithOutArgumentCalled = true;
    }
}
