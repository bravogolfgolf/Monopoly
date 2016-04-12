package game.entitiies;

public interface BoardFactory {
    String make(String version);

    String[] getAvailableBoards();
}
