import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            int[] arr = new int[N+1];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    int num = arr[i] * arr[j];
                    int after = num % 10;
                    boolean isMonoIncre = true;
                    while(num > 0) {
                        num /= 10;
                        if(after < num % 10) {
                            isMonoIncre = false;
                            break;
                        }
                        after = num % 10;
                    }
                    if(isMonoIncre == true) max = Math.max(max, arr[i]*arr[j]);
                }
            }
            System.out.println("#"+tc+" "+max);
        }
    }
}
