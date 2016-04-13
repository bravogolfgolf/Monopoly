package game.interactors.setupgame;

public interface SetupGameFactory {
    void make(String version);

    String[] getAvailableBoards();

    boolean isAvailable(String version);
}
