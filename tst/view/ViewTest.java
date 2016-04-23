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
public class ViewTest {

    private final CreatePlayerManagerMock manager = new CreatePlayerManagerMock();
    private final Map<Integer, String> menuMap = new HashMap<Integer, String>() {{
        put(1, "Valid");
    }};

    public class ValidUseCaseInput {

        private final ConsoleValidUseCaseInputMock console = new ConsoleValidUseCaseInputMock();
        private final View view = new View(console);


        @Before
        public void setUp() {
            view.setMap(menuMap);
            view.setManager(manager);
        }

        @Test
        public void testWrite() throws IOException {
            view.write("");
            assertTrue(console.verifyWriteCalled);
        }

        @Test
        public void testRead() throws IOException {
            view.read();
            assertTrue(manager.validUseCaseEntryCalled);
        }
    }

    public class zeroEntered {

        private final ConsoleZeroEnteredMock console = new ConsoleZeroEnteredMock();
        private final View view = new View(console);

        @Before
        public void setUp() {
            view.setMap(menuMap);
            view.setManager(manager);
        }

        @Test
        public void testRead() throws IOException {
            view.read();
            assertTrue(manager.verifyZeroEnteredCalled);
        }
    }


    public class InvalidInput {

        private final ConsoleInvalidInputMock console = new ConsoleInvalidInputMock();
        private final View view = new View(console);

        @Before
        public void setUp() {
            view.setMap(menuMap);
            view.setManager(manager);
        }

        @Test
        public void testRead() throws IOException {
            view.read();
            assertTrue(manager.verifyInvalidEntryCalled);
        }
    }
}
