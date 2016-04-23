package game.view;

import java.io.IOException;

class ConsoleInvalidInputMock implements ViewConsole {

    @Override
    public String read() throws IOException {
        return "a";
    }

    @Override
    public void write(String text) throws IOException {

    }
}
