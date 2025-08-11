# \[백준 - 실버 1] 14888. 연산자 끼워넣기

## ⏰  **time**

25분

## \:pushpin: **Algorithm**

백트래킹(DFS)

## ⏲️**Time Complexity**

\$O(\text{perm})\$

* 최대 $N-1$개의 연산자 순열 탐색.
* 상한: $(N-1)!\ /\ \prod_{op} (cnt_{op}!)$
  (연산자 중복을 고려한 순열 수)

## \:round\_pushpin: **Logic**

1. 숫자 배열 `arr`와 각 연산자 개수 `operators[4]` 입력.
2. `getanswer(result, idx)`로 DFS:

   * `idx`번째 숫자를 사용할 차례.
   * 종료 조건: `idx == N`이면 `mmax`, `mmin` 갱신 후 반환.
3. 4개 연산자 중 남은 개수가 있는 연산자를 하나 선택:

   * 개수 1 감소 → 해당 연산 수행해 다음 상태로 진행 → 복구(백트래킹).
4. 나눗셈은 C++ 기본 정수 나눗셈 규칙(0쪽으로 절삭) 그대로 사용.

```cpp
void getanswer(int result, int idx) {
    if (idx == N) {
        mmax = max(mmax, result);
        mmin = min(mmin, result);
        return;
    }
    for (int i = 0; i < 4; i++) if (operators[i] > 0) {
        operators[i]--;
        if (i == 0) getanswer(result + arr[idx], idx + 1);
        else if (i == 1) getanswer(result - arr[idx], idx + 1);
        else if (i == 2) getanswer(result * arr[idx], idx + 1);
        else            getanswer(result / arr[idx], idx + 1); // 정수 나눗셈
        operators[i]++; // 복구
    }
}
```

## \:black\_nib: **Review**

* 연산자 개수 소진/복구만 깔끔히 하면 실수할 데가 거의 없음.
* 최댓값·최솟값 초기값을 넉넉하게 잡아 둔 게 심리적 안정 🧘‍♂️

## 📡 Link

[https://www.acmicpc.net/problem/14888](https://www.acmicpc.net/problem/14888)
