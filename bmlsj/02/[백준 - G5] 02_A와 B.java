
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        boolean ans = change(S, T);
        System.out.println(ans ? 1 : 0);
    }

    static boolean change(String start, String target) {

        while (target.length() > start.length()) {
            if (target.endsWith("A")) {
                target = target.substring(0, target.length() - 1);
            } else if (target.endsWith("B")) {
                target = target.substring(0, target.length() - 1);
                target = new StringBuilder(target).reverse().toString();
            }
        }
        return target.equals(start);
    }

}
