import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lowerBound = 0, upperBound = N-1;
        int result = arr[lowerBound] + arr[upperBound];

        int left = 0, right = N - 1;

        while(left < right) {
            int cal = arr[left] + arr[right];
            if(Math.abs(result) > Math.abs(cal)) {
                lowerBound = left;
                upperBound = right;
                result = cal;
            }
            if(cal < 0) left++;
            else if(cal > 0) right--;
            else break;
        }
        System.out.println(arr[lowerBound]+" "+arr[upperBound]);
    }
}
