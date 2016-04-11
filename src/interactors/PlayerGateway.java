package game.interactors;

public abstract class PlayerGateway {

    public static final int PLAYER_LIMIT = 8;

    public abstract boolean create(String token);

    public abstract int count();

}
