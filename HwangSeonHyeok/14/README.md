# [백준 - s5] 25644. 최대 상승

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 구현
- 다이나믹 프로그래밍
- 그리디 알고리즘

## :round_pushpin: **Logic**

몇몇 예외처리를 하고 점수랭킹을 내림차순으로 정렬하고 자신의 점수가 랭커 이상이되는 등수를 찾는다.

```java
int[] benefit = new int[n];
for (int i = 1; i < n; i++) {
    int stock = Integer.parseInt(split[i]);
    if (min > stock) {
        min = stock;
    }
    benefit[i] = Math.max(benefit[i - 1], stock - min);
}
```

## :black_nib: **Review**

완전히 같은 문제를 푼적이 있는거 같은데..?

## 📡**Link**

https://www.acmicpc.net/problem/25644
