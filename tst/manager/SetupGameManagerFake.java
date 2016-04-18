package game.manager;

class SetupGameManagerFake extends SetupGameManager {

    boolean addCommandBackToListCalled = false;
    boolean addNextCommandToList = false;

    SetupGameManagerFake(State state, ControllerFactory factory) {
        super(state, factory);
    }

    @Override
    public void addCommandBackToList() {
        addCommandBackToListCalled = true;
        super.addCommandBackToList();
    }

    @Override
    public void addNextCommandToList() {
        addNextCommandToList = true;
        super.addNextCommandToList();
    }
}

