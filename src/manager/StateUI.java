package game.manager;

interface StateUI {

    void promptMessage(ManagerUI manager);

    void validUseCaseEntry(ManagerUI manager);

    void invalidEntry(ManagerUI manager);
}