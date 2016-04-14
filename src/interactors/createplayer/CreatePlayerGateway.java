package game.interactors.createplayer;

public interface CreatePlayerGateway {
    boolean create(String token);

    boolean playerLimitExceeded();
}
