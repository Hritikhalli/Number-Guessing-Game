import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class NumberGuessing{
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 15;
    private static final int MAX_ROUNDS = 3;
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("Number Guessing Game");
        System.out.println("Total Number Of Rounds : 3");
        System.out.println("Attempts To Guess Number In Each Round : 15 \n");
        for(int i = 1; i <= MAX_ROUNDS ; i++)
        {
            int number = random.nextInt(MAX_RANGE)+ MIN_RANGE;
            int attempts =0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i , MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);
            while(attempts < MAX_ATTEMPTS )
            {
                System.out.println("Enter Your Guess:");
                int guess_number = scanner.nextInt();
                attempts = attempts +1;

                if (guess_number == number)
                {
                    int score = MAX_ATTEMPTS - attempts + 1;
                    totalScore = totalScore + score;
                    System.out.printf("\nCongratulations!!! \nNumber Guessed is Right. \nAttempts =%d.  \nRound Score = %d\n", attempts,score);
                    break;
                }
                else if(guess_number<number){
                    System.out.printf("The number is greater than %d.\nAttempts Left = %d.\n ", guess_number,MAX_ATTEMPTS-attempts);

                }
                else if(guess_number>number){
                    System.out.printf("The number is less than %d.\nAttempts Left = %d.\n ", guess_number, MAX_ATTEMPTS-attempts);
                
                }
            }
            if(attempts == MAX_ATTEMPTS)
            {
                System.out.printf("\n Round = %d \n",i);
                System.out.println("Attempts left = 0\n");
                System.out.printf("The Random Number Is : %d\n",number);
            }

        }
        System.out.printf("Game Over \n Total Score = %d\n", totalScore);
        scanner.close();
    }

}