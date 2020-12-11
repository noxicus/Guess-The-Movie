import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String[] args) throws FileNotFoundException {

        int indexOfLetter = 99;
        int wrongLettCount = 0;
        String wrongCharacter = "";
        String wrongCharacters = "";

        Game game1 = new Game();
        String movieToBeGuessed = game1.gameStart();
        String movieTBGUL = movieToBeGuessed.replaceAll("\\w", "_");

        for (int i = 10; i > 0; i--) {
            System.out.println("You are guessing " + movieTBGUL);
            System.out.println(i + " more trys.");
            System.out.println("You have guessed (" + wrongLettCount + ") wrong letters: " + wrongCharacters);
            System.out.println("Guess the letter: ");
            Scanner scanner = new Scanner(System.in);
            char input = scanner.next().charAt(0);

            indexOfLetter = movieToBeGuessed.indexOf(input);
            if (indexOfLetter >= 0 && indexOfLetter <= movieToBeGuessed.length()) {
                movieTBGUL = game1.checkCorrect(movieToBeGuessed, movieTBGUL, input);

            } else {
                wrongLettCount++;
                wrongCharacter = Character.toString(input);
                wrongCharacters = wrongCharacters + wrongCharacter + ", ";

            }
            if (game1.checkForFinish(movieTBGUL)) {
                System.out.println("You won");
                break;
            } else if (i == 1) {
                System.out.println("No more trys, you lost a game !");
            }
        }
    }
}
