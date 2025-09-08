# [백준 - S4] 15489. 파스칼 삼각형


## ⏰ **time**
20분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1. r+w줄까지의 정보를 담을 수 있는 삼각형 `dp` 만들기 (2차원 배열 형태)
2. 양끝에 1 삽입 (`dp[i][1] = dp[i][i] = 1;`)
3. 그 사이에 있는 칸들 ... 수를 삽입하기 
4. 그리고 정해진 범위의 합 구하면 됨
```java
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[r + i][c + j];
            }
        }
```

## :black_nib: **Review** 
재밋다

## 📡**Link**
https://www.acmicpc.net/problem/15489
