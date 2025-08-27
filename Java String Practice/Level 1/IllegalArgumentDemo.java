import java.util.Scanner;
public class IllegalArgumentDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        try{
            System.out.println(s.substring(5,2));
        }catch(IllegalArgumentException e){
            System.out.println("Handled");
        }
    }
}
