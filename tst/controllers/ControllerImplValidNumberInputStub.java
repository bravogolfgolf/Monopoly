package game.controllers;

import java.io.IOException;

class ControllerImplValidNumberInputStub extends ControllerImpl {
    ControllerImplValidNumberInputStub(View view, Interactor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("1");
    }
}
