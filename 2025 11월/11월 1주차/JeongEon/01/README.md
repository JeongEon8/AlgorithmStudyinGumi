# [백준 - 실버 2] 9184. 신나는 함수 실행

## ⏰**time**

20분

## :pushpin: **Algorithm**

재귀 + 메모이제이션 (Top-down DP)

## ⏲️**Time Complexity**

$O(20^3)$

* 중복 호출 없이 최대 9261개의 상태만 계산

## :round_pushpin: **Logic**

1. 문제의 함수 `w(a, b, c)`는 여러 조건 분기로 나뉘는 **재귀 함수**로 정의되어 있음.
2. 인자 `a, b, c`의 값이 0보다 작으면 1을 반환하고, 20보다 크면 20으로 처리하여 범위를 고정함.
3. 이미 계산된 값은 `store[a][b][c]`에 저장하고, 재계산하지 않도록 함 → **메모이제이션** 사용.
4. 점화식은 다음과 같음:

   * `w(a, b, c) = w(a, b, c−1) + w(a, b−1, c−1) − w(a, b−1, c)`  if `a < b < c`
   * 그 외: `w(a−1, b, c) + w(a−1, b−1, c) + w(a−1, b, c−1) − w(a−1, b−1, c−1)`
5. 종료 조건: `a == b == c == -1` 이 입력되면 프로그램 종료

```
if a <= 0 or b <= 0 or c <= 0:
    return 1
if a > 20 or b > 20 or c > 20:
    return w(20, 20, 20)
if memo[a][b][c] != 0:
    return memo[a][b][c]
if a < b < c:
    memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
else:
    memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
return memo[a][b][c]
```

## :black_nib: **Review**

* 3차원 메모이제이션 문제지만, 범위가 작아 재귀 + 배열로 무난하게 해결됨.
* 중복 호출을 캐시로 방지하지 않으면 시간 초과 → **탑다운 방식 + 캐싱**의 효과를 잘 보여주는 문제였다.
* 포맷에 맞춰 출력 형태를 `"w(a, b, c) = 결과"`로 잘 맞춰주는 것도 중요 포인트!

## 📡 Link

[https://www.acmicpc.net/problem/9184](https://www.acmicpc.net/problem/9184)
