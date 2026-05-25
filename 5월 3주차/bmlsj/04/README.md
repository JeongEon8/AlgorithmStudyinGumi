# [PGS - Lv2] 04\_점 찍기

## ⏰**time**

30min

## :pushpin: **Algorithm**

수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- $x^2+y^2 ≤ d^2$ 원 안에 있는 점의 갯수를 구하는 문제
- x를 고정한 후, $y^2 <= d^2 - x^2$를 만족하는 y를 구하기
- y 중에 k의 배수인 것을 구하기 위해 k로 나눈 후, 0을 포함하기 위해 `+1`

```java
for (long x = 0; x <= d; x += k) {
    long y = (long)Math.sqrt((long)d*d - x*x);
    answer += y / k + 1;
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/140107>
