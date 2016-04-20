package game.view;

import game.controllers.Manager;

class CreatePlayerManagerMock implements Manager {

    boolean verifyValidEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;

    @Override
    public void validEntry() {
        verifyValidEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;
    }
}
