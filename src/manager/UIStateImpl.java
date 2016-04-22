package game.manager;

import java.io.IOException;

public enum UIStateImpl implements UIState {

    SETUP_GAME {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(SETUP_GAME);
            manager.createController("SetupGame");
            manager.setViewManager();
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_0);
            manager.initialize();
        }
    },

    CREATE_PLAYER_0 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_0);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_1);
            manager.initialize();
        }
    },

    CREATE_PLAYER_1 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_1);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_2);
            manager.initialize();

        }
    },

    CREATE_PLAYER_2 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_2);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) {
            manager.setUiState(NEXT);
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_3);
            manager.initialize();
        }
    },

    CREATE_PLAYER_3 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_3);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) {
            manager.setUiState(NEXT);
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_4);
            manager.initialize();
        }
    },

    CREATE_PLAYER_4 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_4);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) {
            manager.setUiState(NEXT);
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_5);
            manager.initialize();
        }
    },

    CREATE_PLAYER_5 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_5);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) {
            manager.setUiState(NEXT);
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_6);
            manager.initialize();
        }
    },

    CREATE_PLAYER_6 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_6);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) {
            manager.setUiState(NEXT);
        }

        @Override
        public void validTextEntry(UIManager manager) throws IOException {
            manager.setUiState(CREATE_PLAYER_7);
            manager.initialize();
        }
    },

    CREATE_PLAYER_7 {
        @Override
        public void initialize(UIManager manager) throws IOException {
            manager.promptMessage(CREATE_PLAYER_7);
            manager.createController("CreatePlayer");
            manager.setViewController();
            manager.executeController();
            manager.readView();
        }

        @Override
        public void validNumber(UIManager manager) {
            manager.setUiState(NEXT);
        }

        @Override
        public void validTextEntry(UIManager manager) {
            manager.setUiState(NEXT);
        }
    },

    NEXT {
        @Override
        public void initialize(UIManager manager) {

        }

        @Override
        public void validNumber(UIManager manager) {

        }

        @Override
        public void validTextEntry(UIManager manager) {

        }
    }
}
