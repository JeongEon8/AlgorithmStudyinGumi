# [백준 - G4] 1987. 알파벳

## ⏰  **time**
20분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(3^26)$

## :round_pushpin: **Logic**
1. int형 배열로 'A' 뺀 값 삽입, alpha 배열로 방문 알파벳 여부 담을 배열 생성
```java
boolean[] alpha = new boolean[26];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++) {
                maps[i][j] = str.charAt(j) - 'A';
            }
        }
```
2. 현재까지 파악한 length와 answer 크기를 비교해서 큰 값으로 업데이트
3. 4방향으로 이동하고, 방문하지 않은 알파벳이라면 true 로 바꾸고 recur 함수 호출, 빠져나오면 false 처리
```java
    static void recur(boolean[] alpha, int x, int y, int length) {
        if(length > answer) answer = length;
        if(x < 0 || x >= R || y < 0 || y >= C) return;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0 ; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            if(alpha[maps[nx][ny]] == false) {
                alpha[maps[nx][ny]] = true;
                recur(alpha, nx, ny, length+1);
                alpha[maps[nx][ny]] = false;
            }
        }
    }
```


## :black_nib: **Review**
- 생각보다 간단했던 골드 문제 ! 다행히 안 터진다

## 📡**Link**
- https://www.acmicpc.net/problem/1987
