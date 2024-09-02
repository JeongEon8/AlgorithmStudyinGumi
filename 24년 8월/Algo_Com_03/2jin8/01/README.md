# [SWEA - 모의 SW 역량테스트] 5653. 줄기세포배양
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
구현 + 우선순위 큐

## :round_pushpin: **Logic**
- 우선순위 큐를 사용해서 활성화 시간을 기준으로 오름차순, 생명력 시간을 기준으로 내림차순 정렬
- `1 ~ K-1`시간까지 반복문 돌리기
  - 활성화되는 시간이 현재 시간 이후라면 다음 시간으로 넘어가기
  - 활성화되는 시간이 현재 시간과 같다면 네 방향으로 번식하기 
```java
for (int i = 1; i < K; i++) {
	while (!pq.isEmpty()) {
		Cell cell = pq.poll();
		// 활성화되는 시간이 현재 시간 이후라면 다음 시간으로 넘어가야 함
		if (cell.activity > i) {
			pq.offer(cell);
			break;
		}
		
		// 활성화 되는 시간이 현재 시간이라면
		if (cell.activity == i) {
			// 다음 시간에 네 방향으로 퍼짐
			for (int j = 0; j < 4; j++) {
				int nx = cell.x + dx[j];
				int ny = cell.y + dy[j];

				String pos = nx + "," + ny;
				// 해당 위치를 방문하지 않은 경우(= 포함되지 않음)
				if (!visited.contains(pos)) {
					visited.add(pos);
					pq.offer(new Cell(nx, ny, cell.life, i + 1 + cell.life, i + 1 + cell.life * 2));
				}
			}
			
			if (cell.die > K) {
				liveCell.add(cell.x + "," + cell.y);
			}
		}
	}
}
```

## :black_nib: **Review**
어떻게 풀지 모르겠어서 아이디어만 거의 30분 이상 생각한 것 같다. 그리고 잔잔한 실수들을 너무 많이 했다.. 꼭 다시 풀어봐야지..

## 📡**Link**
- [SWEA 5653_줄기세포배양](https://swexpertacademy.com/main/code/problem/problemDetail.do)
