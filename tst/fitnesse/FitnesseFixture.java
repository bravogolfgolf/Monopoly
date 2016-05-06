package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

import static game.fitnesse.Setup.monopoly;

public class FitnesseFixture {

    FitnesseFixture() {
    }

    FitnesseFixture(StateImpl state) throws IOException {
        monopoly.setup(state);
        monopoly.start();
    }

    public String initialUserPromptIs() throws IOException {
        return getExpectedOutput();
    }

    public String expectedResponseIs() {
        return getExpectedOutput();
    }

    public String successfullTranstionToNextStep() {
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
        monopoly.parser.parse(input);
    }

    private String getExpectedOutput() {
        String result = monopoly.console.bufferedOutput.toString();
        monopoly.console.bufferedOutput = new StringBuffer();
        return result;
    }
}