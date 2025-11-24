import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (isGroup(word)) count++;
        }

        System.out.println(count);
    }

    private static boolean isGroup(String word) {
        boolean[] visited = new boolean[26];
        char prev = word.charAt(0);
        visited[prev - 'a'] = true;

        for (int i = 1; i < word.length(); i++) {
            char now = word.charAt(i);

            // 이전 문자와 다르면서 이미 등장한 적 있으면, 그룹 단어 아님
            if (now != prev && visited[now - 'a']) return false;

            visited[now - 'a'] = true;
            prev = now;
        }

        return true;
    }
}
