import java.util.Scanner;
public class ArrayIndexOutOfBoundsDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;i++)a[i]=sc.next();
        try{
            System.out.println(a[n]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Handled");
        }
    }
}
