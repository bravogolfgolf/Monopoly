package game.view;

import java.io.IOException;

class ConsoleValidInputMock implements Console {

    boolean verifyWriteCalled = false;

    @Override
    public String read() throws IOException {
        return "1";
    }

    @Override
    public void write(String text) throws IOException {
        verifyWriteCalled = true;
    }
}
