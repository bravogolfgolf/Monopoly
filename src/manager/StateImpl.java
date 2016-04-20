package game.manager;

public enum StateImpl implements State {

    SETUP_GAME {
        @Override
        public void validNumberEntered(ManagerImpl manager) {
            manager.setState(CREATE_PLAYER);
            manager.addNextCommandToList();
        }

        @Override
        public void invalidNumberEntered(ManagerImpl manager) {
            manager.setState(SETUP_GAME);
            manager.addCommandBackToList();
        }
    },

    CREATE_PLAYER {
        @Override
        public void validNumberEntered(ManagerImpl manager) {

        }

        @Override
        public void invalidNumberEntered(ManagerImpl manager) {
            manager.setState(CREATE_PLAYER);
            manager.addCommandBackToList();
        }
    }
}
