import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static String moum = "aeiou";
    static String joum = "bcdfghjklmnpqrstvwxyz";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int scoresNum = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int maxList = Integer.parseInt(st.nextToken());
        int[] scoreList = null;
        if (scoresNum != 0) {
            st = new StringTokenizer(br.readLine());
            scoreList = new int[scoresNum];
            for (int i = 0; i < scoresNum; i++) {
                scoreList[i] = Integer.parseInt(st.nextToken());
            }
        }
        if (scoreList == null) {
            System.out.println(1);
        } else {
            int answer = 1;
            int idx = 1;
            for (int now : scoreList) {
                if (now > score) {
                    answer++;
                    idx++;
                } else if (now == score) {
                    idx++;
                } else {
                    if (idx <= maxList) {
                        System.out.println(answer);
                    } else {
                        System.out.println(-1);
                    }
                    return;
                }
            }
            if (idx <= maxList) {
                System.out.println(answer);
            } else {
                System.out.println(-1);
            }
        }

    }

}
