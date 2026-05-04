# [백준 - S5] 2740. 행렬 곱셈

## ⏰  **time**
30분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(N*M*K)$

## :round_pushpin: **Logic**
1. 첫 번째 행렬(A)의 값 담기
```java
        int[][] matrixA = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
```
2. 두 번째 행렬(B)의 값 담기
```java
        int[][] matrixB = new int[M][K];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < K; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
```
3. 행렬 곱셈의 계산법대로 A의 행과 B의 열을 곱해서 더하기, sum을 sb에 붙이기
```java
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                int sum = 0;
                for(int l = 0; l < M; l++) {
                    sum += matrixA[i][l] * matrixB[l][j];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }
```


## :black_nib: **Review**
- 문제는 안 어려운데 오랜만에 본 행렬 곱셈이 너무 낯설었다..!

## 📡 Link
https://www.acmicpc.net/problem/2740
