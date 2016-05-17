package game.interactors.incometax;

import game.entities.Banker;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class CollectIncomeTax extends Interactor {

    private final CollectIncomeTaxBankerGateway banker;
    private final CollectIncomeTaxPresenter presenter;
    private final CollectIncomeTaxResponse response = new CollectIncomeTaxResponse();

    public CollectIncomeTax(Banker banker, Presenter presenter) {
        this.banker = banker;
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        response.amount = banker.collectIncomeTax();
        presenter.collectIncomeTaxMessage(response);
    }
}
