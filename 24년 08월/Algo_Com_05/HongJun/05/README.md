# [백준 G4] 11404. 플로이드
 
## ⏰  **소요 시간**
30분

## :pushpin: **Algorithm**
플로이드 워셜

## ⏲️**Time Complexity (시간 복잡도)**
$O(N^3)$

## :round_pushpin: **Logic**
- 조건에서 간선의 개수가 많기 때문에 플로이드로 풀면 된다.
- 도시 번호와 인덱스를 맞추기 위해서 +1을 하기 떄문에 조건대로 잘 구현해야한다.
- 각 도시의 노선이 중복될 수 있기 때문에 더 적은 비용의 노선으로 갱신해줘야한다.

## :black_nib: **Review**
처음에 문제 조건에 노선 중복을 못 봐서 결과값이 다르게 나왔다.

## 📡 Link
https://www.acmicpc.net/problem/11404