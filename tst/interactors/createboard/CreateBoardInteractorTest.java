package game.interactors.createboard;

import game.controllers.Interactor;
import game.interactors.PresenterEnMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateBoardInteractorTest {

    private PresenterEnMock presenter;
    private BoardGatewayMock gateway;
    private Interactor interactor;
    private CreateBoardRequest request;

    @Before
    public void setUp() {
        presenter = new PresenterEnMock();
        gateway = new BoardGatewayMock();
        interactor = new CreateBoardInteractor(presenter, gateway);
        request = new CreateBoardRequest();
    }

    @Test
    public void testPresentBoardCreatedMessage() {
        request.version = "TEST";
        interactor.handle(request);

        assertTrue(gateway.verifyCreateMethodCalled);
        assertTrue(presenter.verifyBoardCreateMessage);
    }

    @Test
    public void testPresentBoardPrompt() {
        request.version = null;
        interactor.handle(request);
        assertTrue(presenter.verifyBoardPromptMessage);
    }
}
