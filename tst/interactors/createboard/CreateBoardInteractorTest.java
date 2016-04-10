package interactors.createboard;

import controllers.Interactor;
import org.junit.Before;
import org.junit.Test;
import utilities.StringFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateBoardInteractorTest {

    private CreateBoardPresenterMock presenter;
    private BoardGatewayMock gateway;
    private Interactor interactor;
    private CreateBoardRequest request;
    private String expected;

    @Before
    public void setUp() {
        presenter = new CreateBoardPresenterMock();
        gateway = new BoardGatewayMock();
        interactor = new CreateBoardInteractor(presenter, gateway);
        request = new CreateBoardRequest();
    }

    @Test
    public void testCreateBoardInteractor() {
        expected = StringFormatter.addNewLine("TEST version of board created.");

        request.version = "TEST";
        interactor.handle(request);

        assertTrue(gateway.VerifySetVersionMethodCalled);
        assertTrue(gateway.VerifyGetVersionMethodCalled);
        assertTrue(presenter.VerifyPresentMethodCalled);
        assertEquals(expected,presenter.getViewRequest());
    }

    @Test
    public void testNullReturnsPrompt() {
        expected = StringFormatter.addNewLine("Select version of board you would like to use.");
        request.version = null;
        interactor.handle(request);
        assertTrue(presenter.VerifyPresentMethodCalled);
        assertEquals(expected,presenter.getViewRequest());
    }
}
