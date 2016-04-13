package game.entitiies;

import game.BoardGateway;
import game.factories.SetupGameBoardGateway;

public final class Board implements BoardGateway, SetupGameBoardGateway {
    @SuppressWarnings("unused")
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }
}