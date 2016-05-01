package game.interactors.movetoken;

public interface MoveTokenPresenter {

    void rollMessage(MoveTokenResponse dice);

    void moveMessage(MoveTokenResponse response);
}