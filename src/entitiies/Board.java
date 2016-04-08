package entitiies;

public final class Board {
    private static String version;

    public static void setVersion(String version) {
        Board.version = version;
    }

    public static String getVersion() {
        return version;
    }
}