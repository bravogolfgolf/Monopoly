package game.presenters;

import game.controllers.Presenter;

class PresenterImpl implements Presenter {

    private static final String NEW_LINE = System.lineSeparator();
    private StringBuffer messageBuffer = new StringBuffer();
    String template;
    String[] variables;

    public String getFormattedMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    void addMenuToBuffer(String template, String[] variables) {
        String[] menuItems = createMenuArray(variables);
        addMessageToBuffer(template, menuItems);
    }

    void addMessageToBuffer(String template, String[] variables) {
        String variable = arrayToCommaDelimitedString(variables);
        String formattedMessage = formatMessage(template, variable);
        addMessageToBuffer(formattedMessage);
    }

    void addMessageToBuffer(String message) {
        String newLine = addNewLine(message);
        messageBuffer.append(newLine);
    }

    private String[] createMenuArray(String[] variables) {
        String[] menuItems = new String[variables.length];
        for (int i = 1; i <= variables.length; i++) {
            menuItems[i - 1] = String.format("(%d)%s", i, variables[i - 1]);
        }
        return menuItems;
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private String formatMessage(String template, String variable) {
        return String.format(template, variable);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }
}
