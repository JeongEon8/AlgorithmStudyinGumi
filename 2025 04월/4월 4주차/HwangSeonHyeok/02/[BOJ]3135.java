import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        int ans = Math.abs(B-A);
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i<n;i++){
            int bookmark = Integer.parseInt(in.readLine());
            ans = Math.min(ans,Math.abs(B-bookmark)+1);
        }
        System.out.println(ans);
    }
}
