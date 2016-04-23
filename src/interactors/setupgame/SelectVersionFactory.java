package game.interactors.setupgame;

public interface SelectVersionFactory {

    void make(String version);

    String[] getAvailableVersions();
}
