# [백준 - S4] 13699. 점화식

## ⏰ **time**
5분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1. `t[0]`에 기본값 1을 넣어준다
2. 딱히 로직..이랄 게 없습니다 사실..
```java
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                t[i] += t[j] * t[i-1-j];
            }
        }
```


## :black_nib: **Review**  
저는 DP가 싫어요~ 그래서 쉬운 점화식을 풀었어요~ 우리 이제 그만 서먹하자~

## 📡**Link**
https://www.acmicpc.net/problem/13699  
