package game.fitnesse;

import java.io.IOException;

public class FitnesseFixture {

    final FitnesseSetup fitnesse = new FitnesseSetup();

    public String initialUserPromptIs() throws IOException {
        fitnesse.start();
        return getExpectedOutput();
    }

    public String expectedResponseIs(){
        return getExpectedOutput();
    }

    public void userEntersText() throws IOException {
        sendInput("a");
    }

    public void userEntersZero() throws IOException {
        sendInput("0");
    }

    public void userEntersOne() throws IOException {
        sendInput("1");
    }

    public void userEntersTwo() throws IOException {
        sendInput("2");
    }

    private void sendInput(String input) throws IOException {
        fitnesse.parser.parse(input);
    }

    private String getExpectedOutput() {
        String result = fitnesse.console.bufferedOutput.toString();
        fitnesse.console.bufferedOutput = new StringBuffer();
        return result;
    }
}
