import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {

    static boolean[] prime;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        dist = new int[10000]; // 최대 9999

        // 소수 여부 미리 기록하기
        prime = new boolean[10000];
        for (int i = 1000; i < 10000; i++) {
            prime[i] = isPrime(i);
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Arrays.fill(dist, -1);

            int bfs = bfs(A, B);
            sb.append(bfs == -1 ? "Impossible" : bfs).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int numberA, int numberB) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(numberA);
        dist[numberA] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == numberB)
                break;

            // 첫 번째 자리
            int[] numbers = getNumbers(now);
            int first = numbers[0];
            for (int i = 1; i <= 9; i++) {
                if (first == i) continue;

                numbers[0] = i;
                int number = getNumber(numbers);
                if (dist[number] == -1 && prime[number]) {
                    queue.offer(number);
                    dist[number] = dist[now] + 1;
                }
            }
            numbers[0] = first;

            // 두 번째 자리
            for (int i = 1; i < 4; i++) {
                int tmp = numbers[i];
                for (int j = 0; j <= 9; j++) {
                    if (tmp == j) continue;

                    numbers[i] = j;
                    int number = getNumber(numbers);
                    if (dist[number] == -1 && prime[number]) {
                        queue.offer(number);
                        dist[number] = dist[now] + 1;
                    }
                }
                numbers[i] = tmp;
            }
        }
        return dist[numberB];
    }

    static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static int[] getNumbers(int number) {
        int[] numbers = new int[4];
        for (int i = 3; i >= 0; i--) {
            numbers[i] = number % 10;
            number /= 10;
        }
        return numbers;
    }

    static int getNumber(int[] numbers) {
        int number = 0;
        for (int n : numbers) {
            number = number * 10 + n;
        }
        return number;
    }
}
