package interactors.createplayer;

import interactors.Interactor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreatePlayerInteractorTest {

    @Test
    public void testCreatePlayerInteractor() {
        PlayerRepositoryMock gateway = new PlayerRepositoryMock();
        CreatePlayerPresenterMock presenter = new CreatePlayerPresenterMock();
        Interactor interactor = new CreatePlayerInteractor(presenter, gateway);
        CreatePlayerRequest request = new CreatePlayerRequest();
        request.token = "";
        interactor.handle(request);
        assertTrue(gateway.VerifySaveMethodCalled);
        assertTrue(gateway.VerifyCountMethodCalled);
        assertTrue(presenter.VerifyPresentMethodCalled);
    }
}
