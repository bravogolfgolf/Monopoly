package game.manager;

class CreatePlayerManagerFake extends CreatePlayerManager {

    boolean addCommandBackToListCalled = false;
    boolean addNextCommandToList = false;

    CreatePlayerManagerFake(State state, ControllerFactory factory) {
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
