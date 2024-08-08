//1번 풀이

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int result = 1;
            int j = i;

            // (1) 연속해서 올라가는 경우
            while (j < N - 1 && arr[j] <= arr[j + 1]) {
                j++;
                result++;
                if (result >= maxLength) {
                maxLength = result;
            }
            }
            

            result = 1;
            j=i;
            // (2) 연속해서 내려가는 경우
            while (j < N - 1 && arr[j] >= arr[j + 1]) {
                j++;
                result++;
                if (result >= maxLength) {
                maxLength = result;
            }
            }
            
           
        }

        System.out.println(maxLength);

    }

}
