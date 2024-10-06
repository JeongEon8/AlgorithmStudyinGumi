# [백준 - G5] 11265. 끝나지 않는 파티

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 그래프 이론
- 최단 경로
- 플로이드 워셜

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

플로이드 워셜 알고리즘으로 모든 정점에서 모든 다른정점까지의 최단 거리를 구한다.  
이후 입력받은 출발지부터 목적지 까지의 남은 시간 t가 최단 거리 이하이면 도착 가능 아니면 불가능한 대답을 출력한다.

```java
	for(int mid = 0; mid<n;mid++) {
		for(int start = 0; start<n;start++){
			if(start==mid)continue;
			for(int end = 0; end<n;end++) {
				if(start==end||mid==end) continue;
				dist[start][end] = Math.min(dist[start][end],dist[start][mid]+dist[mid][end]);
			}
		}
	}
	for(int i = 0; i<m;i++) {
		split = in.readLine().split(" ");
		int start = Integer.parseInt(split[0])-1;
		int end = Integer.parseInt(split[1])-1;
		int t = Integer.parseInt(split[2]);
		if(dist[start][end]<=t) {
			sb.append("Enjoy other party\n");
		}else {
			sb.append("Stay here\n");
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11265
