package interactors.createplayer;

import entitiies.Player;
import interactors.Interactor;
import interactors.Request;
import presenters.Presenter;

import java.io.IOException;

public class CreatePlayerInteractor implements Interactor {
    private static final String NEW_LINE = System.lineSeparator();
    private static final int PLAYER_LIMIT = 8;
    private Presenter presenter;
    private CreatePlayerGateway gateway;
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
