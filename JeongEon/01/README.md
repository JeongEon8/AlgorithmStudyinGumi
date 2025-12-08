# [백준 - 실버 2] 1406. 에디터

## ⏰**time**
25분

## :pushpin: **Algorithm**
* 스택 (Stack)
* 시뮬레이션

## ⏲️**Time Complexity**
$O(M)$

## :round_pushpin: **Logic**
1. **커서 위치**를 기준으로 문자열을 왼쪽과 오른쪽 두 부분으로 나누고, 각각 `left`, `right` 스택에 저장
2. 명령어를 다음과 같이 처리:

   ```
   L → 왼쪽 스택의 top을 오른쪽 스택으로 이동
   D → 오른쪽 스택의 top을 왼쪽 스택으로 이동
   B → 왼쪽 스택에서 pop
   P → 왼쪽 스택에 push
   ```
3. 마지막 출력 시:

   * 왼쪽 스택의 모든 문자들을 오른쪽 스택으로 옮긴 후,
   * 오른쪽 스택을 출력하면 최종 문자열 완성

```
초기 문자열 → left 스택에 저장
명령어 반복:
  L: left → right 이동
  D: right → left 이동
  B: left pop
  P x: left push x
출력:
  left → right 옮기고
  right에서 pop하며 출력
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/1406](https://www.acmicpc.net/problem/1406)
