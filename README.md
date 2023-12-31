# Word-Guessing-Game
A basic word-guessing game written in Java. Word guessing is a one-player game. After entering a secret word, the player tries to guess the secret word. The game finishes when the player finds all the letters of the secret word or the player has no remaining lives.

## Game design:
- The secret word will be masked by asterisks (\*) on-screen -- one asterisk for each letter.
- Initially, the player has 5 lives.
- In each turn, the player guesses a letter and the program unmasks the letter in the secret word. The player will lose one life if the secret word doesn't contain the letter. For example, suppose the secret word is 'alphastar' and the player's first guess is 'a'. Then the program shows a\*\*\*a\*\*a\* on screen.
- If the life of the player is 0, the player loses. Otherwise, the player wins when all the letters are found.

### Demo the game by running [this file](https://github.com/advious/Word-Guessing-Game/blob/main/WordGuessingGame.java).
