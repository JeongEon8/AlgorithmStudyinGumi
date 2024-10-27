# [백준] 15652. N과 M (4) 
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
백트래킹 

## ⏲️**Time Complexity**
O(n^m)

## :round_pushpin: **Logic**
시작위치 1, 깊이 0으로 한 백트래킹 함수를 호출한다.

- 깊이가 m에 도달하면 출력을 한다.
```java
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
```

- start부터 n까지의 숫자 탐색하기
```java
        for (int i = start; i <= n; i++) {
            arr[depth] = i;    // 현재 깊이의 위치에 i 저장
            dfs(i, depth + 1); // 다음 깊이로 이동, 중복 허용을 위해 i를 다시 시작 위치로 사용
        }
```

## :black_nib: **Review**
- 

## 📡**Link**
- https://www.acmicpc.net/problem/15652 
