import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int tc= 0; tc<t;tc++){
            String[] split = in.readLine().split(" ");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            int[][] blocks = new int[r+2][c+2];
            int ans = 0;
            for(int i= 1; i<=r;i++){
                String line = in.readLine();
                for(int j = 1; j<=c;j++){
                    blocks[i][j] = line.charAt(j-1) - '0';
                    if(blocks[i][j]>0)ans++;
                }
            }
            ans*=2;
            for(int i= 1; i<=r;i++){
                for(int j = 1; j<=c;j++){
                    ans+=Math.max(blocks[i][j]-blocks[i][j-1],0);
                    ans+=Math.max(blocks[i][j]-blocks[i][j+1],0);
                    ans+=Math.max(blocks[i][j]-blocks[i-1][j],0);
                    ans+=Math.max(blocks[i][j]-blocks[i+1][j],0);
                }
            }
            System.out.println(ans);
        }
    }
}