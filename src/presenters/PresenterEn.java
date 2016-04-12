package game.presenters;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;

import static game.utilities.StringFormatter.addNewLine;

public class PresenterEn extends Presenter {
    private String message;
    private StringBuffer messageBuffer = new StringBuffer();

    public String getMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    private void addToBuffer(String message) {
        messageBuffer.append(message);
    }

    @Override
    public void boardCreatedMessage(CreateBoardResponse response) {
        message = addNewLine(String.format("%s versions of board created.", response.versions[0]));
        addToBuffer(message);
    }

    @Override
    public void availableBoardsMessage(CreateBoardResponse response) {
        message = addNewLine(String.format("Available boards: %s", response.versions[0]));
        addToBuffer(message);
    }

    @Override
    public void boardPromptMessage() {
        message = addNewLine("Select versions of board you would like to use.");
        addToBuffer(message);
    }

    @Override
    public void exceededPlayerLimitMessage() {
        message = addNewLine("Exceeded eight player limit.");
        addToBuffer(message);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        message = addNewLine(String.format("Player created with %s tokens.", response.tokens[0]));
        addToBuffer(message);
    }

    @Override
    public void playerPromptMessage() {
        message = addNewLine("Please select tokens for player.");
        addToBuffer(message);
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        message = addNewLine(String.format("%s tokens already in use.", response.tokens[0]));
        addToBuffer(message);
    }
}
