package game.manager;

interface StateUI {

    void promptMessage(UIManager manager);

    void validUseCaseEntry(UIManager manager);

    void invalidEntry(UIManager manager);
}