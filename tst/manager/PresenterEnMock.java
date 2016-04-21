package game.manager;

class PresenterEnMock implements UIManagerPresenter {
    boolean verifySetupGamePromptMessageCalled = false;
    boolean verifyCreatePlayerPromptMessageCalled = false;

    @Override
    public void setupGamePromptMessage() {
        verifySetupGamePromptMessageCalled = true;
    }

    @Override
    public void createPlayerPromptMessage() {
        verifyCreatePlayerPromptMessageCalled = true;
    }
}
