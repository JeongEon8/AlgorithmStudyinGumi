import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] num = new int[N];
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                sum[i] = sum[i - 1] + num[i]; 
            }else {
                sum[i] = num[i];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(start == 0) System.out.println(sum[end]);
            else System.out.println(sum[end] - sum[start-1]);
        }
    }
}
