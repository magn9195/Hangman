import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {
    private File file;
    private String randomWord;

    public RandomWord() {
        this.file = new File("Words.txt");
        this.randomWord = null;
    }

    public String getWord() {
        return this.randomWord;
    }

    public void generateRandomWord() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        Random random = new Random();
        int randomNumber = random.nextInt(2644);
        int i = 0;
        while (i < randomNumber) {
            this.randomWord = scanner.nextLine();
            i++;
        }
    }
}
