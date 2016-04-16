package game.controllers.setupgame;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.View;
import game.interactors.setupgame.SetupGameRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetupGameController implements Controller {

    private final View view;
    private final SetupGameInteractor interactor;
    private final Presenter presenter;
    private final Map<Integer, String> selections = new HashMap<>();

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
            String message = getMenuMessage();
            parseMenuMessageIntoMap(message);
            String result = selections.get(selection);
            handle(result);

        } catch (NumberFormatException e) {
            prompt();
        }
    }

    private String getMenuMessage() {
        interactor.availableVersionsMessage();
        return presenter.getFormattedMessage().trim();
    }

    private void parseMenuMessageIntoMap(String message) {
        Pattern pattern = Pattern.compile("\\([\\d]*\\)\\w*[\\s\\w*]*");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String text = matcher.group();
            String[] keyAndValue = text.replaceFirst("^\\(", "").split("\\)");
            selections.put(Integer.parseInt(keyAndValue[0]), keyAndValue[1]);
        }
    }

    private void handle(String text) throws IOException {
        SetupGameRequest request = new SetupGameRequest();
        request.version = text;
        interactor.handle(request);
        updateView();
    }
}
