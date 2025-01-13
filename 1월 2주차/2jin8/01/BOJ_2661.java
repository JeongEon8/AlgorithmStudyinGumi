import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2661 {
    static int N;
    static String ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = null;
        dfs(0, "");
        System.out.println(ans);
    }

    static void dfs(int depth, String number) {
        if (ans != null) return;

        if (depth == N) {
            ans = number;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            // 해당 글자를 붙여도 좋은 순열이 되는지 확인
            if (check(number + i))
                dfs(depth + 1, number + i);
        }
    }

    // 좋은 수열인지 검사하기
    static boolean check(String number) {
        int len = number.length();
        // 이미 좋은 수열에 새로운 문자를 하나 붙임
        // 새로운 문자 기준으로 검사해야 함 => 뒤에서부터 확인하기
        for (int i = 1; i <= number.length() / 2; i++) {
            String s1 = number.substring(len - i, len);
            String s2 = number.substring(len - 2 * i, len - i);
            if (s1.equals(s2)) return false;
        }
        return true;
    }
}
