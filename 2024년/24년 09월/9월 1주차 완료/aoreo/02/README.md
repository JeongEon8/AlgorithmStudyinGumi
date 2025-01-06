# [백준 - 실버 3] 14501.퇴사
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
재귀

## ⏲️**Time Complexity**
$O(2^N)$

## :round_pushpin: **Logic**
1. 0일부터 시작하여, day가 N이 될 때까지 재귀를 반복한다.
2. 재귀의 파라미터로 날짜와 수익을 넘기는데, 했을 경우, 날짜는 현재 날짜(day)+소요일을 넘기고, 수익은 현재까지의 수익(sum_)+수익을 넘긴다.
3. 하지 않을 경우, day+1과 현재까지의 sum을 넘긴다.
4. 모든 날짜에 대해 하지 않는 경우를 호출하고, 하는 것이 가능할 경우, 하는 경우의 재귀 함수도 호출한다.


## :black_nib: **Review**
- 뽑히지 않은 사람들을 어떻게 구하지?가 고민부분이었다. 뭔가 더 깔끔하게 뽑아내는 방법이 있었을까?

## 📡 Link
[https://www.acmicpc.net/problem/14501](https://www.acmicpc.net/problem/14501)
