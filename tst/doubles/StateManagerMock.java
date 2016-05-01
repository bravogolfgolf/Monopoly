package game.doubles;

import game.manager.ManagerControllerFactory;
import game.manager.StateManagerImpl;

public class StateManagerMock extends StateManagerImpl {

    public boolean validUseCaseEntryCalled = false;
    public boolean verifyInvalidEntryCalled = false;
    public boolean verifyZeroEnteredCalled = false;
    public boolean verifyOneEnteredCalled = false;
    public boolean verifyTwoEnteredCalled = false;

    public StateManagerMock(ManagerControllerFactory factory) {
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
