package game.entities;

import org.junit.Test;

import static game.entities.Token.TransactionType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TokenTest {

    private static final int PROPERTY_THAT_COST_200 = 200;
    private final Token token = new Token("Cat");

    @Test
    public void createToken() {
        assertTrue("Cat".equals(token.getDescription()));
        assertEquals(0, token.spaceID);
        assertEquals(1500, token.cashBalance());
        assertEquals(1500, token.netWorth());
        assertEquals(false, token.turnState.passedGO);
    }

    @Test
    public void RECIEVE_CASH() {
        token.transaction(200, RECIEVE_CASH);
        assertEquals(1700, token.cashBalance());
        assertEquals(1700, token.netWorth());
    }

    @Test
    public void PAY_CASH() {
        token.transaction(200, PAY_CASH);
        assertEquals(1300, token.cashBalance());
        assertEquals(1300, token.netWorth());
    }


    @Test
    public void BUY_PROPERTY() {
        token.transaction(PROPERTY_THAT_COST_200, BUY_PROPERTY);
        assertEquals(1300, token.cashBalance());
        assertEquals(1600, token.netWorth());
    }

    @Test
    public void MORTGAGE_PROPERTY() {
        token.transaction(PROPERTY_THAT_COST_200, MORTGAGE_PROPERTY);
        assertEquals(1600, token.cashBalance());
        assertEquals(1500, token.netWorth());
    }

    @Test
    public void UN_MORTGAGE_PROPERTY() {
        token.transaction(PROPERTY_THAT_COST_200, UN_MORTGAGE_PROPERTY);
        assertEquals(1390, token.cashBalance());
        assertEquals(1500, token.netWorth());
    }
}

