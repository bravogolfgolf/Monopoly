package game.manager;

import java.io.IOException;

public enum StateImpl implements State {

    VERSION {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("VersionOptions");
            manager.createAndExecuteController("SelectVersion");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_0);
            manager.initialize();
        }
    },

    CREATE_PLAYER_0 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsFewerThanMinimum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_1);
            manager.initialize();
        }
    },

    CREATE_PLAYER_1 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsFewerThanMinimum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_2);
            manager.initialize();

        }
    },

    CREATE_PLAYER_2 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_3);
            manager.initialize();
        }
    },

    CREATE_PLAYER_3 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_4);
            manager.initialize();
        }
    },

    CREATE_PLAYER_4 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_5);
            manager.initialize();
        }
    },

    CREATE_PLAYER_5 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_6);
            manager.initialize();
        }
    },

    CREATE_PLAYER_6 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_7);
            manager.initialize();
        }
    },

    CREATE_PLAYER_7 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("TokenOptionsMinimumToMaximum");
            manager.createAndExecuteController("CreatePlayer");
        }

        @Override
        public void zeroEntered(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(START_TURN);
            manager.createAndExecuteController("SelectFirst");
            manager.initialize();
        }
    },

    START_TURN {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createAndExecuteController("StartTurn");
        }

        @Override
        public void zeroEntered(StateManager manager) {

        }

        @Override
        public void validTextEntry(StateManager manager) {

        }
    }
}
