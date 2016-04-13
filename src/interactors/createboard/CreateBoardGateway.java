package game.interactors.createboard;

public interface CreateBoardGateway {
    void create(String version);

    String[] getAvailableBoards();

    boolean isAvailable(String version);
}
