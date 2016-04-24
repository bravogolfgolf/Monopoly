package game.interactors.createplayer;

import game.entities.Token;

public interface CreatePlayerGateway {

    void create(Token request);

    Token getPlayer(Token request);
}
