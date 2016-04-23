package game.presenters;

import game.interactors.InteractorResponse;
import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PresenterEnTest {

    private final PresenterEn presenter = new PresenterEn();
    private final InteractorResponse response = new InteractorResponse();
    private String expected;

    @Test
    public void testGetMenuMap() {
        response.options = new String[]{"FRA", "USA"};
        presenter.userInterfaceOptionsMessage(response);
        Map<Integer, String> map = new Hashtable<Integer, String>() {{
            put(1, "FRA");
            put(2, "USA");
        }};
        assertEquals(map, presenter.getMenuMap());
    }

    @Test
    public void testSelectVersionPromptMessage() {
        presenter.selectVersionPromptMessage();
        expected = "Select version of game you would like to play.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testAvailableVersionsMessage() {
        response.options = new String[]{"FRA", "USA"};
        presenter.availableVersionsMessage(response);
        expected = "Available versions: (1)FRA, (2)USA\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testVersionCreatedMessage() {
        response.options = new String[]{"USA"};
        presenter.versionCreatedMessage(response);
        expected = "USA version of game created.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testCreatePlayerPromptMessageFewerThanTwo() {
        presenter.createPlayerPromptMessageFewerThanTwo();
        expected = "Please select token for player. (Players 2 - 8)\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testCreatePlayerPromptMessageTwoOrMore() {
        presenter.createPlayerPromptMessageTwoOrMore();
        expected = "Please select token for player or 0 to begin play. (Players 2 - 8)\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testAvailableTokensMessage() {
        response.options = new String[]{"Automobile", "Battleship", "Boot", "Cat", "Scottish Terrier", "Thimble", "Top Hat", "Wheelbarrow"};
        presenter.availableTokensMessage(response);
        expected = "Available tokens: (1)Automobile, (2)Battleship, (3)Boot, (4)Cat, (5)Scottish Terrier, (6)Thimble, (7)Top Hat, (8)Wheelbarrow\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testPlayerCreatedMessage() {
        response.options = new String[]{"Cat"};
        presenter.playerCreatedMessage(response);
        expected = "Player created with Cat token.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

    @Test
    public void testPlayerSelectedToGoFirstMessage() {
        response.token = "Cat";
        presenter.playerSelectedToGoFirstMessage(response);
        expected = "Cat selected to go first.\n";
        assertEquals(expected, presenter.getFormattedMessage());
    }

}