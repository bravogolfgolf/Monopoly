package entitiies;

import interactors.BoardGateway;

public final class Board implements BoardGateway {
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}