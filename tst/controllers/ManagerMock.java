package game.controllers;

class ManagerMock implements Manager {

    boolean verifyValidNumberEnteredCalled;
    boolean verifyInvalidNumberEnteredCalled;
    boolean verifyInvalidTextEnteredCalled;

    @Override
    public void validNumberEntered() {
        verifyValidNumberEnteredCalled = true;
    }

    @Override
    public void invalidNumberEntered() {
        verifyInvalidNumberEnteredCalled = true;

    }

    @Override
    public void invalidTextEntered() {
        verifyInvalidTextEnteredCalled = true;

    }
}
