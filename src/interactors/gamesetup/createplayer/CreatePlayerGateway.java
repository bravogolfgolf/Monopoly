package game.interactors.gamesetup.createplayer;

public interface CreatePlayerGateway {

    boolean create(String request);

    String[] getAvailableTokens();
}
