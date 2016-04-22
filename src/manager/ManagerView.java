package game.manager;

import game.view.Manager;

import java.io.IOException;

public interface ManagerView {
    void setManager(Manager manager);

    void read() throws IOException;
}
