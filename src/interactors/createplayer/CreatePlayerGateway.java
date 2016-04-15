package game.interactors.createplayer;

public interface CreatePlayerGateway {
    boolean create(String request);
    boolean playerLimitExceeded();
    String[] getAvailableTokens();
    boolean isAvailable(String token);
}
