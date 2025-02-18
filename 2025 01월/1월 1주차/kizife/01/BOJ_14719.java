import java.util.Scanner;

public class BOJ_14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = sc.nextInt();
        }

        int[][] map = new int[h][w];

        for (int i = 0; i < w; i++) {
            int height = blocks[i];
            for (int j = 0; j < height; j++) {
                map[h-1-j][i] = 1; //블록 자리에 1
            }
        }

        int water = 0;
        for (int i = 0; i < h; i++) {
            boolean leftWall = false; // 왼쪽 벽 존재 여부
            int tempWater = 0; //현재 층에서 임시로 고인 물

            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) { //벽 발견

                    if (leftWall) { //왼쪽벽 있는 상태라면
                        water += tempWater; //그 사이에 갇힌 물을 더해줌
                        tempWater = 0; // 임시물 초기화
                    }

                    leftWall = true; //벽 생긴 것으로 설정 (map[i][j]==1이니까)
                } else if (leftWall) {
                    //왼쪽 벽 있는 상태로 현재 map[i][j]==0이면
                    tempWater++; //물이 고일 수 있음
                }
            }
        }

        System.out.println(water);
    }
}
