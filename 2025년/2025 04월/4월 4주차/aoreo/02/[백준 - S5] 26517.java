import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        long resultA = a*k + b;
        long resultB = c*k + d;
        if(resultA == resultB) System.out.print("Yes "+resultA);
        else System.out.print("No");
    }
}
