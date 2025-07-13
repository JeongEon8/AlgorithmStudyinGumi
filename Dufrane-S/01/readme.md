# [백준 - G5] 20055. 컨베이어 벨트 위의 로봇

## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)

## :round_pushpin: **Logic**
1. 벨트를 돌려서 주고
2. 로봇을 이동시킨다
```
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
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/20055
