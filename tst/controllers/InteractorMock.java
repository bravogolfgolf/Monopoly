package game.controllers;

class InteractorMock implements ControllerInteractor {

    boolean verifyHandleWithArgumentCalled = false;
    boolean verifyHandleWithOutArgumentCalled = false;

    @Override
    public void handle(ControllerRequest request) {
        verifyHandleWithArgumentCalled = true;
    }

    @Override
    public void handle() {
        verifyHandleWithOutArgumentCalled = true;
    }
}
