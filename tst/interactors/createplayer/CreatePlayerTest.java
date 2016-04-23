package game.interactors.createplayer;

import game.controllers.ControllerInteractor;
import game.entities.Players;
import game.interactors.InteractorRequest;
import game.interactors.gamesetup.PresenterEnMock;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {

    private final Set<Players.Player.Token> tokens = new LinkedHashSet<>(Arrays.asList(new Players.Player.Token("Wheelbarrow"), new Players.Player.Token("Battleship"), new Players.Player.Token("Scottish Terrier"), new Players.Player.Token("Top Hat"), new Players.Player.Token("Cat"), new Players.Player.Token("Thimble"), new Players.Player.Token("Boot"), new Players.Player.Token("Automobile")));
    private final CreatePlayerRepositoryFake player = new CreatePlayerRepositoryFake(tokens);
    private final PresenterEnMock presenter = new PresenterEnMock();
    private final ControllerInteractor interactor = new CreatePlayer(presenter, player);
    private final InteractorRequest request = new InteractorRequest();

    @Test
    public void testPlayerCreated() {
        request.string = "Cat";
        interactor.handle(request);

        assertTrue(player.verifyCreateCalled);
        assertTrue(presenter.verifyPlayerCreatedMessage);
    }

    @Test
    public void testUserInterfaceOptions() {
        interactor.userInterfaceOptions();

        assertTrue(player.verifyGetAvailableTokens);
        assertTrue(presenter.verifyAvailableTokensMessage);
    }
}
