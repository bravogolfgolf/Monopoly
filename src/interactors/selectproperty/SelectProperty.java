package game.interactors.selectproperty;

import game.controllers.reader.ReaderInteractor;
import game.controllers.reader.ReaderRequest;

public class SelectProperty implements ReaderInteractor {

    private final SelectPropertyPresenter presenter;

    public SelectProperty(SelectPropertyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void handle(ReaderRequest request) {

    }
}
