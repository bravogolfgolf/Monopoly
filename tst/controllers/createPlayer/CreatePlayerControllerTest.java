package game.controllers.createPlayer;

import game.Controller;
import game.controllers.ConsoleDummy;
import game.controllers.Presenter;
import game.controllers.PresenterEnDummy;
import game.controllers.View;
import game.entitiies.Token;
import game.interactors.createplayer.CreatePlayerGateway;
import game.repositories.PlayerRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CreatePlayerControllerTest {
    private final View view = new ConsoleDummy();
    private final Presenter presenter = new PresenterEnDummy();
    private final CreatePlayerGateway player = new PlayerRepositoryImpl();

    @Before
    public void setUp() {
        List<Token> tokens = new ArrayList<>();
        String[] tokenDescriptions = new String[]{"Wheelbarrow", "Battleship", "Scottish Terrier", "Top Hat", "Cat", "Thimble", "Boot", "Automobile"};
        for (String token : tokenDescriptions) {
            tokens.add(new Token(token));
        }
        ((PlayerRepositoryImpl) player).setTokens(tokens);
    }

    @Test
    public void testCreatePlayerControllerValidInput() throws IOException {
        CreatePlayerMock interactor = new CreatePlayerMock(presenter, player);
        Controller controller = new CreatePlayerControllerValidInputStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifyAvailableTokensMessage);
        assertTrue(interactor.verifyHandleCalled);
    }

    @Test
    public void testCreatePlayerControllerInValidInput() throws IOException {
        CreatePlayerMock interactor = new CreatePlayerMock(presenter, player);
        Controller controller = new CreatePlayerControllerInvalidInputStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.verifyCreatePlayerPrompt);
        assertTrue(interactor.verifyAvailableTokensMessage);
    }
}
