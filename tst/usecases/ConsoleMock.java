package game.usecases;

import game.controllers.View;

import java.io.IOException;

class ConsoleMock extends View {

    private final StringBuffer stringBuffer = new StringBuffer();

    @Override
    public String read() throws IOException {
        return null;
    }

    @Override
    public void write(String text) throws IOException {
        stringBuffer.append(text);
    }

    boolean VerifyOutputMethodCalled(String expected) {
        return stringBuffer.toString().equals(expected);
    }
}
