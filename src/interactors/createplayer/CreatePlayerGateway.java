package game.interactors.createplayer;

public interface CreatePlayerGateway {

    boolean create(String request);

    String[] getAvailableTokens();
}
