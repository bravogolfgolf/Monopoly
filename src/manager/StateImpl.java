package game.manager;

import java.io.IOException;

public enum StateImpl implements State {

    SETUP_GAME {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.promptMessage("SelectVersion");
            manager.createController("SelectVersion");
            manager.setViewManager();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
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
            manager.promptMessage("CreatePlayer_0");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
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
            manager.promptMessage("CreatePlayer_1");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
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
            manager.promptMessage("CreatePlayer_2");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) {
            manager.setState(NEXT);
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
            manager.promptMessage("CreatePlayer_3");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) {
            manager.setState(NEXT);
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
            manager.promptMessage("CreatePlayer_4");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) {
            manager.setState(NEXT);
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
            manager.promptMessage("CreatePlayer_5");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) {
            manager.setState(NEXT);
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
            manager.promptMessage("CreatePlayer_6");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) {
            manager.setState(NEXT);
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
            manager.promptMessage("CreatePlayer_7");
            manager.createController("CreatePlayer");
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) {
            manager.setState(NEXT);
        }

        @Override
        public void validTextEntry(StateManager manager) {
            manager.setState(NEXT);
        }
    },

    NEXT {
        @Override
        public void initialize(StateManager manager) {

        }

        @Override
        public void validNumber(StateManager manager) {

        }

        @Override
        public void validTextEntry(StateManager manager) {

        }
    }
}
