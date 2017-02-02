package game.interactors.versionoptions;

public interface VersionOptionsVersionFactory {

    void make(String version);

    String[] getAvailableVersions();
}
