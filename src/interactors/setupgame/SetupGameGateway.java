package game.interactors.setupgame;

public interface SetupGameGateway {
    void create(String version);

    String[] getAvailableBoards();

    boolean isAvailable(String version);
}
