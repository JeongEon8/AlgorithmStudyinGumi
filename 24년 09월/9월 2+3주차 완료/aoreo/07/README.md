# [백준 - 실버1] 11403.경로 찾기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
플로이드-워셜

## :round_pushpin: **Logic**
1. i 지점에서 j 지점까지 갈 수 있는지를 확인함
2. graph[i][k] + graph[k][j]는 i에서 j까지 가는 거리임을 이용하여, 갱신하되, 거리는 필요없으므로 1으로 갱신

## :black_nib: **Review**
잘못해서 플로이드 워셜을 쓸 수 있다는 스포를 봐버려서 이번 기회에 써보았다

## 📡 Link
https://www.acmicpc.net/problem/11403
