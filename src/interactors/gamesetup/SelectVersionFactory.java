package game.interactors.gamesetup;

public interface SelectVersionFactory {

    void make(String version);

    String[] getAvailableVersions();
}
