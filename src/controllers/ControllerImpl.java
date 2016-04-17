package game.controllers;

import game.Controller;
import game.interactors.InteractorRequest;

import java.io.IOException;
import java.util.Map;

public class ControllerImpl implements Controller {

    private final View view;
    private final Interactor interactor;
    private final Presenter presenter;

    public ControllerImpl(View view, Interactor interactor, Presenter presenter) {
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
        interactor.userInterfacePrompt();
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
        interactor.userInterfaceOptions();
        return presenter.getMenuMap();
    }

    private void handle(String text) throws IOException {
        InteractorRequest request = new InteractorRequest();
        request.string = text;
        interactor.handle(request);
        updateView();
    }
}