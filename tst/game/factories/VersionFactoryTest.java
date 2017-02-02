package game.factories;

import game.interactors.versionoptions.VersionOptionsVersionFactory;
import org.junit.Test;

public class VersionFactoryTest {

    private final VersionOptionsVersionFactory factory = new VersionFactory();

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
