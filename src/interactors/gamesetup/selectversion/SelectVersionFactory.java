package game.interactors.gamesetup.selectversion;

public interface SelectVersionFactory {

    void make(String version);

    String[] getAvailableVersions();
}
