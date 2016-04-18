package game.controllers;

import java.io.IOException;

class ControllerImplInvalidTextInputStub extends ControllerImpl {

    ControllerImplInvalidTextInputStub(View view, Manager manager, Interactor interactor, Presenter presenter) {
        super(view, manager, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("a");
    }
}
