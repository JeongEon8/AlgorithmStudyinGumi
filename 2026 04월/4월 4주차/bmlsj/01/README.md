# [PGS - lv2] 점프와 순간 이동

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

`0 -> n`으로 갔더니 시간초과가 발생했다. `n -> 0`으로 반대로 진행

1. 순간이동일 경우 `/2`
2. 점프면 `-1`과 동시에 비용도 `+1` 한다.

```java
while (n > 0) {
    if (n % 2 == 1) {
        ans++;   // 점프
        n--;
    } else {
        n /= 2;  // 순간이동
    }
}
```

- 비트 카운팅도 가능하다고 함. 비트 카운팅은 1의 개수를 세는 것

```java
public int solution(int n) {
    return Integer.bitCount(n);
}
```

## :black_nib: **Review**

프로그래머스에서 벗어나고 싶다.. 먼가 별룽..

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12980>
