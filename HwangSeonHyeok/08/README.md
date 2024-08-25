# [백준 - s1] 16943. 숫자 재배치

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 브루트포스
- 조합론
- 백트래킹

## :round_pushpin: **Logic**

조합을 구하고 그 결과가 b보다 작으면서 최대값인지 판별한다.

```java
   static void permutation(int depth, long current) {
        if (depth == a.length()) {
            if (current < b && ans < current) {
                ans = (int) current;
            }
            return;
        }
        for (int i = 0; i < a.length(); i++) {
            if (depth == 0 && a.charAt(i) - '0' == 0) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                permutation(depth + 1, current * 10 + (a.charAt(i) - '0'));
                visited[i] = false;
            }
        }

    }

```

## :black_nib: **Review**

문제 이름이 왜 운명일까

## 📡**Link**

- https://www.acmicpc.net/problem/16943
