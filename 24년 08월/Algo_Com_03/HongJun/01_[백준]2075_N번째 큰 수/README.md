# [백준 S2] 2075. N번째 큰 수
 
## ⏰  **소요 시간**
30분

## :pushpin: **Algorithm**
우선 순위 큐

## ⏲️**Time Complexity (시간 복잡도)**
$O(N*N)$

## :round_pushpin: **Logic**
입력하는 숫자를 모두 우선순위 큐로 넣어서 N번째로 큰 수를 찾는 방식으로 하면 메모리 초과가 된다.
그래서 첫 한 줄을 heapq에 push하고 2번 째 줄부터 원소를 넣을 때 조건을 추가해야한다.
- 기존에 있는 heapq의 가장 앞(최솟값)이 추가할 숫자보다 작으면 pop으로 삭제한다.
- 그리고 숫자를 push한다.
- 이 과정을 반복하면 가장 큰 수 N개까지만 우선순위 큐에 저장된다.
- N번째 큰 수를 출력하니까 큐의 가장 앞에 있는 값을 출력하면 정답!

## :black_nib: **Review**
- 입력이 -10억 부터 10억이기 때문에 이걸 다 배열로 저장하면 메모리초과가 난다.
- 이걸 몰랐넹 ㅋㅅㅋ;;

## 📡 Link
https://www.acmicpc.net/problem/2075