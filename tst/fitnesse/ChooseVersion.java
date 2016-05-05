package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseVersion {

    private final MonopolyFitnesse monopolyFitnesse = new MonopolyFitnesse();

    public ChooseVersion() throws IOException {
        monopolyFitnesse.setup(StateImpl.VERSION);
    }

    public String initialUserPromptShouldBe() throws IOException {
        monopolyFitnesse.start();
        return getExpectedOutput();
    }

    public String expectedResponseShouldBe(){
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
        monopolyFitnesse.parser.parse(input);
    }

    private String getExpectedOutput() {
        String result = monopolyFitnesse.console.bufferedOutput.toString();
        monopolyFitnesse.console.bufferedOutput = new StringBuffer();
        return result;
    }
}
