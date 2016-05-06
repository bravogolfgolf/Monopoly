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

    public String successfullTranstionToNextStep(){
        return getExpectedOutput();
    }

    public void whenUserEntersText() throws IOException {
        sendInput("a");
    }

    public void whenUserEntersZero() throws IOException {
        sendInput("0");
    }

    public void whenUserEntersOne() throws IOException {
        sendInput("1");
    }

    public void whenUserEntersTwo() throws IOException {
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