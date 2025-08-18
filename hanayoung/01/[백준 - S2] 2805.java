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

        st = new StringTokenizer(bf.readLine());
        int[] trees = new int[N];

        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        int left = 0, right = trees[N-1];
        int answer = 0;

        while(left<=right) {
            int mid = (left+right)/2;

            long sum = 0;
            for(int ele: trees) {
                if(ele - mid > 0) sum += ele-mid;
            }

            if(sum < M) {
                right = mid -1;
            } else {
                if(answer < mid) answer = mid;
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
