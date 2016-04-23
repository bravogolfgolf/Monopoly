package game.factories;

import game.interactors.gamesetup.selectversion.SelectVersionFactory;
import org.junit.Test;

public class SelectVersionFactoryTest {

    private final SelectVersionFactory factory = new SelectVersionFactoryImpl();

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
