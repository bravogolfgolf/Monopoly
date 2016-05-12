package game.doubles;

import game.factories.ControllerFactory;
import game.manager.StateManager;

public class StateManagerMock extends StateManager {

    public boolean validUseCaseEntryCalled = false;
    public boolean verifyInvalidEntryCalled = false;
    public boolean verifyZeroEnteredCalled = false;
    public boolean verifyOneEnteredCalled = false;
    public boolean verifyTwoEnteredCalled = false;

    public StateManagerMock(ControllerFactory factory) {
        super(factory);
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
