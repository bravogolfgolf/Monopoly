package game.usecases;

import game.controllers.View;

import java.io.IOException;

class ConsoleMock extends View {

    private final StringBuffer stringBuffer = new StringBuffer();

    @Override
    public String input() throws IOException {
        return null;
    }

    @Override
    public void output(String text) throws IOException {
        stringBuffer.append(text);
    }

    boolean VerifyOutputMethodCalled(String expected) {
        return stringBuffer.toString().equals(expected);
    }
}
