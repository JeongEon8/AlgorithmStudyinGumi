# [백준- G3] 1005. ACM Craft
 
## ⏰  **time**
70분

## :pushpin: **Algorithm**
위상정렬

## ⏲️**Time Complexity**
$O(N + K)$

## :round_pushpin: **Logic**
- 선행 건물이 지어졌는지 판단하고 지어졌으면 최대시간을 골라서 해당 건물 건설 시간을 더해준다.
  	1. 위상 정렬을 사용해서 차수에 선행 건물이 있을때 마다 1을 더해준다.
  	2. 선행 건물이 없는거부터 큐에 넣는다.
  	3. 큐에서 하나씩 뽑는다
  	4. 다음 건물에 시간 계산
  	5. 다음 건물에 선행 건물 수 차감
  	6. 2~5 반복

```java
	// 위상정렬
	while(!que.isEmpty()) {
				int test = que.poll();
				
				
				for (int num : order[test]) {
					
					total[num] = Math.max(total[num], total[test] + D[num]);
                    degree[num]--;
					if(degree[num]==0) {
						que.add(num);
					}
				}
				
			}
```

## :black_nib: **Review**
- 처음에는 bfs로 풀었는데 메모리 초과떠서 멘붕왔다가 다시 풀었어요. 다음에는 메모리 계산하고 풀게요.

## 📡**Link**
- https://www.acmicpc.net/problem/1005
