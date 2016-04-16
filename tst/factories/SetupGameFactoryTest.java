package game.factories;

import game.interactors.setupgame.SetupGameFactory;
import org.junit.Test;

public class SetupGameFactoryTest {

    private final SetupGameFactory factory = new SetupGameFactoryImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testMakeException() {
        factory.make("");
    }

    @Test
    public void testMake() {
        String[] versions = factory.getAvailableVersions();
        for (String version : versions) {
            factory.make(version);
        }

    }
}
