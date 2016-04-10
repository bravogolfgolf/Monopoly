package interactors.createplayer;

import controllers.Interactor;
import controllers.Presenter;
import interactors.PlayerGateway;
import interactors.Request;

import static utilities.StringFormatter.addNewLine;

public class CreatePlayerInteractor implements Interactor {
    private final Presenter presenter;
    private final PlayerGateway gateway;

    public CreatePlayerInteractor(Presenter presenter, PlayerGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request request) {
        CreatePlayerResponse response = new CreatePlayerResponse();
        CreatePlayerRequest createPlayerRequest = (CreatePlayerRequest) request;

        if (isValid(createPlayerRequest)) {

            if (gateway.count() < PlayerGateway.PLAYER_LIMIT) {

                if (gateway.create(createPlayerRequest.token))

                    response.message = addNewLine(formatResponseMessage(createPlayerRequest.token));

                else response.message = addNewLine("Token already in use.");

            } else response.message = addNewLine("Exceeded eight player limit.");

        } else response.message = addNewLine("Please select token for player.");

        presenter.present(response);
    }

    private boolean isValid(CreatePlayerRequest request) {
        return request.token != null;
    }

    private String formatResponseMessage(String token) {
        return String.format("Player created with %s token.", token);
    }
}
