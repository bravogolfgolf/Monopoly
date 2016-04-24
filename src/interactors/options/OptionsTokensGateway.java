package game.interactors.options;

import game.entities.Token;

import java.util.Set;

public interface OptionsTokensGateway {

    Set<Token> getAvailableTokens();
}
