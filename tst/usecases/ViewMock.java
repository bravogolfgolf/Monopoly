package usecases;

import controllers.View;

import java.io.IOException;

public class ViewMock implements View {

    public boolean VerifyOutputMethodCalled = false;

    @Override
    public void output(String text) throws IOException {
        VerifyOutputMethodCalled = true;
    }
}
