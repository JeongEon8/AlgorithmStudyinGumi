# [백준 - 골드 4] 27172. 수 나누기 게임

## ⏰**time**

35분

## :pushpin: **Algorithm**

- 에라토스테네스/배수 순회
- 배열 인덱스로 존재 여부 체크

## ⏲️**Time Complexity**

$O(N + \max \cdot \log \max)$ (최대값 기준 배수 순회)

## :round_pushpin: **Logic**

1. 입력 수들을 배열에 넣고, 값이 등장했는지 `present[값]`으로 체크합니다. 동시에 `max`를 구합니다.

```
int[] a = new int[N];
boolean[] present = new boolean[1_000_001];
for (int i = 0; i < N; i++) {
    a[i] = Integer.parseInt(st.nextToken());
    present[a[i]] = true;
    max = Math.max(max, a[i]);
}
```

2. 각 수 `x`에 대해, `x`의 배수만 봅니다. `m = 2*x, 3*x, ...` 중에서 배열에 있는 `m`이 있으면, 그때 `x`가 이기는 관계이므로 `score[x]++`, `score[m]--` 합니다.

```
for (int x : a) {
    for (int m = x * 2; m <= max; m += x) {
        if (present[m]) {
            score[m]--;
            score[x]++;
        }
    }
}
```

3. 수 나누기 게임 규칙상, 작은 수가 큰 수(자신의 배수)를 이기므로, 각 수 `x`의 점수는 **배열에 있는 `x`의 배수의 개수**와 같습니다. 위에서 배수만 돌면서 "x가 m을 이길 때"만 반영한 것입니다. 최종적으로 각 `a[i]`의 `score[a[i]]`를 공백으로 구분해 출력합니다.

```
StringBuilder sb = new StringBuilder();
for (int i = 0; i < N; i++) {
    sb.append(score[a[i]]);
    if (i + 1 < N) sb.append(' ');
}
System.out.println(sb);
```

## :black_nib: **Review**

- 단순하게 $n^2$으로 이중 포문을 돌리면 시간 초과가 날 수 있다..

## 📡 Link

https://www.acmicpc.net/problem/27172
