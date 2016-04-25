package game.interactors.tokenoptions;

import game.entities.Token;

import java.util.Set;

public interface TokenOptionsTokensGateway {

    Set<Token> getAvailableTokens();
}
