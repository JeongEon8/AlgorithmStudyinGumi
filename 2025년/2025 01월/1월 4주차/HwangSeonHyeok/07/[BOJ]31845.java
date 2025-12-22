import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] scores  = new int[n];
        split = in.readLine().split(" ");
        for(int i = 0; i<n;i++){
            scores[i] = - Integer.parseInt(split[i]);
        }
        Arrays.sort(scores);
        int ans = 0;
        int max = Math.min(m,n%2==0? n/2:n/2+1);
        for (int i = 0; i<max;i++){
            if(scores[i]>0)break;
            ans-=scores[i];
        }
        System.out.println(ans);
    }
}