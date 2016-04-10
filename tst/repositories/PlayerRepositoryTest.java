package repositories;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayerRepositoryTest {
    private final PlayerRepository repository = new PlayerRepository();

    @Test
    public void testCreatePlayer() {
        assertTrue(repositoryIsEmpty());
        repository.create("Test");
        assertTrue(repositoryHasOnePlayer());
        repository.create("Test");
        assertTrue(duplicatePlayerNotCreated());
    }

    private boolean repositoryIsEmpty() {
        return repository.count() == 0;
    }

    private boolean repositoryHasOnePlayer() {
        return repository.count() == 1;
    }

    private boolean duplicatePlayerNotCreated() {
        return repository.count() == 1;
    }
}