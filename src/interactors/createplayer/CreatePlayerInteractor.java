package interactors.createplayer;

import entitiies.Player;
import interactors.Interactor;
import interactors.Request;
import main.PlayerGateway;
import presenters.Presenter;

public class CreatePlayerInteractor implements Interactor {
    private static final String NEW_LINE = System.lineSeparator();
    private static final int PLAYER_LIMIT = 8;
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

            if (gateway.count() < PLAYER_LIMIT) {
                Player player = new Player(request.token);

                if (gateway.save(player))
                    response.message = addNewLine(formatResponseMessage(player.getToken()));

                else response.message = addNewLine("Token already in use.");

            } else response.message = addNewLine("Exceeded eight player limit.");

        } else response.message = addNewLine("Invalid request.");

        presenter.present(response);
    }

    private String formatResponseMessage(String token) {
        return String.format("Player created with %s token.", token);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }
}
