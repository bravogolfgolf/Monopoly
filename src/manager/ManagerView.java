package game.manager;

import game.view.ViewManager;

import java.io.IOException;

public interface ManagerView {

    void setManager(ViewManager manager);

    void read() throws IOException;
}
