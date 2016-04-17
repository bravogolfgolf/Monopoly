package game.controllers.setupgame;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.View;
import game.interactors.setupgame.SetupGameRequest;

import java.io.IOException;
import java.util.Map;

public class SetupGameController implements Controller {

    private final View view;
    private final SetupGameInteractor interactor;
    private final Presenter presenter;

    public SetupGameController(View view, SetupGameInteractor interactor, Presenter presenter) {
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
        interactor.setupGamePrompt();
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
            if (result == null)
                prompt();
            handle(result);

        } catch (NumberFormatException e) {
            prompt();
        }
    }

    private Map<Integer, String> getMenuMessage() {
        interactor.availableVersionsMessage();
        return presenter.getMenuMap();
    }

    private void handle(String text) throws IOException {
        SetupGameRequest request = new SetupGameRequest();
        request.version = text;
        interactor.handle(request);
        updateView();
    }
}