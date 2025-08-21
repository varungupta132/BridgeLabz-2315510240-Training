// Program: Check if a number is divisible by 5
import java.util.Scanner;

class Divisible_by_5 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int number = input.nextInt(); // get user input
      System.out.println("Is the number " + number + " divisible by 5? " + (number % 5 == 0));
      input.close();
   }
}
