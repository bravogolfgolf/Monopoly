package game.fitnesse;

import game.MonopolyTest;

import java.io.IOException;

public class SelectVersion {

    public SelectVersion() throws IOException {
        MonopolyTest.main(new String[0]);
    }

    public String expectedOutput(){
        return MonopolyTest.console.expectedOutput;
    }
}
