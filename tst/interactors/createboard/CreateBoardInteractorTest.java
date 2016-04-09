package interactors.createboard;

import interactors.Interactor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateBoardInteractorTest {

    @Test
    public void testCreateBoardInteractor() {
        CreateBoardPresenterMock presenter = new CreateBoardPresenterMock();
        BoardGatewayMock gateway = new BoardGatewayMock();
        Interactor interactor = new CreateBoardInteractor(presenter, gateway);
        CreateBoardRequest request = new CreateBoardRequest();
        request.version = "";
        interactor.handle(request);
        assertTrue(gateway.VerifySetVersionMethodCalled);
        assertTrue(gateway.VerifyGetVersionMethodCalled);
        assertTrue(presenter.VerifyPresentMethodCalled);
    }
}
