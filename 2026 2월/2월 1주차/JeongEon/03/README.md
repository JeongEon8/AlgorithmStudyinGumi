# [백준 - 실버 5] 9656. 돌 게임 2

## ⏰ **time**
5분

## :pushpin: **Algorithm**
수학

## ⏲️ **Time Complexity**
$O(1)$

## :round_pushpin: **Logic**
1. 돌의 개수 `n`이 주어진다.
2. 플레이어는 한 번에 1개 또는 3개의 돌을 가져갈 수 있다.
3. 직접 작은 값부터 경우를 나열해보면 다음과 같은 규칙을 발견할 수 있다.

   * `n`이 **짝수**일 때 → 상근이(SK) 승리
   * `n`이 **홀수**일 때 → 창영이(CY) 승리
4. 따라서 `n % 2`의 결과에 따라 승자를 바로 출력하면 된다.

```
if n % 2 == 0:
    print("SK")
else:
    print("CY")
```

## :black_nib: **Review**
- 난 이런 문제만 있으면 좋겠어! 제발~~

## 📡 Link
[https://www.acmicpc.net/problem/9656](https://www.acmicpc.net/problem/9656)
