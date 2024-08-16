import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int P = Integer.parseInt(st1.nextToken());
            int Q = Integer.parseInt(st1.nextToken());
            int R = Integer.parseInt(st1.nextToken());
            int S = Integer.parseInt(st1.nextToken());
            int W = Integer.parseInt(st1.nextToken());
            
            int a = P * W;
            
            int b = 0;
            if (W<=R) {
                b =Q;
            } else {
                b=Q+(S*(W-R));
            }
            
            int result = Math.min(a, b);
            
            System.out.println("#"+(i+1) + " "+result);
        }
        
        
    }
}
