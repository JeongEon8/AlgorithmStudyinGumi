# [백준 - S2] 11123. 양 한마리... 양 두마리...


## ⏰ **time**
20분

## :pushpin: **Algorithm**
그래프 이론

## ⏲️**Time Complexity**
O(h*w)

## :round_pushpin: **Logic**
1. 각 테스트 케이스에서 2차원 배열 map 입력
2. 방문 여부 체크용 visited 배열 준비 
3. 모든 칸 (i,j)를 탐색 
   - map[i][j] == '#'이고 방문하지 않았으면 
   - DFS 시작 → 인접 '#' 연결 모두 방문 처리 
   - DFS 호출 후 카운트 증가 
4. 최종적으로 DFS 호출 횟수 = 서로 연결된 '#' 덩어리(그룹) 수 출력

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/11123
