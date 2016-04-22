package game.view;

class CreatePlayerManagerMock implements Manager {

    boolean validUseCaseEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;
    boolean verifyPromptMessageCalled = false;

    @Override
    public void promptMessage() {
        verifyPromptMessageCalled = true;
    }

    @Override
    public void validUseCaseEntry() {
        validUseCaseEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;
    }
}
