package interactors.createplayer;

import entitiies.Player;
import interactors.Interactor;
import interactors.Request;
import main.PlayerGateway;
import presenters.Presenter;
import utilities.StringFormatter;

public class CreatePlayerInteractor implements Interactor {
    private final Presenter presenter;
    private final PlayerGateway gateway;

    public CreatePlayerInteractor(Presenter presenter, PlayerGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request inputRequest) {
        CreatePlayerRequest request = (CreatePlayerRequest) inputRequest;
        CreatePlayerResponse response = new CreatePlayerResponse();

        if (isValid(request)) {

            if (gateway.count() < PlayerGateway.PLAYER_LIMIT) {
                Player player = new Player(request.token);

                if (gateway.save(player))
                    response.message = StringFormatter.addNewLine(formatResponseMessage(player.getToken()));

                else response.message = StringFormatter.addNewLine("Token already in use.");

            } else response.message = StringFormatter.addNewLine("Exceeded eight player limit.");

        } else response.message = StringFormatter.addNewLine("Please select token for player.");

        presenter.present(response);
    }

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }

    private String formatResponseMessage(String token) {
        return String.format("Player created with %s token.", token);
    }
}
