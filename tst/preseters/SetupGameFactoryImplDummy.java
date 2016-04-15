package game.preseters;

import game.factories.SetupGameBoardGateway;
import game.factories.SetupGameFactoryImpl;
import game.factories.SetupGamePlayerGateway;

class SetupGameFactoryImplDummy extends SetupGameFactoryImpl {
    SetupGameFactoryImplDummy(SetupGameBoardGateway board, SetupGamePlayerGateway player) {
        super(board, player);
    }
}
