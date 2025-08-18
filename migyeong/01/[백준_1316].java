package construct;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int groupWordCount = 0;

        for (int i = 0; i < num; i++) {
            boolean[] alpha = new boolean[26];
            String word = br.readLine();
            boolean isGroupWord = true;

            char previousChar = word.charAt(0);
            alpha[previousChar - 'a'] = true;

            for (int j = 1; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if (currentChar != previousChar) {
                    if (alpha[currentChar - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    alpha[currentChar - 'a'] = true;
                }
                previousChar = currentChar;
            }

            if (isGroupWord) {
                groupWordCount++;
            }
        }
        System.out.println(groupWordCount);
    }
}