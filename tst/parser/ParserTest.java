package game.parser;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import game.doubles.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class ParserTest {

    private final Parser parser = new Parser();
    private final ConsoleMock console = new ConsoleMock(parser);
    private final PresenterMock presenter = new PresenterMock(console, parser);
    private final VersionFactoryMock versionFactory = new VersionFactoryMock();
    private final PlayersMock players = new PlayersMock();
    private final InteractorFactoryMock interactorFactory = new InteractorFactoryMock(presenter, versionFactory);
    private final ControllerFactoryDummy factory = new ControllerFactoryDummy(presenter, versionFactory, interactorFactory, players, console);
    private final StateManagerMock manager = new StateManagerMock(factory);
    private Map<Integer, String> menuMap;

    public class MapWithValesExpectedTest {

        @Before
        public void setUp() {
            menuMap = new HashMap<Integer, String>() {{
                put(1, "Valid");
            }};
            parser.setMap(menuMap);
            parser.setManager(manager);
        }

        @Test
        public void testInvalidEntry() throws IOException {
            parser.parse("a");
            assertTrue(manager.verifyInvalidEntryCalled);
        }

        @Test
        public void testZeroEntered() throws IOException {
            parser.parse("0");
            assertTrue(manager.verifyZeroEnteredCalled);
        }

        @Test
        public void testValidUseCaseEntry() throws IOException {
            parser.parse("1");
            assertTrue(manager.validUseCaseEntryCalled);
        }

        @Test
        public void testTwoEntered() throws IOException {
            parser.parse("2");
            assertTrue(manager.verifyTwoEnteredCalled);
        }

        @Test
        public void testThreeEntered() throws IOException {
            parser.parse("3");
            assertTrue(manager.verifyInvalidEntryCalled);
        }
    }

    public class MapWithoutValesExpectedTest {

        @Before
        public void setUp() {
            menuMap = new HashMap<>();
            parser.setMap(menuMap);
            parser.setManager(manager);
        }

        @Test
        public void testInvalidEntry() throws IOException {
            parser.parse("a");
            assertTrue(manager.verifyInvalidEntryCalled);
        }

        @Test
        public void testZeroEntered() throws IOException {
            parser.parse("0");
            assertTrue(manager.verifyZeroEnteredCalled);
        }

        @Test
        public void testOneEntered() throws IOException {
            parser.parse("1");
            assertTrue(manager.verifyOneEnteredCalled);
        }

        @Test
        public void testTwoEntered() throws IOException {
            parser.parse("2");
            assertTrue(manager.verifyTwoEnteredCalled);
        }

        @Test
        public void testThreeEntered() throws IOException {
            parser.parse("3");
            assertTrue(manager.verifyInvalidEntryCalled);
        }
    }
}
