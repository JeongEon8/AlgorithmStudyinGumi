import java.io.*;
import java.util.*;

public class Main {

    static int[][] box;
    static boolean[] ver = new boolean[5];
    static boolean[] hor = new boolean[5];
    static int bingoCount = 0;
    static boolean inc = false;
    static boolean dec = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        box = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                String s = st.nextToken();
                Dot searched = search(Integer.parseInt(s));
                if (!ver[searched.x]) {
                    checkVer(searched.x);
                }
                if (!hor[searched.y]) {
                    checkHor(searched.y);
                }
                if (!inc && searched.y + searched.x == 4) {
                    checkInc();
                }
                if (!dec && searched.y == searched.x) {
                    checkDec();
                }
                answer++;
/*                System.out.println("s = " + s);
                System.out.println("answer = " + answer);
                printBingo();
                System.out.println("bingoCount = " + bingoCount);*/
                if (bingoCount >= 3) {
                    System.out.println(answer);
                    return;
                }
            }
        }

    }

    private static void printBingo() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void checkInc() {
        for (int i = 0; i < 5; i++) {
            if (!(box[i][4 - i] == 0)) return;
        }
        inc = true;
        bingoCount++;
    }

    private static void checkDec() {
        for (int i = 0; i < 5; i++) {
            if (!(box[i][i] == 0)) return;
        }
        dec = true;
        bingoCount++;
    }

    static void checkVer(int x) {
        for (int i = 0; i < 5; i++) {
            if (!(box[i][x] == 0)) return;
        }
        ver[x] = true;
        bingoCount++;
    }

    static void checkHor(int y) {
        for (int i = 0; i < 5; i++) {
            if (!(box[y][i] == 0)) return;
        }
        ver[y] = true;
        bingoCount++;
    }

    static Dot search(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (box[i][j] == n) {
                    box[i][j] = 0;
                    return new Dot(i, j);
                }
            }
        }
        return null;
    }

}

class Dot {
    int y;
    int x;

    public Dot(int i, int j) {
        this.y = i;
        this.x = j;
    }
}
