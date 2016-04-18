package game.controllers;

import java.io.IOException;

class ControllerImplValidNumberInputStub extends ControllerImpl {

    ControllerImplValidNumberInputStub(View view, Manager manager, Interactor interactor, Presenter presenter) {
        super(view, manager, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("1");
    }
}
