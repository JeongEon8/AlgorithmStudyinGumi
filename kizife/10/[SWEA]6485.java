import java.util.*;
 
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
             
            int[] arr = new int[5001];
             
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                 
                for (int k = a; k <= b; k++) {
                    arr[k]++;
                }
            }
             
            System.out.print("#" +i);
            int P = sc.nextInt();
            for (int j = 0; j < P; j++) {
                int c = sc.nextInt();
                 
                System.out.print(" " +arr[c]);
            }
            System.out.println();
        }
    }
 
}
