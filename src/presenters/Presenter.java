package game.presenters;

import game.controllers.ControllerPresenter;

import java.util.Hashtable;
import java.util.Map;

abstract class Presenter implements ControllerPresenter {

    private static final String NEW_LINE = System.lineSeparator();
    private StringBuffer messageBuffer = new StringBuffer();
    final Map<Integer, String> menuMap = new Hashtable<>();
    String template;
    String[] variables;

    @Override
    public String getFormattedMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    @Override
    public Map<Integer, String> returnAndClearMenuMap() {
        Map<Integer, String> result = new Hashtable<>(menuMap);
        clearMenuMap();
        return result;
    }

    void clearAndCreateMenuMap(String[] strings) {
        int counter = 1;
        clearMenuMap();
        for (String string : strings) {
            menuMap.put(counter++, string);
        }
    }

    private void clearMenuMap() {
        menuMap.clear();
    }

    void addMenuToBuffer(String template, Map map) {
        variables = createMenuArray(map);
        addMessageToBuffer(template, variables);
    }

    private String[] createMenuArray(Map map) {
        String[] menuItems = new String[map.size()];
        int counter = map.size();
        for (Map.Entry item : menuMap.entrySet()) {
            menuItems[--counter] = String.format("(%d)%s", item.getKey(), item.getValue());
        }
        return menuItems;
    }

    void addMessageToBuffer(String template, String[] variables) {
        String variable = arrayToCommaDelimitedString(variables);
        formatMessage(template, variable);
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private void formatMessage(String template, String variable) {
        String formattedMessage = String.format(template, variable);
        addNewLine(formattedMessage);
    }

    void addNewLine(String formattedMessage) {
        String newLine = String.format(formattedMessage + "%s", NEW_LINE);
        addMessageToBuffer(newLine);
    }

    private void addMessageToBuffer(String newLine) {
        messageBuffer.append(newLine);
    }
}
