import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] homes = new int[N];
        for(int i = 0; i < N;i++) {
            st = new StringTokenizer(bf.readLine());
            homes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homes);
        int left = 1, right = homes[N-1]-homes[0];
        int result = 0; 

        while(left <= right) {
            int mid = (left+right)/2;
            
            int count = 1, last = homes[0];

            for(int i = 0; i < N; i++) {
                if(homes[i] - last >= mid) {
                    count++;
                    last = homes[i];
                }
            }

            if(count >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
