package game.controllers;

class InteractorMock implements ControllerInteractor {

    boolean verifyHandleCalled = false;

    @Override
    public void handle(InteractorRequest request) {
        verifyHandleCalled = true;
    }
}
