package pkg.board;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceFactoryTest {

    @Test
    public void testReadOfSpaceDefinitionFile() throws IOException {
        List<Space> expected = new ArrayList<>();
        List<Space> actual;
        expected.add(SpaceFactory.create("FreeParking", "Description"));
        expected.add(SpaceFactory.create("RealEstate", "Description", "Group", 78, 3, -1, -2, -3, -4, -5));
        actual = SpaceFactory.load("TEST");
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.equals(actual));
        for (int index = 0; index < expected.size(); index++) {
            assertTrue(expected.get(index).equals(actual.get(index)));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceNonPropertyThrowsException() throws IllegalArgumentException {
        SpaceFactory.create("Invalid", "Invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceUtilityThrowsException() throws IllegalArgumentException {
        SpaceFactory.create("Invalid", "Invalid", "Invalid", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceRailroadThrowsException() throws IllegalArgumentException {
        SpaceFactory.create("Invalid", "Invalid", "Invalid", -1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceRealEstateThrowsException() throws IllegalArgumentException {
        SpaceFactory.create("Invalid", "Invalid", "Invalid", -1, -1, -1, -1, -1, -1, -1);
    }
}
