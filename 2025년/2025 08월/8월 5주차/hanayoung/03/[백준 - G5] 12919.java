import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static String S;
    static String T;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        S = st.nextToken();
        st = new StringTokenizer(bf.readLine());
        T = st.nextToken();

        recur(T);

        System.out.println(answer);
    }

    static void recur(String str) {
        if (answer == 1) {
            return;
        }
        if (str.length() == 0) {
            return;
        }
        if(str.equals(S)) {
            answer = 1;
            return;
        }
        if (str.charAt(str.length() - 1) == 'A') {
            recur(str.substring(0, str.length() - 1));
        }
        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
            String reverse = sb.reverse().toString();
            recur(reverse);
        }

    }
}
