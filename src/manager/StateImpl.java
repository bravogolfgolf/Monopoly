package game.manager;

import java.io.IOException;

public enum StateImpl implements State {

    VERSION {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("VersionOptions");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_0);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {
            manager.initialize();
        }
    },

    CREATE_PLAYER_0 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsFewerThanMinimum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_1);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_1 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsFewerThanMinimum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_2);
            manager.initialize();

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_2 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_3);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_3 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_4);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_4 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_5);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_5 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_6);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_6 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_7);
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    CREATE_PLAYER_7 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.createAndExecuteController("Message");
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    WHERE_TO_BEGIN_TURN {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.setState(NORMAL_TURN);
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {

        }
    },

    NORMAL_TURN {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("StartTurn");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(INITIAL_ROLL);
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {
            manager.setState(MANAGE);
            manager.initialize();
        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {
            manager.setState(TRADE);
            manager.initialize();
        }
    },

    INITIAL_ROLL {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("RollDice");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    NOT_ROLL_DOUBLE {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("MoveToken");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    ROLL_DOUBLE_1 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("MoveToken");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    ROLL_DOUBLE_2 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("MoveToken");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    PASS_GO {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("PaySalary");
            manager.setState(LAND_ON);
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    LAND_ON {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("LandOn");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) {

        }

        @Override
        public void twoEntered(StateManager manager) {

        }
    },

    LAND_ON_GO {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("PaySalary");
            manager.setState(END_TURN);
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {

        }
    },

    DRAW {
        @Override
        public void initialize(StateManager manager) throws IOException {

        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {

        }
    },

    PAY {
        @Override
        public void initialize(StateManager manager) throws IOException {

        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {

        }
    },

    JAIL {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("GoToJail");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {

        }
    },

    END_TURN {
        @Override
        public void initialize(StateManager manager) throws IOException {

        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {

        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {

        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {

        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {

        }
    },

    MANAGE {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("PropertyOptions");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {
            manager.initialize();
        }
    },

    TRADE {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("PartnerOptions");
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(WHERE_TO_BEGIN_TURN);
            manager.initialize();
        }

        @Override
        public void oneEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void twoEntered(StateManager manager) throws IOException {
            manager.initialize();
        }
    }
}
