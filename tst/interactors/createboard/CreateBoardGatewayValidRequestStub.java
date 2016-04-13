package game.interactors.createboard;

class CreateBoardGatewayValidRequestStub extends CreateBoardGatewayMock {

    @Override
    public void create(String version) {
        super.create("USA");
    }

    @Override
    public String[] getAvailableBoards() {
        super.getAvailableBoards();
        return new String[]{"USA"};
    }

    @Override
    public boolean isAvailable(String version) {
        super.isAvailable(version);
        return true;
    }

}
