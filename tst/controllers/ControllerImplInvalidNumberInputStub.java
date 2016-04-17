package game.controllers;

import java.io.IOException;

class ControllerImplInvalidNumberInputStub extends ControllerImpl {
    ControllerImplInvalidNumberInputStub(View view, Interactor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("999");
    }
}
