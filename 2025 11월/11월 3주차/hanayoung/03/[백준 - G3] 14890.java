import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            boolean installCheck = false; // 경사로 설치 여부 확인
            int prevH = maps[i][0];
            int same = 1; // 같은 높이 나온 횟수
            boolean canInstall = true;
            for(int j = 1; j < N; j++) {
                if(prevH != maps[i][j]) {
                    if(installCheck == false && same >= L && maps[i][j] - prevH == 1) {
                        // 올라가는 경우, 설치가능으로 판단
                        prevH = maps[i][j];
                        same = 1;
                        continue;
                    } else if(installCheck == false && prevH - maps[i][j] == 1) {
                        // 내려가는 경우, 설치 가능한지 확인 시작
                        installCheck = true;
                        prevH = maps[i][j];
                        same = 1;
                        if(same == L) {
                            // 경사로 길이가 1인 경우, 바로 설치 가능
                            installCheck = false;
                            same = 0;
                        } else if(j == N-1 && same < L) {
                            canInstall = false;
                            break;
                        }
                        continue;
                    }
                    canInstall = false;
                    break;
                } else {
                    same++;
                    if(installCheck == true && same < L && j == N-1) {
                        canInstall = false;
                    } else if(installCheck == true && same == L) {
                        // 낮아진 곳 설치 완료
                        installCheck = false;
                        same = 0;
                    }
                }
            }
            if(canInstall == true) {
                System.out.println("설치 가능 i "+i);
                answer++;
            }
        }

        for(int j = 0; j < N; j++) {
            boolean installCheck = false; // 경사로 설치 길이
            int prevH = maps[0][j];
            int same = 1; // 같은 높이 나온 횟수
            boolean canInstall = true;
            // 같은 높이 나온 횟수가 L보다 크거나 같고, 경사로가 설치된 적 없는데, prevH(이전 높이)와 maps[i][j](현재 높이)가 1차이가 나면 설치할 수 있다고 보기
            for(int i = 1; i < N; i++) {
                if(prevH != maps[i][j]) {
                    if(installCheck == false && same >= L && maps[i][j] - prevH == 1) {
                        // 설치가능으로 판단
                        prevH = maps[i][j];
                        same = 1;
                        continue;
                    } else if(installCheck == false && prevH - maps[i][j] == 1) {
                        installCheck = true;
                        prevH = maps[i][j];
                        same = 1;
                        if(same == L) {
                            installCheck = false;
                            same = 0;
                        } else if(i == N-1 && same < L) {
                            canInstall = false;
                            break;
                        }
                        continue;
                    }
                    canInstall = false;
                    break;
                } else {
                    same++;
                    if(installCheck == true && same < L && i == N-1) {
                        canInstall = false;
                    } else if(installCheck == true && same == L) {
                        // 낮아진 곳 설치 완료
                        installCheck = false;
                        same = 0;
                    }
                }
            }
            if(canInstall == true) {
                System.out.println("설치 가능 j "+j);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
