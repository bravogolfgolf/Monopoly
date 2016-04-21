package game.manager;

public enum StateImpl implements StateUI {

    SETUP_GAME {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(SETUP_GAME);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_0);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_0);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(SETUP_GAME);
            manager.addNextCommandToList("SetupGame", SETUP_GAME);
        }
    },

    CREATE_PLAYER_0 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_0);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_1);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_1);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_0);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_0);
        }
    },

    CREATE_PLAYER_1 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_1);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_2);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_2);

        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_1);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_1);
        }
    },

    CREATE_PLAYER_2 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_2);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_3);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_3);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_2);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_2);
        }
    },

    CREATE_PLAYER_3 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_3);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_4);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_4);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_3);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_3);
        }
    },

    CREATE_PLAYER_4 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_4);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_5);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_5);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_4);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_4);
        }
    },

    CREATE_PLAYER_5 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_5);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_6);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_6);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_5);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_5);
        }
    },

    CREATE_PLAYER_6 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_6);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_7);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_7);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_6);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_6);
        }
    },

    CREATE_PLAYER_7 {
        @Override
        public void promptMessage(UIManager manager) {
            manager.promptMessage(CREATE_PLAYER_7);
        }

        @Override
        public void validUseCaseEntry(UIManager manager) {
            manager.setStateUI(NEXT);
//            manager.addNextCommandToList("Next",NEXT);
        }

        @Override
        public void invalidEntry(UIManager manager) {
            manager.setStateUI(CREATE_PLAYER_7);
            manager.addNextCommandToList("CreatePlayer", CREATE_PLAYER_7);
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
