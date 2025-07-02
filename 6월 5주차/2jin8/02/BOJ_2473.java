import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {

    static long minTotal = 3_000_000_000L;
    static int N;
    static long[] values, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = new long[N];
        answer = new long[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(values);

        // 용액 한 개 고르기(first) & 투포인터 사용해서 나머지 두 용액(second, third) 고르기
        for (int first = 0; first < N; first++) {
            int second = 0, third = N - 1;
            while (second < third) {
                // 같은 용액을 선택할 수 없음
                if (second == first) {
                    second++;
                    continue;
                } else if (third == first) {
                    third--;
                    continue;
                }

                // 특성값 구한 뒤, 최소값이랑 비교
                long total = values[first] + values[second] + values[third];
                if (Math.abs(total) < minTotal) {
                    minTotal = Math.abs(total);
                    answer[0] = values[first];
                    answer[1] = values[second];
                    answer[2] = values[third];
                }

                // 0이 되면 바로 출력 후 종료
                if (total == 0) {
                    Arrays.sort(answer);
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }
                else if (total < 0) second++; // 음수면 더 큰 값을 더하도록
                else third--; // 양수면 더 작은 값을 더하도록
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
