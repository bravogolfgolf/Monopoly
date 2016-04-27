package game.controllers;

import game.controllers.reader.ReaderInteractor;
import game.controllers.reader.ReaderRequest;

class InteractorMock implements ReaderInteractor, WriterInteractor {

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
