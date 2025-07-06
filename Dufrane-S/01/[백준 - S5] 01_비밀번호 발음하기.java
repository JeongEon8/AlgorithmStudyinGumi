import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static String moum = "aeiou";
    static String joum = "bcdfghjklmnpqrstvwxyz";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String text = br.readLine();
        while (!text.equals("end")) {
            if (check(text)) {
                sb.append("<");
                sb.append(text);
                sb.append("> is acceptable.\n");
            } else {
                sb.append("<");
                sb.append(text);
                sb.append("> is not acceptable.\n");
            }
            text = br.readLine();
        }
        System.out.println(sb);
    }

    private static boolean check(String text) {
        boolean isMoum = false;
        boolean[] seq = new boolean[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char now = text.charAt(i);

            if (moum.indexOf(now) != -1) {
                isMoum = true;

            }
            seq[i] = moum.indexOf(now) != -1;
            if (i != 0 && now == text.charAt(i - 1) && now != 'e' && now != 'o') {
                return false;
            }
            if (i >= 2 && seq[i - 2] == seq[i - 1] && seq[i - 1] == seq[i]) {
                return false;
            }
        }
        return isMoum;
    }
}
