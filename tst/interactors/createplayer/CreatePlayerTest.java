package game.interactors.createplayer;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.PresenterEnMock;
import game.repositories.PlayerRepositoryImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CreatePlayerTest {

    private final Set<PlayerRepositoryImpl.Player.Token> tokens = new LinkedHashSet<>(Arrays.asList(new PlayerRepositoryImpl.Player.Token("Wheelbarrow"), new PlayerRepositoryImpl.Player.Token("Battleship"), new PlayerRepositoryImpl.Player.Token("Scottish Terrier"), new PlayerRepositoryImpl.Player.Token("Top Hat"), new PlayerRepositoryImpl.Player.Token("Cat"), new PlayerRepositoryImpl.Player.Token("Thimble"), new PlayerRepositoryImpl.Player.Token("Boot"), new PlayerRepositoryImpl.Player.Token("Automobile")));
    private final CreatePlayerRepositoryFake player = new CreatePlayerRepositoryFake(tokens);
    private final PresenterEnMock presenter = new PresenterEnMock();
    private final Interactor interactor = new CreatePlayer(presenter, player);
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
