package interactors;

import java.io.IOException;

public interface Interactor {
    void handle(Request inputRequest) throws IOException;
}
