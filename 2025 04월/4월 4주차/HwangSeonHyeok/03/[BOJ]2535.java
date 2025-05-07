import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Player implements Comparable<Player>{
        int country, studentNum, score;
        Player(int country, int studentNum, int score){
            this.country = country;
            this.studentNum = studentNum;
            this.score = score;
        }

        @Override
        public int compareTo(Player o) {
            return o.score-this.score;
        }
    }
    static int[] countryWinnerCnt = new int[101];
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(in.readLine());
        Player[] players = new Player[n];
        for(int i = 0; i<n;i++){
            String[] split = in.readLine().split(" ");
            int country = Integer.parseInt(split[0]);
            int studentNum = Integer.parseInt(split[1]);
            int score = Integer.parseInt(split[2]);
            players[i] = new Player(country,studentNum,score);
        }
        Arrays.sort(players);
        int cnt = 0;
        for(Player p:players){
            if(countryWinnerCnt[p.country]<2){
                countryWinnerCnt[p.country]++;
                cnt++;
                sb.append(p.country+" "+p.studentNum).append("\n");
            }
            if(cnt>=3)break;
        }
        System.out.println(sb);

    }
}
