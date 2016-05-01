package game.doubles;

import game.parser.ParserManager;

public class StateManagerMock implements ParserManager {

    public boolean validUseCaseEntryCalled = false;
    public boolean verifyInvalidEntryCalled = false;
    public boolean verifyZeroEnteredCalled = false;
    public boolean verifyOneEnteredCalled = false;
    public boolean verifyTwoEnteredCalled = false;

    @Override
    public void validTextEntry(String result) {
        validUseCaseEntryCalled = true;
    }

    @Override
    public void invalidEntry() {
        verifyInvalidEntryCalled = true;
    }

    @Override
    public void zeroEntered() {
        verifyZeroEnteredCalled = true;
    }

    @Override
    public void oneEntered() {
        verifyOneEnteredCalled = true;
    }

    @Override
    public void twoEntered() {
        verifyTwoEnteredCalled = true;
    }
}
