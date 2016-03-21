package pkg.monopoly;

class PlayerMockManagePropertiesCounter extends Player {

    int manageProperties = 0;

    PlayerMockManagePropertiesCounter() {
        super("PlayerMockManagePropertiesCounter");
    }

    @Override
    public void manageProperties() {
        manageProperties++;
    }
}