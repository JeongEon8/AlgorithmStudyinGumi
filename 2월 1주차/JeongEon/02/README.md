# [백준 - 실버 4] 1015. 수열 정렬

## ⏰ **time**
15분

## :pushpin: **Algorithm**
정렬

## ⏲️ **Time Complexity**
$O(N \log N)$

## :round_pushpin: **Logic**
1. 수열 A의 값과 **원래 인덱스**를 `pair<int, int>` 형태로 함께 저장한다.
2. 값을 기준으로 pair 배열을 오름차순 정렬한다.
3. 정렬된 결과에서
   * 각 원소가 **정렬 전 어느 위치에 있었는지**를 이용해
   * 해당 원소가 정렬 후 차지하는 인덱스를 배열 `B`에 저장한다.
4. 배열 `B`를 순서대로 출력하면 문제에서 요구하는 수열을 얻을 수 있다.

```
A[i] = (값, 원래 인덱스)
A 정렬

for i = 0 to N-1:
    B[원래 인덱스] = i
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/1015](https://www.acmicpc.net/problem/1015)
