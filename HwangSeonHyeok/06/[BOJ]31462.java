import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        boolean[][] tri = new boolean[n][n];
        boolean[][] visit = new boolean[n][n];
        for(int i = 0; i<n;i++){
            String line = in.readLine();
            for(int j = 0; j<=i;j++){
                if(line.charAt(j)=='B'){
                    tri[i][j] = true;
                }
            }
        }
        boolean isAble = true;
        loop:for(int i = 0; i<n;i++){
            for(int j = 0; j<=i;j++){
                if(visit[i][j])continue;
                if(i+1==n){
                    isAble = false;
                    break loop;
                }
                if(tri[i][j]){
                    if(j+1>i){
                        isAble = false;
                        break loop;
                    }
                    if(tri[i][j+1]&&tri[i+1][j+1]&&!visit[i][j+1]&&!visit[i+1][j+1]){
                        visit[i][j]=true;
                        visit[i][j+1]=true;
                        visit[i+1][j+1]=true;
                    }else{
                        isAble = false;
                        break loop;
                    }
                }else{
                    if(!tri[i+1][j]&&!tri[i+1][j+1]&&!visit[i+1][j]&&!visit[i+1][j+1]){
                        visit[i][j]=true;
                        visit[i+1][j]=true;
                        visit[i+1][j+1]=true;
                    }else{
                        isAble = false;
                        break loop;
                    }
                }
            }
        }
        if(isAble){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}