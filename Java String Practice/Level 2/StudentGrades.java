public class StudentGrades {
    public static int[][] scores(int n){
        int[][] a=new int[n][3];
        for(int i=0;i<n;i++)for(int j=0;j<3;j++)a[i][j]=(int)(Math.random()*41+60);
        return a;
    }
    public static double[][] calc(int[][] a){
        double[][] r=new double[a.length][3];
        for(int i=0;i<a.length;i++){
            int t=a[i][0]+a[i][1]+a[i][2];
            double avg=t/3.0,p=t/3.0;
            r[i][0]=t;r[i][1]=avg;r[i][2]=p;
        }
        return r;
    }
    public static String grade(double p){
        if(p>=90)return "A";
        if(p>=75)return "B";
        if(p>=50)return "C";
        return "D";
    }
    public static void main(String[] args){
        int[][] a=scores(5);
        double[][] r=calc(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i][0]+" "+a[i][1]+" "+a[i][2]+" "+r[i][0]+" "+Math.round(r[i][1])+" "+Math.round(r[i][2])+" "+grade(r[i][2]));
        }
    }
}
