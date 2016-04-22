package game.manager;

public enum UIStateImpl implements UIState {

    SETUP_GAME {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(SETUP_GAME);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_0);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(SETUP_GAME);
            manager.addCommandToStack("SetupGame");
        }
    },

    CREATE_PLAYER_0 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_0);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_1);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_0);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_1 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_1);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_2);
            manager.addCommandToStack("CreatePlayer");

        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_1);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_2 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_2);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_3);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_2);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_3 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_3);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_4);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_3);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_4 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_4);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_5);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_4);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_5 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_5);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_6);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_5);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_6 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_6);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_7);
            manager.addCommandToStack("CreatePlayer");
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_6);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    CREATE_PLAYER_7 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_7);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setUiState(NEXT);
//            manager.addCommandToStack("Next",NEXT);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setUiState(CREATE_PLAYER_7);
            manager.addCommandToStack("CreatePlayer");
        }
    },

    NEXT {
        @Override
        public void promptMessage(UIManager manager) {

        }

        @Override
        public void validUseCaseEntry(UIManager manager) {

        }

        @Override
        public void invalidEntry(UIManager manager) {

        }
    }
}
