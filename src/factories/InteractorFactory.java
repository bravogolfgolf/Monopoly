package game.factories;

import game.entities.Banker;
import game.interactors.Interactor;
import game.interactors.movetoken.MoveToken;
import game.interactors.partneroptions.PartnerOptions;
import game.interactors.passgo.PassGo;
import game.interactors.propertyoptions.PropertyOptions;
import game.interactors.rolldice.RollDice;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.tokenoptions.TokenOptionsFewerThanMinimum;
import game.interactors.tokenoptions.TokenOptionsMinimumToMaximum;
import game.interactors.versionoptions.VersionOptions;
import game.manager.StateManager;
import game.presenters.Presenter;

import static game.Context.*;

public class InteractorFactory implements ControllerFactoryInteractorFactory {

    private final Presenter presenter;
    private final VersionFactory factory;
    private final Banker banker;
    private final StateManager manager;

    public InteractorFactory(Presenter presenter, VersionFactory factory, Banker banker, StateManager manager) {
        this.presenter = presenter;
        this.factory = factory;
        this.banker = banker;
        this.manager = manager;
    }

    public Interactor make(String type) {
        if (type.equals("VersionOptions"))
            return new VersionOptions(presenter, factory);

        if (type.equals("TokenOptionsFewerThanMinimum"))
            return new TokenOptionsFewerThanMinimum(presenter, tokens, players, board);

        if (type.equals("TokenOptionsMinimumToMaximum"))
            return new TokenOptionsMinimumToMaximum(presenter, tokens, players, board);

        if (type.equals("Message"))
            return new SelectFirst(presenter, players);

        if (type.equals("RollDice"))
            return new RollDice(presenter, manager);

        if (type.equals("MoveToken"))
            return new MoveToken(board, manager);

        if (type.equals("PassGo"))
            return new PassGo(presenter, banker, board);

        if (type.equals("PropertyOptions"))
            return new PropertyOptions(presenter);

        if (type.equals("PartnerOptions"))
            return new PartnerOptions(presenter, players);

        throw new IllegalArgumentException();
    }
}
