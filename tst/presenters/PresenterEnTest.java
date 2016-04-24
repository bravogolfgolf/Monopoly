package game.presenters;

import game.entities.Token;
import game.interactors.InteractorResponse;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class PresenterEnTest {

    private final PresenterEn presenter = new PresenterEn();
    private final InteractorResponse response = new InteractorResponse();
    private String expected;

    @Test
    public void testSelectVersionPromptMessage() {
        presenter.selectVersionPromptMessage();
        expected = "\nSelect version of game you would like to play.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testAvailableVersionsMessage() {
        response.versions = new String[]{"FRA", "USA"};
        presenter.availableVersionsMessage(response);
        expected = "Available versions: (1)FRA, (2)USA\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testVersionCreatedMessage() {
        response.version = "USA";
        presenter.versionCreatedMessage(response);
        expected = "\nUSA version of game created.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testCreatePlayerPromptMessageFewerThanTwo() {
        presenter.createPlayerPromptMessageFewerThanTwo();
        expected = "\nPlease select token for player. (Players 2 - 8)\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testCreatePlayerPromptMessageTwoOrMore() {
        presenter.createPlayerPromptMessageTwoOrMore();
        expected = "\nPlease select token for player or 0 to begin play. (Players 2 - 8)\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testAvailableTokensMessage() {
        response.tokens = new TreeSet<Token>() {{
            add(new Token("Automobile"));
            add(new Token("Battleship"));
            add(new Token("Boot"));
            add(new Token("Cat"));
            add(new Token("Scottish Terrier"));
            add(new Token("Thimble"));
            add(new Token("Top Hat"));
            add(new Token("Wheelbarrow"));
        }};
        presenter.availableTokensMessage(response);
        expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testPlayerCreatedMessage() {
        response.token = new Token("Cat");
        presenter.playerCreatedMessage(response);
        expected = "\nPlayer created with Cat token.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testPlayerSelectedToGoFirstMessage() {
        response.token = new Token("Cat");
        presenter.playerSelectedToGoFirstMessage(response);
        expected = "\nCat selected to go first.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

}