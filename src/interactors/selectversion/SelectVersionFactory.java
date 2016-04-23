package game.interactors.selectversion;

public interface SelectVersionFactory {

    void make(String version);

    String[] getAvailableVersions();
}
