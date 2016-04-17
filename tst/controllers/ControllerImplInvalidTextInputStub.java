package game.controllers;

import java.io.IOException;

class ControllerImplInvalidTextInputStub extends ControllerImpl {
    ControllerImplInvalidTextInputStub(View view, Interactor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("a");
    }
}
