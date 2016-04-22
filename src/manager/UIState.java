package game.manager;

interface UIState {

    void initialize(UIManager manager);

    void validNumber(UIManager manager);

    void validTextEntry(UIManager manager);

    void invalidEntry(UIManager manager);
}