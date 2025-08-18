
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = N - 1;
        int lowerBound = 0, upperBound = N-1;
        int answer = arr[lowerBound] + arr[upperBound];

        while (left < right) {
            int cal = arr[left] + arr[right];

            if (Math.abs(cal) < Math.abs(answer)) {
                answer = cal;
                lowerBound = left;
                upperBound = right;
            }

            if (cal < 0) {
                left++;
            } else if (cal == 0) {
                break;
            } else {
                right--;
            }

        }

        System.out.println(arr[lowerBound]+" "+arr[upperBound]);
    }
}
