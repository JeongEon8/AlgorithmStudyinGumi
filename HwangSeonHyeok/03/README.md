# [백준 - S5] 4108. 지뢰찾기 

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
지뢰가나오면 지뢰칸을 -1로 기록하고 주변 8칸중에 지뢰가 없는 칸에 +1을 더해서 기록한다. -1을 출력할때'*'로 바꿔서 출력해준다.
```java
int[][] mine = new int[r][c];
for (int i = 0; i < r; i++) {
    String str = in.readLine();
    for (int j = 0; j < c; j++) {
        char point = str.charAt(j);
        if (point == '*') {
            mine[i][j] = -1;
            for (int k = 0; k < 8; k++) {
                int nextR = i + dx[k];
                int nextC = j + dy[k];
                if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c && mine[nextR][nextC] != -1) {
                    mine[nextR][nextC]++;
                }
            }
        }

    }
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/4108