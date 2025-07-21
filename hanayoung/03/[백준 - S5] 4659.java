import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        String VOWEL = "aeiou";

        while (true) {
            String word = st.nextToken();
            if ("end".equals(word)) {
                break;
            }
            boolean isAccept = true;
            boolean containVowel = false;
            char lastChar = 'a';
            boolean isVowelSequence = false;
            int cnt = 1;

            for (int i = 0; i < word.length(); i++) {
                if (VOWEL.contains(Character.toString(word.charAt(i)))) {
                    containVowel = true;
                    if (i > 0) {
                        if (isVowelSequence == true) {
                            cnt += 1;
                        } else {
                            cnt = 1;
                        }
                    }
                    isVowelSequence = true;
                } else {
                    if (i > 0) {
                        if (isVowelSequence == false) {
                            cnt += 1;
                        } else {
                            cnt = 1;
                        }
                    }
                    isVowelSequence = false;
                }
                if (i > 0) {
                    if (lastChar == word.charAt(i) && lastChar != 'e' && lastChar != 'o') {
                        isAccept = false;
                        break;
                    }
                }
                if (cnt >= 3) {
                    isAccept = false;
                    break;
                }
                lastChar = word.charAt(i);
            }
            if (isAccept && containVowel) {
                sb.append("<").append(word).append("> is acceptable.\n");
            } else {
                sb.append("<").append(word).append("> is not acceptable.\n");
            }
            st = new StringTokenizer(bf.readLine());
        }
        System.out.println(sb);
    }
}
