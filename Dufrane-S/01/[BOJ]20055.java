import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2 * n];
        int[] robot = new int[n];
        for (int i = 0; i < n * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int zeros = 0;
        int answer = 0;
        while (zeros < k) {
            answer++;
            moveBelt(belt, robot);
            moveRobot(belt, robot);
            zeros = checkZeros(belt);
        }
        System.out.print(answer);
    }

    static void moveBelt(int[] belt, int[] robot) {
        for (int i = robot.length - 1; i >= 0; i--) {
            if (robot[i] != 0) {
                if (i != robot.length - 1) {
                    robot[i + 1] = 1;
                }
                robot[i] = 0;
            }
        }
        robot[robot.length - 1] = 0;
        robot[0] = 0;

        int tmp = belt[belt.length-1];
        for (int i = belt.length - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = tmp;
    }
    static void moveRobot(int[] belt, int[] robot) {
        for (int i = robot.length - 2; i >= 0; i--) {
            if (robot[i] != 0) {
                if (i == robot.length - 1) {
                    robot[i] = 0;
                } else if (belt[i + 1] != 0 && robot[i + 1] == 0) {
                    robot[i + 1] = 1;
                    robot[i] = 0;
                    belt[i + 1] -= 1;
                }
            }
        }
        robot[robot.length - 1] = 0;
        if (belt[0] > 0) {
            belt[0] -= 1;
            robot[0] = 1;
        }
    }

    static int checkZeros(int[] belt) {
        int zeros = 0;
        for (int i : belt) {
            if (i == 0) {
                zeros++;
            }
        }
        return zeros;
    }
}
