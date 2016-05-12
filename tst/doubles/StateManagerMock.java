package game.doubles;

import game.manager.State;
import game.manager.StateManager;

public class StateManagerMock extends StateManager {

    public boolean validUseCaseEntryCalled = false;
    public boolean verifyInvalidEntryCalled = false;
    public boolean verifyZeroEnteredCalled = false;
    public boolean verifyOneEnteredCalled = false;
    public boolean verifyTwoEnteredCalled = false;
    public boolean verifySetStateCalled = false;

    @Override
    public void setState(State state) {
        verifySetStateCalled = true;
    }

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
