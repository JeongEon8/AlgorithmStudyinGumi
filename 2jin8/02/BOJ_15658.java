import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658 {

    static int N, minAnswer, maxAnswer;
    static int[] numbers, calc, used, choice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        calc = new int[4]; // 연산자 정보 (+, -, *, /)
        used = new int[4];
        choice = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        minAnswer = Integer.MAX_VALUE;
        maxAnswer = Integer.MIN_VALUE;
        choiceCalc(0);
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    // 연산자들을 선택하는 것 (순서 의미O) => 순열
    public static void choiceCalc(int depth) {
        if (depth == N - 1) { // 피연산자가 N -> 연산자는 N-1
            int total = getTotal();
            minAnswer = Math.min(minAnswer, total);
            maxAnswer = Math.max(maxAnswer, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 사용할 수 있는 연산자를 다 사용한 경우 X
            if (used[i] == calc[i]) continue;

            used[i]++;
            choice[depth] = i;
            choiceCalc(depth + 1);
            used[i]--;
        }
    }

    public static int getTotal() {
        int total = numbers[0];
        for (int i = 0; i < N - 1; i++) {
            if (choice[i] == 0) { // +
                total += numbers[i + 1];
            } else if (choice[i] == 1) { // -
                total -= numbers[i + 1];
            } else if (choice[i] == 2) { // *
                total *= numbers[i + 1];
            } else { // /
                total /= numbers[i + 1];
            }
        }
        return total;
    }
}
