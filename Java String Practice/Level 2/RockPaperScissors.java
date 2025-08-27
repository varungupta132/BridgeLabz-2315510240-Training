import java.util.Scanner;
public class RockPaperScissors {
    public static String comp(){
        int n=(int)(Math.random()*3);
        if(n==0)return "rock";
        if(n==1)return "paper";
        return "scissors";
    }
    public static int winner(String u,String c){
        if(u.equals(c))return 0;
        if(u.equals("rock")&&c.equals("scissors"))return 1;
        if(u.equals("paper")&&c.equals("rock"))return 1;
        if(u.equals("scissors")&&c.equals("paper"))return 1;
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int g=sc.nextInt(),uw=0,cw=0;
        for(int i=0;i<g;i++){
            String u=sc.next();
            String c=comp();
            int w=winner(u,c);
            if(w==1)uw++;else if(w==-1)cw++;
            System.out.println("User:"+u+" Comp:"+c+" Winner:"+(w==0?"Draw":(w==1?"User":"Comp")));
        }
        System.out.println("User Wins:"+uw+" Comp Wins:"+cw);
        System.out.println("User %:"+(uw*100.0/g)+" Comp %:"+(cw*100.0/g));
    }
}
