package game.factories;

import game.entitiies.Board;

class BoardMock extends Board {
    boolean verifySetVersionCalled = false;

    @Override
    public void setVersion(String version) {
        verifySetVersionCalled = true;
        super.setVersion(version);
    }
}
