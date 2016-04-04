package usecase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddPlayerTest {

    @Test
    public void testAddPayer() {
        AddPlayerPresenterSpy p = new AddPlayerPresenterSpy();
        AddPlayerInteractor ip = new AddPlayer(p);
        AddPlayerRequest request = new AddPlayerRequest();
        request.token = "Cat";
        ip.addPlayer(request);
        assertEquals("Cat", p.getIntendedResponse().token);
    }
}
