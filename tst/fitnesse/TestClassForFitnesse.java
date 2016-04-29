package game.fitnesse;

public class TestClassForFitnesse {

    private int firstNumber = 0;
    private int secondNumber = 0;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int add(){
        return firstNumber + secondNumber;
    }
}

