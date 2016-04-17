package game.interactors.createplayer;

import game.controllers.createPlayer.CreatePlayerInteractor;
import game.entitiies.Token;
import game.interactors.PresenterEnMock;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class CreatePlayerTest {

    private final Set<Token> tokens = new LinkedHashSet<>(Arrays.asList(new Token("Wheelbarrow"), new Token("Battleship"), new Token("Scottish Terrier"), new Token("Top Hat"), new Token("Cat"), new Token("Thimble"), new Token("Boot"), new Token("Automobile")));
    private final CreatePlayerRepositoryFake player = new CreatePlayerRepositoryFake(tokens);
    private final PresenterEnMock presenter = new PresenterEnMock();
    private final CreatePlayerInteractor interactor = new CreatePlayer(presenter, player);
    private final CreatePlayerRequest request = new CreatePlayerRequest();

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
