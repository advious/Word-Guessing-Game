import java.util.*;

public class wordGuessingGame {
    // global variables
    static String secretWord;        // secret word
    static String maskedWord;        // masked word
   
    static String usedLetters;       // used letters
    static int lives;                // number of remaining lives
   
    static int finish;               // status of the game - {-1:in progress,0:player lost,1:player won}
    static char letter;             
    // the letter that the player chose in the current turn

    static Scanner scan = new Scanner (System.in);  // scanner that will be used in the entire code

    static void setupGame() {
        secretWord = scan.next();
        maskedWord = "";
        for (int i = 0; i < secretWord.length(); i++) {
            maskedWord += "*";
        }
        usedLetters = "";
        lives = 5;
        finish = -1;
    }

    static void drawScreen() {
        System.out.println(maskedWord);
        System.out.println("Remaining lives: " + lives);
        System.out.println("Used letters: " + usedLetters + "\n");
    }

    static void getMove() {
        System.out.println("Enter a lower case letter:");
        letter = scan.next().charAt(0);
        for (int i = 0; i < usedLetters.length(); i++) {
            if (letter == usedLetters.charAt(i)) {
                boolean unique = false;
                while (unique == false) {
                    System.out.println("Invalid! This letter is used before.");
                    System.out.println("Enter a lower case letter:");
                    letter = scan.next().charAt(0);
                    if (usedLetters.indexOf(letter) == -1) {
                        break;
                    }
                }
            }
        }
    }

    static void makeMove() {
        if (secretWord.indexOf(letter) != -1) {
            for (int i = 0; i < maskedWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                maskedWord = maskedWord.substring(0,i) + letter + maskedWord.substring(i+1);
                }
            }
        } else {
            lives--;
        }
        usedLetters += letter;
    }

    static int checkEndGame() {
        if (lives == 0) {
            return 0;
        } else if (maskedWord.equals(secretWord)) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {

        setupGame();                       
    // STEP 1

        // main game loop
        while (true) {
            drawScreen();                  
    // STEP 2
            getMove();                      // STEP 3
           
    makeMove();                     // STEP 4
            finish = checkEndGame();       
    // STEP 5
            if (finish>-1) break;           // if game is finished, break the loop
       
    }

        // STEP 6: end game information
        drawScreen();
        
        if (checkEndGame() == 0) {
            System.out.println("You lost! The secret word was: " + secretWord);
        } else if (checkEndGame() == 1) {
            System.out.println("You won!");
        }
    }
}
