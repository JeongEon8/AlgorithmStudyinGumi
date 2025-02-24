import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1062 {
    static int N, K;
    static List<String> words = new ArrayList<>();
    static boolean[] learned = new boolean[26]; // 알파벳 학습 여부
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        // K가 5보다 작으면 기본적으로 읽을 수 있는 단어가 없으므로 0 출력
        if (K < 5) {
            System.out.println(0);
            return;
        }

        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        // 입력받은 단어에서 "antic" 부분을 제외하고 저장
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            word = word.replaceAll("[antic]", "");
            words.add(word);
        }

        // 백트래킹을 통해 남은 K-5개의 글자 조합 탐색
        backtrack(0, 0);

        // 결과 출력
        System.out.println(max);
    }

    // 백트래킹 함수: index는 알파벳, count는 선택한 알파벳의 개수
    private static void backtrack(int index, int count) {
        // K-5개의 글자를 모두 선택한 경우 읽을 수 있는 단어 개수 체크
        if (count == K - 5) {
            int readableCount = countReadableWords();
            max = Math.max(max, readableCount);
            return;
        }

        // 알파벳 탐색 (a부터 z까지)
        for (int i = index; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true; // i번째 알파벳 선택
                backtrack(i + 1, count + 1); // 다음 글자 탐색
                learned[i] = false; // 선택 취소 (백트래킹)
            }
        }
    }

    // 읽을 수 있는 단어 개수를 세는 함수
    private static int countReadableWords() {
        int count = 0;

        for (String word : words) {
            boolean canRead = true;

            // 단어의 모든 글자가 학습된 글자인지 체크
            for (int j = 0; j < word.length(); j++) {
                if (!learned[word.charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }
            }

            if (canRead) {
                count++;
            }
        }

        return count;
    }
}
