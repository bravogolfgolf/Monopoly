package usecases;

import controllers.View;

import java.io.IOException;

public class ViewMock extends View {

    private final StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void output(String text) throws IOException {
        stringBuffer.append(text);
    }

    public boolean VerifyOutputMethodCalled(String expected) {
        return stringBuffer.toString().equals(expected);
    }
}
