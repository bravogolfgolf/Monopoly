package pkg.board.infrastructure;

import org.junit.Test;
import pkg.board.domain.Space;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceFactoryFileTest {

    @Test
    public void testReadOfSpaceDefinitionFile() throws IOException {
        List<Space> expected = new ArrayList<>();
        List<Space> actual;
        expected.add(SpaceFactoryFile.create("FreeParking", "Description"));
        expected.add(SpaceFactoryFile.create("RealEstate", "Description", "Group", 78, 3, -1, -2, -3, -4, -5));
        expected.add(SpaceFactoryFile.create("Railroad", "Description", "Group", -1, -2));
        expected.add(SpaceFactoryFile.create("Utility", "Description", "Group", -1));
        actual = new SpaceFactoryFile().load("TEST");
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceNonPropertyThrowsException() throws IllegalArgumentException {
        SpaceFactoryFile.create("Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceUtilityThrowsException() throws IllegalArgumentException {
        SpaceFactoryFile.create("Invalid", "Invalid", "Invalid", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceRailroadThrowsException() throws IllegalArgumentException {
        SpaceFactoryFile.create("Invalid", "Invalid", "Invalid", -1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceRealEstateThrowsException() throws IllegalArgumentException {
        SpaceFactoryFile.create("Invalid", "Invalid", "Invalid", -1, -1, -1, -1, -1, -1, -1);
    }
}
