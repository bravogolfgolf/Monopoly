package game.controllers;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SetupGamePresenter;

import java.util.Arrays;

public abstract class Presenter implements CreatePlayerPresenter, SetupGamePresenter {

    private static final String NEW_LINE = System.lineSeparator();
    private StringBuffer messageBuffer = new StringBuffer();
    protected String template;
    protected String[] variables;

    public String getFormattedMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    protected void addMenuToBuffer(String template, String[] variables) {
        sortArray(variables);
        String[] menuItems = createMenuArray(variables);
        addMessageToBuffer(template, menuItems);
    }

    protected void addMessageToBuffer(String template, String[] variables) {
        sortArray(variables);
        String variable = arrayToCommaDelimitedString(variables);
        String formattedMessage = formatMessage(template, variable);
        addMessageToBuffer(formattedMessage);
    }

    protected void addMessageToBuffer(String message) {
        String newLine = addNewLine(message);
        messageBuffer.append(newLine);
    }

    private void sortArray(String[] variables) {
        Arrays.sort(variables);
    }

    private String[] createMenuArray(String[] variables) {
        String[] menuItems = new String[variables.length];
        for (int i = 1; i <= variables.length; i++) {
            menuItems[i - 1] = String.format("(%d)%s", i, variables[i - 1]);
        }
        return menuItems;
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private String formatMessage(String template, String variable) {
        return String.format(template, variable);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
