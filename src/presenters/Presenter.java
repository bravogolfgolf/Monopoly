package presenters;

import interactors.Response;

import java.io.IOException;

public interface Presenter {
    void present(Response response) throws IOException;
}
