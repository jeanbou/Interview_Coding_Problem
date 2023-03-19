package odoo_hackkerank;

import java.util.Random;
import java.util.Scanner;

/*
 * Solve the game "Guess a number", find a secret integer between 1 and 1000000
 * in less than 50 guesses. Write a function that solves the game without user input and returns the
 * solution by using the function verify() which is defined with the following specifications:
 */

// Credits (GFG) : https://www.geeksforgeeks.org/java-program-to-guess-a-random-number-in-a-range/

public class GuessANumber {

	public static void main(String[] args) {
		// stores actual and guess number
        int answer, guess;
  
          // maximum value is 100
        // final int MAX = 100;
        final int MAX = 1000000;
        
        // takes input using scanner
        Scanner in = new Scanner(System.in);
  
        // Random instance
        Random rand = new Random();
  
        boolean correct = false;
  
        // correct answer
        answer = rand.nextInt(MAX) + 1;
  
        // loop until the guess is correct
        while (!correct) {
  
            System.out.println(
                "Guess a number between 1 and 1000000: ");
  
            // guess value
            guess = in.nextInt();
  
            // if guess is greater than actual
            if (guess > answer) {
                System.out.println("Too high, try again");
            }
  
            // if guess is less than actual
            else if (guess < answer) {
                System.out.println("Too low, try again");
            }
  
            // guess is equal to actual value
            else {
  
                System.out.println(
                    "Yes, you guessed the number.");
  
                correct = true;
            }
        }
        System.exit(0);

	}

}
