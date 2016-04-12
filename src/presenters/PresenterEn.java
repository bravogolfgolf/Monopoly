package game.presenters;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;

import static game.utilities.StringFormatter.addNewLine;

public class PresenterEn extends Presenter {
    private String template;
    private CharSequence[] array;
    private String variable;
    private String formattedMessage;
    private StringBuffer messageBuffer = new StringBuffer();

    public String getFormattedMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(",", array);
    }

    private String formatMessage(String template, String variable) {
        String result = String.format(template, variable);
        return addNewLine(result);
    }

    private void addToBuffer(String message) {
        messageBuffer.append(message);
    }

    @Override
    public void boardCreatedMessage(CreateBoardResponse response) {
        template = "%s versions of board created.";
        array = response.versions;
        variable = arrayToCommaDelimitedString(array);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    @Override
    public void availableBoardsMessage(CreateBoardResponse response) {
        template = "Available boards: %s";
        array = response.versions;
        variable = arrayToCommaDelimitedString(array);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    @Override
    public void boardPromptMessage() {
        template = "Select versions of board you would like to use.";
        formattedMessage = formatMessage(template, null);
        addToBuffer(formattedMessage);
    }

    @Override
    public void exceededPlayerLimitMessage() {
        template = "Exceeded eight player limit.";
        formattedMessage = formatMessage(template, null);
        addToBuffer(formattedMessage);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        template = "Player created with %s tokens.";
        array = response.tokens;
        variable = arrayToCommaDelimitedString(array);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    @Override
    public void playerPromptMessage() {
        template = "Please select tokens for player.";
        formattedMessage = formatMessage(template, null);
        addToBuffer(formattedMessage);
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        template = "%s tokens already in use.";
        array = response.tokens;
        variable = arrayToCommaDelimitedString(array);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }
}
