package usecases.createplayer;

import entitiies.Player;
import presenters.Presenter;
import usecases.Interactor;
import usecases.Request;

import java.io.IOException;

public class CreatePlayer implements Interactor {

    private static final int PLAYER_LIMIT = 8;
    private  Presenter presenter;
    private  CreatePlayerGateway gateway;
    private final CreatePlayerResponse response = new CreatePlayerResponse();

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setGateway(CreatePlayerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void handle(Request inputRequest) throws IOException {
        CreatePlayerRequest request = (CreatePlayerRequest) inputRequest;

        if (isValid(request)) {

            if (gateway.count() < PLAYER_LIMIT) {
                Player player = new Player(request.token);

                if (gateway.save(player))
                    response.message = formatResponseMessage(player);

                else response.message = "Token already in use.";

            } else response.message = "Exceeded eight player limit.";

        } else response.message = "Invalid request.";

        presenter.present(response);
    }

    private String formatResponseMessage(Player player) {
        return String.format("Player created with %s token.", player.getToken());
    }

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }
}
