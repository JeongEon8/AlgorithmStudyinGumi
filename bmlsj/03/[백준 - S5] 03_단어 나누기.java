
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = input.length();
        String ans = null;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                String s2 = new StringBuilder(input.substring(i, j)).reverse().toString();
                String s3 = new StringBuilder(input.substring(j)).reverse().toString();

                String newWord = s1 + s2 + s3;

                if (ans == null || newWord.compareTo(ans) < 0) {
                    ans = newWord;
                }
            }
        }

        System.out.println(ans);

    }

}
