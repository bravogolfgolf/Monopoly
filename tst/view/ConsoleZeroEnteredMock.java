package game.view;

import java.io.IOException;

class ConsoleZeroEnteredMock implements ViewConsole {

    @Override
    public String read() throws IOException {
        return "0";
    }

    @Override
    public void write(String text) throws IOException {

    }
}
