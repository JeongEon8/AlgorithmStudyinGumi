import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {

    static int N, M; // M: 블루레이의 개수
    static int[] lectures;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];

        // 이분 탐색: 블루레이의 크기 결정
        st = new StringTokenizer(br.readLine());
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, lectures[i]);
        }
        getBluRayMinimumSize(maxLength);
    }

    private static void getBluRayMinimumSize(int maxLength) {
        // 최대 강의 수: 100,000, 최대 강의 길이: 10,000 => 1,000,000,000
        int ans = -1;
        int left = maxLength, right = 1_000_000_000;
        while (left <= right) {
            int mid = (left + right) / 2; // 블루레이 크기
            // 사용해야 하는 블루레이 개수가 더 많은 경우
            if (bluRayCount(mid) > M) { // 블루레이 크기 늘리기
                left = mid + 1;
            } else { // 블루레이 개수보다 작거나 같은 경우, 블루레이 크기 줄이기
                ans = mid; // 블루레이 크기 최소 구해야 함
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    // 사용해야 하는 블루레이 개수 계산
    private static int bluRayCount(int bluRaySize) {
        int count = 0, size = 0;
        for (int i = 0; i < N; i++) {
            if (size + lectures[i] > bluRaySize) {
                count++;
                size = lectures[i];
            } else {
                size += lectures[i];
            }
        }
        if (size != 0) count++;

        return count;
    }
}
