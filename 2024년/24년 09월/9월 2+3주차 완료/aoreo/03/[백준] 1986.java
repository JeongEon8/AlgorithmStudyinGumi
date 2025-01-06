import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int M = Integer.parseInt(st.nextToken()); // 가로 길이

        int[][] maps = new int[N][M];

        int[] kx = {2,2,-2,-2,1,1,-1,-1};
        int[] ky = {1,-1,1,-1,2,-2,2,-2};

        int[] qx = {-1,1,0,0,-1,1,-1,1};
        int[] qy = {0,0,-1,1,-1,1,1,-1};

        int cnt = 0;

        // queen이면 1, knight면 2, pawn이면 3 -> 빈칸이면 0
        // 안전하지 않은 곳이면 -1로 표기하고, cnt를 늘리기
        // 안전한 곳은 전체 크기 - cnt - q_cnt - k_cnt - p_cnt

        st = new StringTokenizer(bf.readLine());
        int q_cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q_cnt; i++) {
            maps[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        st = new StringTokenizer(bf.readLine());
        int k_cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k_cnt; i++) {
            maps[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
        }

        st = new StringTokenizer(bf.readLine());
        int p_cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p_cnt; i++) {
            maps[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 3;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(maps[i][j] == 1){ // 퀸일 때 한 방향으로 쭉 다 가볼 수 있음
                    for (int k = 0; k < 8; k++) {
                        int nx = i + qx[k];
                        int ny = j + qy[k];
                        while(nx >=0 && nx < N && ny >= 0 && ny < M){
                            if(maps[nx][ny] > 0) { // 무언가 있음
                                break;
                            }else if(maps[nx][ny] == 0){
                                maps[nx][ny] = -1;
                                cnt += 1;
                            }
                            nx += qx[k];
                            ny += qy[k];
                        }
                    }
                } else if(maps[i][j] == 2){ // 나이트일 때
                    for (int k = 0; k < 8; k++) {
                        int nx = i + kx[k];
                        int ny = j + ky[k];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(maps[nx][ny] == 0) {
                            maps[nx][ny] = -1;
                            cnt += 1;
                        }
                    }
                }
            }
        }
        int answer = N*M - cnt - q_cnt - k_cnt - p_cnt;
        System.out.println(answer);
    }
}
