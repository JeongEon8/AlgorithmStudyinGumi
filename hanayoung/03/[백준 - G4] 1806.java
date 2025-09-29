
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int answer = 100000;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if (i > 0) {
                arr[i] += arr[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            int base = (i == 0 ? 0 : arr[i-1]);
            int target = base + S;
            int left = i;
            int right = N-1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] >= target) {
                    answer = Math.min(mid - i+1, answer);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(answer == 100000 ? 0 : answer);
    }
}
