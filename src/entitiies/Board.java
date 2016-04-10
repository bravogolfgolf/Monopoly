package entitiies;

import interactors.BoardGateway;

public final class Board implements BoardGateway {
    private static String version;

    public void setVersion(String version) {
        Board.version = version;
    }

    public String getVersion() {
        return version;
    }
}