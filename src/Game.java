import java.util.*;

public class Game {

    private List<Integer> properties = new ArrayList<Integer>(Arrays.asList(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 31, 33, 34, 35, 36, 37, 38, 39));

    private Player token;

    public int getBoardSize() {
        return properties.size();
    }

    public void addPlayer(Player player) {
        this.token = player;
    }

    public Player getPlayer() {
        return token;
    }
}
