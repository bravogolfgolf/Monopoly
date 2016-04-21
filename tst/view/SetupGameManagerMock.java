package game.view;

class SetupGameManagerMock implements Manager {
    boolean verifyValidEntryCalled = false;
    boolean verifyInvalidEntryCalled = false;
    boolean verifyPromptMessageCalled = false;

    @Override
    public void promptMessage() {
        verifyPromptMessageCalled = true;
    }

    @Override
    public void validUseCaseEntry() {
        verifyValidEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;

    }
}
