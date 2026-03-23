import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int print = 0;

            while (true) {
                // 중요도 젤 큰거 찾기
                int max = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] > max) max = arr[i];
                }

                if (arr[0] == max) {
                    // 출력
                    print++;

                    if (M == 0) { // 출력한게 내가 찾는거면 멈추기
                        System.out.print(print+" ");
                        break;
                    }

                    // 출력됐으니 큐에서 제거
                    for (int k = 0; k < N - 1; k++) arr[k] = arr[k + 1]; // 뒤에거 앞으로
                    arr[N - 1] = 0;

                    // 문서도 앞으로 땡기기
                    M--;
                } else {
                    // 뒤로 보내기
                    int temp = arr[0];
                    for (int k = 0; k < N - 1; k++) arr[k] = arr[k + 1];
                    arr[N - 1] = temp;

                    // M도 같이 
                    if (M == 0) M = N - 1;
                    else M--;
                }
            }
        }

    }
}