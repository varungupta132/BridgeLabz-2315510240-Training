import java.util.Scanner;
public class VotingCheck {
    public static int[] ages(int n){
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=(int)(Math.random()*90+10);
        return a;
    }
    public static String[][] check(int[] a){
        String[][] res=new String[a.length][2];
        for(int i=0;i<a.length;i++){
            res[i][0]=String.valueOf(a[i]);
            res[i][1]=(a[i]>=18)?"true":"false";
        }
        return res;
    }
    public static void main(String[] args){
        int[] a=ages(10);
        String[][] arr=check(a);
        for(int i=0;i<arr.length;i++)System.out.println(arr[i][0]+" "+arr[i][1]);
    }
}
