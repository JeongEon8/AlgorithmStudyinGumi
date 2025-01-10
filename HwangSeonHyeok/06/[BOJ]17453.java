import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] doors;
    static int[][] switches;
    static int n,m;
    static List<Integer>[] ans;
    static boolean[] click;

    static void bitwise(int idx){
        for(int i = 0; i<n;i++){
            doors[i] = doors[i]^switches[idx][i];
        }
    }
    static int bitCount(){
        int cnt = 0;
        for(int bit:doors){
            if(bit==0){
                cnt--;
            }else{
                cnt++;
            }
        }
        return cnt;
    }

    static void solve(int idx){
        int ansIdx = bitCount()+n;
        if(ans[ansIdx]==null){
            ans[ansIdx] = new ArrayList<>();
            for(int i = 1;i<=m;i++){
                if(click[i]){
                    ans[ansIdx].add(i);
                }
            }
        }
        if(idx>m){
            return;
        }
        for(int i = idx; i<=m;i++){
            click[i] = true;
            bitwise(i);
            solve(i+1);
            bitwise(i);
            click[i] = false;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] split = in.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        String doorStr = in.readLine();
        doors = new int[n];
        for(int i = 0; i<n;i++){
            doors[i] = doorStr.charAt(i)-'0';
        }
        switches = new int[m+1][n];
        for(int i = 1; i<=m;i++){
            String switchStr = in.readLine();
            for(int j = 0; j<n;j++){
                switches[i][j] = switchStr.charAt(j)-'0';
            }

        }
        ans = new ArrayList[2*n+1];
        click = new boolean[m+1];
        solve(1);

        for(List<Integer> ansList:ans){
            if(ansList==null){
                sb.append("-1\n");
            }else{
                sb.append(ansList.size()+" ");
                for(int num:ansList){
                    sb.append(num+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);


    }
}