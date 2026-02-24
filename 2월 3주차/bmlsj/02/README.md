# [백준 - S3] 1051. 숫자 정사각형

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

1. 각 요소별로 `idx` 만큼의 꼭짓점 좌표가 서로 같은 지 확인한다
    - `map[i][j]`, `map[i+idx][j]`, `map[i][j+idx]`, `map[i+idx][j+idx]`
2. 서로 같다면 넓이를 계산해, 최대 넓이 값을 출력한다.

```java
int ans = 1;
for (int i = 0; i < N; i++) {
   for (int j = 0; j < M; j++) {
        int start = map[i][j];
        for (int len = 1; i + len < N && j + len < M; len++) {
            if (map[i][j + len] == start && map[i + len][j] == start && map[i + len][j + len] == start) {
                int area = (len + 1) * (len + 1);
                ans = Math.max(ans, area);
        }
    }
}
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/1051](https://www.acmicpc.net/problem/1051)
