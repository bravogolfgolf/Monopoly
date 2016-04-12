package game.controllers;

import game.interactors.createboard.CreateBoardPresenter;
import game.interactors.createplayer.CreatePlayerPresenter;

public abstract class Presenter implements CreatePlayerPresenter, CreateBoardPresenter {

    private static final String NEW_LINE = System.lineSeparator();
    private StringBuffer messageBuffer = new StringBuffer();

    public String getFormattedMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    protected String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    protected String formatMessage(String template, String variable) {
        String result = String.format(template, variable);
        return addNewLine(result);
    }

    private static String addNewLine(String string){
        return String.format(string + "%s", NEW_LINE);
    }

    protected void addToBuffer(String message) {
        messageBuffer.append(message);
    }
}
