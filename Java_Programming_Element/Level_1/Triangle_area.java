import java.util.Scanner;
public class Triangle_area {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / 6.4516;
        System.out.println("Area in square cm: " + areaCm + " and in square inches: " + areaInches);
        input.close();
    }
}
