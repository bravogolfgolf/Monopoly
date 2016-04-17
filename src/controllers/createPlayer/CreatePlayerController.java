package game.controllers.createPlayer;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.View;
import game.interactors.createplayer.CreatePlayerRequest;

import java.io.IOException;
import java.util.Map;

public class CreatePlayerController implements Controller {

    private final View view;
    private final CreatePlayerInteractor interactor;
    private final Presenter presenter;

    public CreatePlayerController(View view, CreatePlayerInteractor interactor, Presenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        prompt();
        String line = view.read();
        parse(line);
    }

    private void prompt() throws IOException {
        interactor.createPlayerPrompt();
        updateView();
    }

    private void updateView() throws IOException {
        view.write(presenter.getFormattedMessage());
    }

    void parse(String line) throws IOException {
        int selection;

        try {
            selection = Integer.parseInt(line);
            String result = getMenuMessage().get(selection);
            handle(result);

        } catch (NumberFormatException e) {
            prompt();
        }
    }

    private Map<Integer, String> getMenuMessage() {
        interactor.availableTokensMessage();
        return presenter.getMenuMap();
    }

    private void handle(String text) throws IOException {
        CreatePlayerRequest request = new CreatePlayerRequest();
        request.token = text;
        interactor.handle(request);
        updateView();
    }
}