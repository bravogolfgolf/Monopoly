package game.interactors.selectfirst;

import game.entities.Token;

public interface SelectFirstPlayerGateway {

    void randomizePlayers();

    Token getCurrentPlayer();
}
