package game.interactors.createplayer;

public interface CreatePlayerGateway {

    boolean create(String request);

    boolean playerLimitExceeded();

    String[] getAvailableTokens();
}
