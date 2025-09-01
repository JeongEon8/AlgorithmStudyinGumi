import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16637 {

    static int N, M, answer;
    static int[] numbers;
    static char[] calc;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N - N / 2];
        calc = new char[N / 2];
        char[] chars = br.readLine().toCharArray();

        // 피연산자
        for (int i = 0; i <= N / 2; i++) {
            numbers[i] = chars[i * 2] - '0';
        }

        // 연산자
        for (int i = 0; i < N / 2; i++) {
            calc[i] = chars[i * 2 + 1];
        }

        if (N == 1) {
            System.out.println(numbers[0]);
            return;
        }

        answer = Integer.MIN_VALUE; // - 연산을 수행하면 음수가 나올 수 있음!
        M = numbers.length;
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int total) {
        if (depth == M) {
            answer = Math.max(answer, total);
            return;
        }

        // 마지막이면 그냥 total이랑 연산
        if (depth == M - 1) {
            dfs(depth + 1, getTotal(total, numbers[depth], calc[depth - 1]));
            return;
        }

        // 괄호 묶기 O == 현재 숫자랑 다음 숫자랑 연산하기
        int temp = getTotal(numbers[depth], numbers[depth + 1], calc[depth]);
        char totalCalc = depth == 0 ? '+' : calc[depth - 1]; // total이랑 더할 연산 구하기
        dfs(depth + 2, getTotal(total, temp, totalCalc));

        // 괄호 묶기 X == 현재 숫자만 연산하기
        dfs(depth + 1, getTotal(total, numbers[depth], totalCalc));
    }

    static int getTotal(int a, int b, char kind) {
        return kind == '+' ? a + b : (kind == '-' ? a - b : a * b);
    }
}
