package presenters;

import interactors.Response;

public interface Presenter {
    void present(Response response);

    String getResponse();
}
