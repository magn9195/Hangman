import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    private RandomWord solution;
    private char[] solutionAsArray;
    private char[] correctUserGuess;
    private int numberGuesses;
    private boolean guessed;
    private Scanner scanner;

    public Hangman() throws FileNotFoundException {
        this.solution = new RandomWord();
        this.solution.generateRandomWord();
        this.scanner = new Scanner(System.in);
        this.solutionAsArray = new char[this.solution.getWord().length()];

        this.correctUserGuess = new char[this.solution.getWord().length()];
        for (int i = 0; i<this.solution.getWord().length(); i++) {
            this.correctUserGuess[i] = '_';
        }
    }

    public void start() {
        System.out.println(this.solution.getWord());
        writeWordToArray();
        printWelcome();
        while (!guessed) {
            if (Arrays.equals(this.solutionAsArray, correctUserGuess)) {
                this.guessed = true;
                System.out.println("You win!");
                System.out.println("It took you " + this.numberGuesses + " number of wrong guesses");
                break;
            }
            printUserGuess();
            char input = inputCharGuess();
            checkCharGuess(input);
        }
    }

    private void writeWordToArray() {
        for (int i = 0; i<this.solution.getWord().length(); i++) {
            char character = this.solution.getWord().charAt(i);
            this.solutionAsArray[i] = character;
        }
    }

    private char inputCharGuess() {
        System.out.print("Input guess: ");
        String input = scanner.nextLine();
        while(input.length() > 1) {
            System.out.println("Please input a single character :)");
            input = scanner.nextLine();
        }
        this.numberGuesses += 1;
        return input.charAt(0);
    }

    private void printUserGuess() {
        for (char character : this.correctUserGuess) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    public void checkCharGuess(char input) {
        for (int i = 0; i<this.solutionAsArray.length;i++) {
            if (this.solutionAsArray[i] == input) {
                this.correctUserGuess[i] = this.solutionAsArray[i];
            }
        }
    }

    private void printWelcome() {
        System.out.println("Welcome to this Hangman game.\nYour objective is to guess the characters and eventually the word.\nGood luck!");
    }
}
