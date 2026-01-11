# [백준 - 실버 3] 1051. 숫자 정사각형

## ⏰**time**
20분

## :pushpin: **Algorithm**
브루트포스 (완전 탐색)

## ⏲️**Time Complexity**
$O(N \times M \times \min(N, M))$
(모든 좌표에서 가능한 정사각형 한 변의 길이를 탐색)

## :round_pushpin: **Logic**
1. 입력으로 주어진 숫자판을 2차원 배열에 저장한다.
2. 만들 수 있는 정사각형의 최대 변 길이는 `min(N, M)`이다.
3. 변의 길이를 1부터 최대 길이까지 늘려가며 탐색한다.
4. 각 위치 `(i, j)`를 정사각형의 왼쪽 위 꼭짓점으로 잡고,

   * `(i, j)`
   * `(i + len - 1, j)`
   * `(i, j + len - 1)`
   * `(i + len - 1, j + len - 1)`
     네 꼭짓점의 숫자가 모두 같은지 확인한다.
5. 조건을 만족하면 해당 변의 길이를 최댓값으로 갱신한다.
6. 최종적으로 **가장 큰 정사각형의 넓이 (`변의 길이²`)**를 출력한다.

```
for len = 1 to min(N, M)
    for i = 0 to N - len
        for j = 0 to M - len
            네 꼭짓점의 값이 같은지 확인
            같다면 최대 길이 갱신
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/1051](https://www.acmicpc.net/problem/1051)
