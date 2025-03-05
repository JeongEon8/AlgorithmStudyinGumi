import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        String N = st.nextToken();

        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        boolean hasZero = false;

        char[] digits = N.toCharArray();
        
        for (char digit : digits) {
            sum += digit - '0';
            if (digit == '0') hasZero = true;
        }
        
        list.sort(Comparator.reverseOrder());

        if(sum % 3 != 0 || hasZero == false) System.out.println(-1);
        else {
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits));
            System.out.println(sb.reverse());
        }
    }
}
