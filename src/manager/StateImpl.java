package game.manager;

import java.io.IOException;

public enum StateImpl implements State {

    VERSION {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.promptMessage("SelectVersion");

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Versions");

            manager.createController("SelectVersion");
            manager.setViewManager();
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

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
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

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
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

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

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
            manager.promptMessage("CreatePlayer_3");

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

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
            manager.promptMessage("CreatePlayer_4");

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

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
            manager.promptMessage("CreatePlayer_5");

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

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
            manager.promptMessage("CreatePlayer_6");

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

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
            manager.promptMessage("CreatePlayer_7");

            manager.createController("Options");
            manager.setViewManager();
            manager.callHandleOnController("Tokens");

            manager.createController("CreatePlayer");
            manager.setViewManager();
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.setViewManager();
            manager.callHandleOnController("");

            manager.initialize();
        }
    },

    GAME_OVER {
        @Override
        public void initialize(StateManager manager) throws IOException {

        }

        @Override
        public void validNumber(StateManager manager) {

        }

        @Override
        public void validTextEntry(StateManager manager) {

        }
    }
}
