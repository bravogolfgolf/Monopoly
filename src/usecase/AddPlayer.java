package usecase;

import pkg.game.Player;

class AddPlayer implements AddPlayerInteractor {

    private AddPlayerPresenter addPlayerPresenter;

    AddPlayer(AddPlayerPresenter addPlayerPresenter) {
        this.addPlayerPresenter = addPlayerPresenter;
    }

    @Override
    public void addPlayer(AddPlayerRequest addPlayerRequest) {
        Player player = new Player(addPlayerRequest.token);
        AddPlayerResponse response = new AddPlayerResponse();
        response.token = player.getDescription();
        addPlayerPresenter.presentResponse(response);
    }
}
