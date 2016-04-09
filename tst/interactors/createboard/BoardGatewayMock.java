package interactors.createboard;

import main.BoardGateway;

public class BoardGatewayMock extends BoardGateway {
    public boolean VerifySetVersionMethodCalled = false;
    public boolean VerifyGetVersionMethodCalled = false;

    @Override
    public void setVersion(String version) {
        VerifySetVersionMethodCalled = true;
    }

    @Override
    public String getVersion() {
        VerifyGetVersionMethodCalled = true;
        return null;
    }
}
