package game.parser;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ParserTest {

    private final StateManagerMock manager = new StateManagerMock();
    private final Parser parser = new Parser();
    private final Map<Integer, String> menuMap = new HashMap<Integer, String>() {{
        put(1, "Valid");
    }};

    @Before
    public void setUp() {
        parser.setMap(menuMap);
        parser.setManager(manager);
    }

    @Test
    public void testValidUseCaseEntry() throws IOException {
        parser.parse("1");
        assertTrue(manager.validUseCaseEntryCalled);
    }

    @Test
    public void testZeroEntered() throws IOException {
        parser.parse("0");
        assertTrue(manager.verifyZeroEnteredCalled);
    }

    @Test
    public void testInvalidEntry() throws IOException {
        parser.parse("a");
        assertTrue(manager.verifyInvalidEntryCalled);
    }
}

