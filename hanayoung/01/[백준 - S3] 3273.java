import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int start = 0, end = n-1;
        int answer = 0;

        while(start < end) {
            int sum = arr[start] + arr[end];
            switch(Integer.compare(sum, x)) {
                case -1:
                    // sum < x
                    start++;
                    break;
                case 0:
                    answer++;
                    start++;
                    break;
                case 1:
                    end--;
                    break;
            }
        }

        System.out.println(answer);
    }
}
