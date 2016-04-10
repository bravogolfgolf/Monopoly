package interactors.createboard;

import interactors.BoardGateway;

public class BoardGatewayMock implements BoardGateway {

    private String version;

    public boolean VerifySetVersionMethodCalled = false;
    public boolean VerifyGetVersionMethodCalled = false;


    public void setVersion(String version) {
        VerifySetVersionMethodCalled = true;
        this.version = version;
    }

    public String getVersion() {
        VerifyGetVersionMethodCalled = true;
        return version;
    }
}
