# [백준 - G4] 14938. 서강그라운드

## ⏰ **time**

60분

## :pushpin: **Algorithm**
- 다익스트라

## ⏲️**Time Complexity**

$O(N²)$

## :round_pushpin: **Logic**
1. for 문으로 0부터 n까지 탐색하는데 다익스트라를 이용해서 현재지점에서 모든 지점까지 최소 거리를 구하고 그거리가 수색범위 안에 들면 해당 지역의 아이템 수를 더해 준다.
```java
	private static int dist(int i) {
		
		int total = t[i];
		
		int[] go = new int[n];
		for(int j =0; j< n; j++) {
			go[j] = Integer.MAX_VALUE;
		}
		go[i]= 0;
		
		Queue<Info> que = new ArrayDeque<>();
		Info info = new Info(i,0);
		
		que.add(info);
		while(!que.isEmpty()) {
			Info data = que.poll();
			int num = data.num;
			for(int j = 0; j<n; j++) {
				if(j == num) {
					continue;
				}
				if( map[num][j] != 0 && map[num][j]+ data.sum <= m && go[j]>map[num][j]+ data.sum) {
					if(go[j]==Integer.MAX_VALUE) {
						total+=t[j];
					}
					
					go[j] = map[num][j]+ data.sum;
					
					Info newData = new Info(j,map[num][j]+ data.sum);
					que.add(newData);
				}
			}
		}
		
		return total;
		
	}
```

## :black_nib: **Review**  
- 이문제가 bfs보다 쉬워요
## 📡**Link**
https://www.acmicpc.net/problem/14938
