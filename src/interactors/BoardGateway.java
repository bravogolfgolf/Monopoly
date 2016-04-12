package game.interactors;

public interface BoardGateway {
    void create(String version);

    String[] getAvailableBoards();

    boolean isAvailable(String version);
}
