package game.manager;

public interface ControllerFactory {

    ManagerController make(String controller);
}
