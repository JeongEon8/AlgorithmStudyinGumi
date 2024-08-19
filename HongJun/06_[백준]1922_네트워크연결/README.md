# [백준 G4] 1922. 네트워크 연결
 
## ⏰  **소요 시간**
40분

## :pushpin: **Algorithm**
MST, 크루스칼, 유니온파인드

## ⏲️**Time Complexity (시간 복잡도)**
$O(N logN)$

## :round_pushpin: **Logic**
- 유니온 파인드를 사용해서 크루스칼 알고리즘으로 풀면 된다.
- 비용이 최소이기 때문에 입력받은 비용을 기준으로 정렬을 한다.
- 비용이 작은 정점부터 추가하면서 부모를 공유하지 않는 사이클이 생기지 않을 때만 비용을 더해준다.

## :black_nib: **Review**
MST 문제 더 많이 풀어보자

## 📡 Link
https://www.acmicpc.net/problem/1922
