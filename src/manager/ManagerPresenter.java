package game.manager;

public interface ManagerPresenter {
    void selectVersionPromptMessage();

    void createPlayerPromptMessageFewerThanTwo();

    void createPlayerPromptMessageTwoOrMore();

    void startTurn();
}
