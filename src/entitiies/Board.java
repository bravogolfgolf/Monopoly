package game.entitiies;

import game.factories.SetupGameBoardGateway;

public class Board implements SetupGameBoardGateway {
    @SuppressWarnings("unused")
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }
}