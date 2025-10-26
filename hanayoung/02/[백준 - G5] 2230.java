import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(new StringTokenizer(bf.readLine()).nextToken());
        }

        Arrays.sort(arr);
        int start = 0, end = 0;
        int answer = arr[N-1] - arr[0];

        for(start = 0; start < N; start++) {
            int diff = arr[end] - arr[start];
            while(end >= start && end < N-1 && diff < M) {
                end++;
                diff = arr[end] - arr[start];
            }
            if(diff == M) {
                answer = M;
                break;
            } else if(diff > M) {
                answer = Math.min(answer, diff);
            }
        }
        System.out.println(answer);
    }
}
