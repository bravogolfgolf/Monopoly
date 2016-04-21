package game.view;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class SetupGameViewTest {

    private final SetupGameManagerMock manager = new SetupGameManagerMock();
    private final Controller controller = new ControllerImplDummy();
    private final Map<Integer, String> menuMap = new HashMap<Integer, String>() {{
        put(1, "USA");
    }};

    public class ValidInput {

        private final ConsoleValidInputMock console = new ConsoleValidInputMock();
        private final SetupGameView view = new SetupGameView(console, manager);


        @Before
        public void setUp() {
            view.setMap(menuMap);
            view.setController(controller);
        }

        @Test
        public void testUserInterfacePrompt() {
            view.userInterfacePrompt();
            assertTrue(manager.verifyPromptMessageCalled);
        }

        @Test
        public void testWrite() throws IOException {
            view.write("");
            assertTrue(console.verifyWriteCalled);
        }

        @Test
        public void testRead() throws IOException {
            view.read();
            assertTrue(manager.verifyValidEntryCalled);
        }
    }

    public class InvalidInput {

        private final ConsoleInvalidInputMock console = new ConsoleInvalidInputMock();
        private final SetupGameView view = new SetupGameView(console, manager);

        @Before
        public void setUp() {
            view.setMap(menuMap);
            view.setController(controller);
        }

        @Test
        public void testRead() throws IOException {
            view.read();
            assertTrue(manager.verifyInvalidEntryCalled);
        }
    }
}