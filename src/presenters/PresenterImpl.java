package game.presenters;

import game.controllers.Presenter;
import game.interactors.InteractorResponse;

import java.util.Hashtable;
import java.util.Map;

class PresenterImpl implements Presenter {

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
    public Map<Integer, String> getMenuMap() {
        return menuMap;
    }

    void userInterfaceOptionsMessage(InteractorResponse response) {
        createMenuMap(response.options);
    }

    void createMenuMap(String[] strings) {
        int counter = 1;
        menuMap.clear();
        for (String string : strings) {
            menuMap.put(counter++, string);
        }
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
        String formattedMessage = formatMessage(template, variable);
        addMessageToBuffer(formattedMessage);
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private String formatMessage(String template, String variable) {
        return String.format(template, variable);
    }

    void addMessageToBuffer(String message) {
        String newLine = addNewLine(message);
        messageBuffer.append(newLine);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
