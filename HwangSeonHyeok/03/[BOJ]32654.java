import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n, ans = -1;
    static int[][] players;
    static int[][] results;

    static boolean Game(int step,int player){
        if(step == 0){
            if(player==1)return false;
            else return true;
        }
        boolean result  = true;
        if(results[step][player]==0) {
            result &= Game(step - 1, players[player][0]);
            if (players[player][1] != players[player][0]) {
                result &= Game(step - 1, players[player][1]);
            }
            if(result)results[step][player]=1;
            else results[step][player]=2;
        }else if(results[step][player]==1){
            result = true;
        }else{
            result = false;
        }
        return result;

    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        players = new int[n+1][2];
        results = new int[100][n+1];
        for(int i = 1;i<=n;i++){
            String[] split = in.readLine().split(" ");
            players[i][0] = Integer.parseInt(split[0]);
            players[i][1] = Integer.parseInt(split[1]);
        }
        for(int i = 10; i<=99;i++){
            if(Game(i,1)){
                ans = i;
                break;
            }

        }
        System.out.println(ans);


    }
}