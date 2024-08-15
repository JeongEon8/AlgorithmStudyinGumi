import java.util.ArrayList;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int i = 0; i < T; i++) {
 
            int N = sc.nextInt();
            int K = sc.nextInt();
            boolean[] submitted = new boolean[N + 1]; // 인덱스 0은 사용하지 않음
 
            for (int j = 1; j <= K; j++) {
                int student = sc.nextInt();
                submitted[student] = true;
            }
 
            ArrayList<Integer> list = new ArrayList<>(); // 숙제 안 한 학생들
            for (int j = 1; j <= N; j++) {
                if (submitted[j] != true) {
                    list.add(j);
                }
            }
 
            System.out.print("#" + (i + 1) + " ");
            for (int j = 0; j < N - K; j++) {
                int noSub = list.get(j);
                System.out.print(noSub + " ");
 
            }
            System.out.println();
        }
 
    }
}
