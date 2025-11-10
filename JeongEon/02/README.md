# [백준 - 실버 5] 1439. 뒤집기

## ⏰**time**

5분

## :pushpin: **Algorithm**

그리디, 문자열 탐색

## ⏲️**Time Complexity**

$O(N)$

* 문자열 한 번 순회

## :round_pushpin: **Logic**

1. 주어진 문자열 `s`는 0과 1로만 구성됨.
2. 문자열을 앞에서부터 순회하면서 **인접한 값이 바뀌는 지점**을 세어줌.
3. 바뀌는 횟수는 그룹의 경계 개수이므로,
   `0 → 1`, `1 → 0` 전환이 생길 때마다 `result++`
4. 최종 뒤집는 최소 횟수는 **그룹 개수 / 2**

   * 예: `"0001100"`은 `[000][11][00]`로 3개 그룹 → 2번만 바꾸면 됨
5. 예외적으로 바뀐 적이 없으면(모두 동일한 값) → 뒤집기 0회

```
for i in 0 to s.length():
    if s[i] != s[i+1]:  // 다음 문자와 다르면 경계
        result += 1

if result == 0:
    print(0)
else:
    print(result // 2)
```

## :black_nib: **Review**

* 가장 간단한 그리디 문제 중 하나였음.
* 그룹 경계를 기준으로 바뀐 횟수만 세고, 최소 연산만 해주면 끝!
* 비슷한 유형의 문자열 문제를 처음 접하는 사람에게 강력 추천할 만한 문제.

## 📡 Link

[https://www.acmicpc.net/problem/1439](https://www.acmicpc.net/problem/1439)
