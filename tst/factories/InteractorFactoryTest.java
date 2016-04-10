package factories;

import interactors.Interactor;
import main.Monopoly;
import org.junit.Test;

public class InteractorFactoryTest {

    private Interactor interactor;

    @Test(expected = IllegalArgumentException.class)
    public void testInteractorFactoryException() {
        Monopoly.interactorFactory.make("");
    }

    @Test
    public void testCreateInteractors() {
        interactor = Monopoly.interactorFactory.make("CreateBoardInteractor");
        interactor = Monopoly.interactorFactory.make("CreatePlayerInteractor");
    }
}
