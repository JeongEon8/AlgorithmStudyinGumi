# [SWEA - D3] 2805. 농작물 수확하기

## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현, 완전탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. maps 배열에 수확량 정보 입력
```java
            int[][] maps = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                String str = st.nextToken();
                for(int j = 0; j < N; j++) {
                    maps[i][j] = str.charAt(j) - '0';
                }
            }
```
2. 마름모 중간(모든 행을 확인하는 열)의 수확량 저장
```java
            int profit = 0;
            for(int j = 0; j < N; j++) {
                profit += maps[N/2][j];
            }
```
3. 2번에서 확인한 열을 제외하고 대칭으로 수확량 확인
4. 열의 중간 행을 profit에 더하고, 거기서부터 왼쪽 오른쪽으로 확인할 칸 확인 
```java
            for(int i = 0; i < N/2; i++) {
                profit += maps[i][N/2];
                profit += maps[N-1-i][N/2];
                for(int j = 1; j <= i; j++) {
                    profit += maps[i][N/2-j];
                    profit += maps[i][N/2+j];
                    profit += maps[N-1-i][N/2-j];
                    profit += maps[N-1-i][N/2+j];
                }
            }
```


## :black_nib: **Review**
- 조금 생각하니까 풀린 문제 야호 !

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do
