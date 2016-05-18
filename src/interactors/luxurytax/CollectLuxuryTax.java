package game.interactors.luxurytax;

import game.entities.Banker;
import game.interactors.Interactor;
import game.presenters.Presenter;

public class CollectLuxuryTax extends Interactor {

    private final CollectLuxuryTaxBanker banker;
    private final CollectLuxuryTaxPresenter presenter;

    public CollectLuxuryTax(Banker banker, Presenter presenter) {
        this.banker = banker;
        this.presenter = presenter;
    }

    @Override
    public void handle() {
        banker.collectLuxuryTax();
        presenter.collectLuxuryTaxMessage();
    }
}
