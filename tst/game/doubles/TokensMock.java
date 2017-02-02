package game.doubles;

import game.entities.Token;
import game.repositories.Tokens;

import java.util.Set;
import java.util.TreeSet;

public class TokensMock extends Tokens {

    public boolean verifyCreateTokenCalled = false;
    public boolean verifyGetAvailableTokensCalled = false;

    public TokensMock(Set<Token> tokens) {
        super(tokens);
    }

    @Override
    public Token createToken(String text) {
        verifyCreateTokenCalled = true;
        return new Token("");
    }

    @Override
    public Set<Token> getAvailableTokens() {
        verifyGetAvailableTokensCalled = true;
        return new TreeSet<Token>() {{
            add(new Token("Cat"));
        }};
    }
}
