package game.interactors.paysalary;

import game.entities.Banker;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class PaySalary extends Interactor {

    private final PaySalaryPresenter presenter;
    private final PaySalaryBankerGateway banker;

    public PaySalary(Presenter presenter, Banker banker) {
        this.presenter = presenter;
        this.banker = banker;
    }

    @Override
    public void handle() {
        banker.paySalary();
        presenter.paySalaryMessage();
    }
}