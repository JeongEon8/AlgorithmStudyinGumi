# [백준 - 실버 3] 2193. 이친수

## ⏰**time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. `pinary_num[i]`를 i자리 이친수의 개수라고 정의
2. 점화식은 다음과 같다:

   * `pinary_num[1] = 1` (이친수: 1)
   * `pinary_num[2] = 1` (이친수: 10)
   * 그 이후는 피보나치 수열과 같음:
     [
     pinary_num[n] = pinary_num[n-1] + pinary_num[n-2]
     ]
   * 이유: 끝이 `0`으로 끝나는 경우와 `10`으로 끝나는 경우로 나뉘기 때문

```
pinary_num[1] = 1
pinary_num[2] = 1
for i in 3 to N:
    pinary_num[i] = pinary_num[i - 1] + pinary_num[i - 2]
```

## :black_nib: **Review**
* 피보나치 수열을 활용한 아주 대표적인 DP 문제라 로직이 익숙했다.
* 0으로 시작하지 않는 조건, 1이 연속으로 두 번 오면 안 된다는 조건도 DP에 잘 녹아 있어 인상 깊었음.

## 📡 Link
[https://www.acmicpc.net/problem/2193](https://www.acmicpc.net/problem/2193)
