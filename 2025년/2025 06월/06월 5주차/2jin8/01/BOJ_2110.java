import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

    static int N, C;
    static int[] houses;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // C개의 공유기를 N개의 집에 적절히 설치
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        // 가장 인접한 두 공유기 사이의 최대 거리 설정 (즉, 공유기 사이의 최소 거리의 최댓값 찾기)
        System.out.println(getMaxDistanceBetweenHouse());
    }

    static int getMaxDistanceBetweenHouse() {
        int left = 1, right = houses[N - 1] - houses[0]; // 공유기 사이 거리는 최소 1

        int maxDistance = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 설치하는 공유기 수 구하기
            // 설치 가능한 공유기 수가 C보다 적은 경우, 설치 간격 좁히기
            if (getInstallCount(mid) < C) {
                right = mid - 1;
            } else { // 설치 간격 넓히기
                maxDistance = mid;
                left = mid + 1;
            }
        }
        return maxDistance;
    }

    static int getInstallCount(int distance) {
        // 우선 첫 번째 집에 무조건 설치
        int prevHouse = houses[0], count = 1;
        for (int i = 1; i < N; i++) {
            // 집 사이의 거리가 distance 이상이여야 공유기 설치 가능
            if (houses[i] - prevHouse >= distance) {
                count++;
                prevHouse = houses[i];
            }
        }
        return count;
    }
}
