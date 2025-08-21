// Program: Check if the first number is the smallest among three
import java.util.Scanner;

class First_smallest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n1 = input.nextInt(), n2 = input.nextInt(), n3 = input.nextInt();
      System.out.println("Is the first number the smallest? " + (n1 < n2 && n1 < n3));
      input.close();
   }
}
