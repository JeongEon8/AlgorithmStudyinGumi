# [백준 - S3] 14501. 퇴사

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 뒤에서 부터 해당 일에 일을 했을 떄 vs 안했을 때 얻을 수 있는 값을 비교해서 최대값을 저장한다.
- 하지만 해당 일에서 걸리는 기간을 더한 값이 N보다 크면 일을 할 수 없다.
- 그 조건을 달아서 가능한 경우에는 n번째 날에 일을 했을 때, 안했을 때 벌 수 있는 돈을 비교하면 된다.

## :black_nib: **Review**
- 탑다운으로는 생각을 못했다.

## 📡**Link**

https://www.acmicpc.net/problem/14501