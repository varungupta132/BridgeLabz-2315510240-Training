// Program: Check if first, second, or third number is the largest
import java.util.Scanner;

class Largest_of_three {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n1 = input.nextInt(), n2 = input.nextInt(), n3 = input.nextInt();
      System.out.println("Is the first number the largest? " + (n1 > n2 && n1 > n3));
      System.out.println("Is the second number the largest? " + (n2 > n1 && n2 > n3));
      System.out.println("Is the third number the largest? " + (n3 > n1 && n3 > n2));
      input.close();
   }
}
