package game.doubles;

import game.entities.Banker;

public class BankerMock extends Banker {

    public boolean verifyPaySalaryCalled = false;
    public boolean collectIncomeTaxCalled = false;
    public boolean collectLuxuryTaxCalled = false;

    @Override
    public void paySalary() {
        verifyPaySalaryCalled = true;
    }

    @Override
    public int collectIncomeTax() {
        collectIncomeTaxCalled = true;
        return -1;
    }

    @Override
    public void collectLuxuryTax() {
        collectLuxuryTaxCalled = true;
    }
}
