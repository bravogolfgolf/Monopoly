package game.doubles;

import game.controllers.ControllerRequest;
import game.interactors.Interactor;

public class InteractorMock extends Interactor {

    public boolean verifyHandleWithArgumentCalled = false;
    public boolean verifyHandleWithOutArgumentCalled = false;

    @Override
    public void handle(ControllerRequest request) {
        verifyHandleWithArgumentCalled = true;
    }

    @Override
    public void handle() {
        verifyHandleWithOutArgumentCalled = true;
    }
}
