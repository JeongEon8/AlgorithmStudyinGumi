# [PGS - LV3] 01\_연속 펄스 부분 수열의 합

## ⏰**time**

30분

## :pushpin: **Algorithm**

누적합

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 펄스 수열은 2가지 형태가 있는데, 둘의 관계가 `-1`을 곱한 것과 같음
   - `type A = K`라면 `type B = -K`
2. 구간 합은 $S[j] - S[i-1]$ 이므로 구간 합을 가장 크게 만들려면 최대에서 최소를 빼주어야 한다.

```java
for (int i = 0; i < sequence.length; i++) {
    int pulse = (i % 2 == 0) ? 1 : -1;

    sum += (long) sequence[i] * pulse;

    max = Math.max(max, sum);
    min = Math.min(min, sum);
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/161988>
