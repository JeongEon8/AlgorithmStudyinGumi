# [백준 - 실버 5] 1251. 단어 나누기

## ⏰**time**
5분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 문자열을 3부분으로 나누기 위해 두 분할점 `i`, `j`를 정한다.

   * 첫 번째 구간: `0 ~ i`
   * 두 번째 구간: `i+1 ~ j`
   * 세 번째 구간: `j+1 ~ 끝`
2. 각 구간을 각각 뒤집어서 이어 붙인 문자열 `val`을 만든다.
3. 가능한 모든 `(i, j)` 조합에 대해 위 과정을 수행한다.
4. 만들어진 문자열들 중 사전순으로 가장 앞서는 값을 `result`에 저장한다.
5. 최종적으로 `result`를 출력한다.

```cpp
result = "{";

for (int i = 0; i < input.size() - 2; i++) {
    for (int j = i + 1; j < input.size() - 1; j++) {
        string val;

        for (int u = i; u >= 0; u--) val += input[u];
        for (int u = j; u > i; u--) val += input[u];
        for (int u = input.size() - 1; u > j; u--) val += input[u];

        if (result > val) result = val;
    }
}
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/12510](https://www.acmicpc.net/problem/1251)

[https://www.acmicpc.net/problem/1251](https://www.acmicpc.net/problem/1251)
