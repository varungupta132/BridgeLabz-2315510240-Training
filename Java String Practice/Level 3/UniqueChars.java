import java.util.*;

public class UniqueChars {
    static int length(String s) {
        int i = 0;
        try {
            for (;; i++) s.charAt(i);
        } catch(Exception e) {}
        return i;
    }

    static char[] unique(String s) {
        int n = length(s), k = 0;
        char[] res = new char[n];
        for (int i=0;i<n;i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j=0;j<k;j++) if (res[j]==c) found=true;
            if (!found) res[k++]=c;
        }
        return Arrays.copyOf(res,k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        char[] arr=unique(s);
        System.out.println(Arrays.toString(arr));
    }
}
