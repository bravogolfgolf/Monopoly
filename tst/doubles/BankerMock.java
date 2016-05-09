package game.doubles;

import game.entities.Banker;

public class BankerMock extends Banker {

    public boolean verifyPaySalaryCalled = false;

    @Override
    public void paySalary() {
        verifyPaySalaryCalled = true;
    }
}
