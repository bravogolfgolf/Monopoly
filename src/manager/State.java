package game.manager;

interface State {

    void validNumberEntered(ManagerImpl manager);

    void invalidNumberEntered(ManagerImpl manager);
}