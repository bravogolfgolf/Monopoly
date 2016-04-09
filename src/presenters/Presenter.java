package presenters;

import usecases.Response;

import java.io.IOException;

public interface Presenter {
    void present(Response response) throws IOException;
}
