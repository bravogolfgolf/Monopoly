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

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private String formatMessage(String template, String variable) {
        return String.format(template, variable);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }

    protected void addToBuffer(String template, String[] variables) {
        Arrays.sort(variables);
        String variable = arrayToCommaDelimitedString(variables);
        String formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    protected void addToBuffer(String message) {
        String newLine = addNewLine(message);
        messageBuffer.append(newLine);
    }
}
