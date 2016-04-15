package game.preseters;

import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;

class CreatePlayerStub extends CreatePlayer {

    private final CreatePlayerPresenter presenter;
    private final CreatePlayerResponse response = new CreatePlayerResponse();


    CreatePlayerStub(CreatePlayerPresenter presenter, CreatePlayerGateway player) {
        super(presenter, player);
        this.presenter = presenter;
    }

    @Override
    protected void exceededPlayerLimitMessage() {
        presenter.exceededPlayerLimitMessage();
    }

    @Override
    protected void playerCreatedMessage() {
        response.tokens = new String[]{"Cat"};
        presenter.playerCreatedMessage(response);
    }

    @Override
    protected void tokenInUseMessage() {
        response.tokens = new String[]{"Cat"};
        presenter.tokenInUseMessage(response);
    }

    @Override
    public void createPlayerPrompt() {
        presenter.createPlayerPromptMessage();
    }

    @Override
    public void availableTokensMessage() {
        response.tokens = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        presenter.availableTokensMessage(response);
    }
}
