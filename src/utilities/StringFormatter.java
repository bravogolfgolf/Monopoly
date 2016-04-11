package game.utilities;

public abstract class StringFormatter {

    private static final String NEW_LINE = System.lineSeparator();

    public static String addNewLine(String string){
        return String.format(string + "%s", NEW_LINE);
    }

}
