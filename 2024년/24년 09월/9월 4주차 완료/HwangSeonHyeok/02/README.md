# [백준 - g5] 13549. 숨바꼭질 3

## ⏰ **time**

40분+@

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 최단 경로
- 데이크스트라
- 0-1 너비 우선 탐색

## :round_pushpin: **Logic**

순간이동엔 시간이 들지 않으므로 2씩곱하면서 모두 방문처리하고 큐에 넣어준다. 순간이동은 항상 커지는 방향으로만 가능하므려 X-1을 X+1보다 먼저 방문하는식으로 방문한다.

```java
  a:while(!q.isEmpty()) {
			int start = q.poll();
			int next;
			int tmp = start;
			//순간이동
			while(tmp<=MAX_IDX/2) {
				next = tmp*2;
				if(!visited[next]) {
					dist[next] = dist[tmp];
					visited[next] = true;
					q.add(next);
					if(next==k) {
						break a;
					}
					tmp*=2;
				}else {
					break;
				}
			}
			//X-1로
			next = start-1;
			if(next>=0&&!visited[next]) {
				dist[next] = dist[start]+1;
				visited[next] = true;
				q.add(next);
				if(next==k) {
					break a;
				}
			}
			//X+1로
			next = start+1;
			if(next<=100000&&!visited[next]) {
				dist[next] = dist[start]+1;
				visited[next] = true;
				q.add(next);
				if(next==k) {
					break a;
				}
			}

		}

```

## :black_nib: **Review**

옛날에 풀다 틀리고 방치해둔 문제.  
이번에도 X+1을 X-1보다 먼저 넣어서 틀렸다.  
증가하는 방향으로 순간이동 하는 경우가 있어서 같은 시간중에선 무조건 index가 작은것부터 넣어야한다.

## 📡**Link**

https://www.acmicpc.net/problem/13549
