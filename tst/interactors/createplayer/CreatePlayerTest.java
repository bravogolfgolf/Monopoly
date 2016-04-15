package game.interactors.createplayer;

import game.controllers.createPlayer.CreatePlayerInteractor;
import game.entitiies.Token;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class CreatePlayerTest {

    private final PresenterEnMock presenter = new PresenterEnMock();
    private final CreatePlayerRepositoryFake player = new CreatePlayerRepositoryFake();
    private final CreatePlayerInteractor interactor = new CreatePlayer(presenter, player);
    private final CreatePlayerRequest request = new CreatePlayerRequest();

    @Before
    public void setUp() {
        List<Token> tokens = new ArrayList<>();
        String[] tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        for (String token : tokenDescriptions) {
            tokens.add(new Token(token));
        }
        player.setTokens(tokens);
    }

    @Test
    public void testExceededPlayerLimit() {
        nineRequests();

        assertTrue(player.verifyPlayerLimitExceededCalled);
        assertTrue(player.verifyCreateCalled);
        assertTrue(player.verifyCreateCalledEightTimes);
        assertTrue(presenter.verifyExceededPlayerLimitMessage);
    }

    private void nineRequests() {
        String[] tokens = player.getAvailableTokens();
        for (String token : tokens) {
            request.token = token;
            interactor.handle(request);
        }
        interactor.handle(request);
    }

    @Test
    public void testPlayerCreated() {
        request.token = "Cat";
        interactor.handle(request);

        assertTrue(player.verifyPlayerLimitExceededCalled);
        assertTrue(player.verifyIsAvailableCalled);
        assertTrue(player.verifyCreateCalled);
        assertTrue(presenter.verifyPlayerCreatedMessage);
    }

    @Test
    public void testTokenInUse() {
        request.token = "InValid";
        interactor.handle(request);

        assertTrue(player.verifyPlayerLimitExceededCalled);
        assertTrue(player.verifyIsAvailableCalled);
        assertTrue(presenter.verifyTokenInUseMessage);
        assertTrue(presenter.verifyCreatePlayerPromptMessage);
        assertTrue(player.verifyGetAvailableTokensCalled);
        assertTrue(presenter.verifyAvailableTokensMessage);
    }
}
