// Program: Compute sum of n natural numbers
import java.util.Scanner;

class Sum_of_n_natural_numbers {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      if (n > 0) {
         int sum = n * (n + 1) / 2;
         System.out.println("The sum of " + n + " natural numbers is " + sum);
      } else {
         System.out.println("The number " + n + " is not a natural number");
      }
      input.close();
   }
}
