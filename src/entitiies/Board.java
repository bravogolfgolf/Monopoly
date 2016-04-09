package entitiies;

import main.BoardGateway;

public final class Board extends BoardGateway {
    private static String version;

    public void setVersion(String version) {
        Board.version = version;
    }

    public String getVersion() {
        return version;
    }
}