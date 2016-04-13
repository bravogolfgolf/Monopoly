package game.interactors.createplayer;

public abstract class CreatePlayerGateway {

    static final int PLAYER_LIMIT = 8;

    public abstract boolean create(String token);

    public abstract int count();

}
