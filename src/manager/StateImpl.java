package game.manager;

public enum StateImpl implements State {

    PROMPT {
        @Override
        public void validNumberEntered(ManagerImpl manager) {
            manager.setState(PROMPT);
            manager.addNextCommandToList();
        }

        @Override
        public void invalidNumberEntered(ManagerImpl manager) {
            manager.setState(PROMPT);
            manager.addCommandBackToList();
        }

        @Override
        public void invalidTextEntered(ManagerImpl manager) {
            manager.setState(PROMPT);
            manager.addCommandBackToList();
        }
    }
}
