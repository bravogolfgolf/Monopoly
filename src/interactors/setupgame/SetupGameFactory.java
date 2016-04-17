package game.interactors.setupgame;

public interface SetupGameFactory {

    void make(String version);

    String[] getAvailableVersions();
}
