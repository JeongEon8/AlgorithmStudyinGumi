# [백준 - 실버 5] 1436. 영화감독 숌

## ⏰**time**

약 20분

## :pushpin: **Algorithm**

Brute Force

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

666이 포함된 수에서 N번째 작은 수를 구하는 문제
ex) 6 -> 5666, 7 -> 6660

1. 숫자 num을 계속 증가시키면서 666을 포함한다면 cnt를 증가시킨다.
2. cnt가 N과 같다면 멈춘다.

```java
int num = 666;
int cnt = 0;
while (true) {

    if (String.valueOf(num).contains("666")) {
        cnt++;
    }

    if (cnt == N) {
        System.out.println(num);
        break;
    }

    num++;
}
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/1436>
