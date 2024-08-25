# [백준 - s5] 28282. 운명

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학

## :round_pushpin: **Logic**

왼쪽 오른쪽 각각의 색의 양말 개수를 기록하고 왼발의 양말과 오른발의 색이 같지 않은 양말의 곱의 합을 구하면 된다.

```java
   long ans = 0;
    for (int i = 1; i <= k; i++) {
        ans += leftCnt[i] * (x - rightCnt[i]);
    }

```

## :black_nib: **Review**

문제 이름이 왜 운명일까

## 📡**Link**

- https://www.acmicpc.net/problem/28282
