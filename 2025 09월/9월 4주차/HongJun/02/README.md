# [백준- S3] 1463. 1로 만들기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- dp 테이블에 들어가는 값은 i가 1이 되기 위한 최소한의 연산 횟수이다.
- 1을 뺀 경우를 가장 먼저 생각해야 하기 때문에 그 i-1번 째 값에 +1을 해준다
- 그리고 3으로 나누어 떨어질 때, i를 3으로 나눈 몫의 숫자에 있는 값에 +1을 한 것과 비교해서 더 작은 값으로 갱신한다.
- 2로 나누어 떨어질 때도 마찬가지


## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1463
