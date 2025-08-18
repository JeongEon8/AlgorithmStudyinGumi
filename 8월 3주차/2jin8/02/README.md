# [백준 - G3] 16637. 괄호 추가하기

## ⏰**time**
40분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(2^(N/2))$

## :round_pushpin: **Logic**
- N이 최대 19 → 부분 집합 사용하면 될 것 같음
- 부분 집합 나누기 = 괄호를 묶거나 묶지 않기
  - 괄호를 묶는 경우: 현재 숫자랑 다음 숫자 연산 후 `total`과 연산한 뒤, 재귀호출
    - 이때, depth를 2 증가시키기
  - 괄호를 묶지 않는 경우: 현재 숫자랑 `total` 연산한 뒤, 재귀호출
- 주의할 점
  1. `-` 연산을 수행하면 음수가 나올 수 있음
  ⇒ 최댓값을 구하는 변수 초기화 시 0이 아니라 `Integer.MIN_VALUE`처럼 초기화 해야 함
  2. `N = 1`이면 입력받은 값을 그냥 출력해야 함
```
static void dfs(int depth, int total) {
    if (depth == M) {
        answer = Math.max(answer, total);
        return;
    }

    // 마지막이면 그냥 total이랑 연산
    if (depth == M - 1) {
        dfs(depth + 1, getTotal(total, numbers[depth], calc[depth - 1]));
        return;
    }

    // 괄호 묶기 O == 현재 숫자랑 다음 숫자랑 연산하기
    int temp = getTotal(numbers[depth], numbers[depth + 1], calc[depth]);
    char totalCalc = depth == 0 ? '+' : calc[depth - 1]; // total이랑 더할 연산 구하기
    dfs(depth + 2, getTotal(total, temp, totalCalc));

    // 괄호 묶기 X == 현재 숫자만 연산하기
    dfs(depth + 1, getTotal(total, numbers[depth], totalCalc));
}
```

## :black_nib: **Review**
초기화 할 때 무조건 0으로 주지말기.. 문제에 따라 다르니까 주의할 것

## 📡 Link
https://www.acmicpc.net/problem/16637
