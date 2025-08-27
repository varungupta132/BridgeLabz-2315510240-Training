import java.util.Scanner;
public class SubstringExample {
    public static String sub(String s,int st,int en){
        String r="";
        for(int i=st;i<en;i++)r+=s.charAt(i);
        return r;
    }
    public static boolean compare(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        for(int i=0;i<s1.length();i++)if(s1.charAt(i)!=s2.charAt(i))return false;
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int st=sc.nextInt(),en=sc.nextInt();
        String a=sub(s,st,en),b=s.substring(st,en);
        System.out.println(a);
        System.out.println(b);
        System.out.println(compare(a,b));
    }
}
