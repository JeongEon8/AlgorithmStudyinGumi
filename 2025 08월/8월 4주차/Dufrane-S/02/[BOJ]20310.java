import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        int k = s.length() / 4;
        StringBuilder sb = new StringBuilder();
        int tmp = ones / 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append(0);
            } else if (tmp > 0) {
                tmp--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        tmp = zeros / 2;
        s = sb.toString();
        sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sb.append(1);
            } else if (tmp > 0) {
                tmp--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}
