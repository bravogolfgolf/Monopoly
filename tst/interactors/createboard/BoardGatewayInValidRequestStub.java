package game.interactors.createboard;

public class BoardGatewayInValidRequestStub extends BoardGatewayMock {
    @Override
    public void create(String version) {
        super.create("");
        throw new IllegalArgumentException();
    }

    @Override
    public String[] getAvailableBoards() {
        super.getAvailableBoards();
        return new String[]{"USA"};
    }

    @Override
    public boolean isAvailable(String version) {
        super.isAvailable(version);
        return false;
    }
}
