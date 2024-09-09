# [백준 - 골드 3] 1600. 말이 되고픈 원숭이
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. 원숭이가 이동할 수 있는 4방향하고 말이 이동할 수 있는 8방향을 두개의 배열 생성

2. 말의 능력을 몇번 사용해서 방문 했는지 3차원 배열 생성

3. bfs 말의 능력이 있을때는 말의 능력과 원숭이 능력을 큐에 저장하고 하나씩 탐색
    
4. 오른쪽 아래에 도착하면 결과를 출력해준다
```java
public static int bfs() {
		Monkey monkey = new Monkey();
		monkey.k =K;
		monkey.w = 0;
		monkey.h = 0;
		monkey.count =0;
		
		Queue<Monkey> que = new ArrayDeque<>();
		que.offer(monkey);
		int result =-1;
		
		while(!que.isEmpty()) {
			monkey = que.poll();
			int k = monkey.k;
			int w = monkey.w;
			int h = monkey.h;
			int count =monkey.count;
			
			if(w==W-1 && h ==H-1) {
				result=count;
				break;
			}

			
			if(k>0) { // 말의 능력 있을때
				for(int d = 0; d<8; d++) {
					int nw = w + dwH[d];
					int nh = h + dhH[d];
					if(nw < 0 || nh < 0 || nw>=W || nh>=H) { // 맵 밖으로 벗어 날때
						continue;
					}
					if(map[nh][nw] ==0) {
						if(isSelected[nh][nw][k-1]==false) {
							isSelected[nh][nw][k-1]=true;
							monkey = new Monkey();
							monkey.k =k-1;
							monkey.w = nw;
							monkey.h = nh;
							monkey.count =count+1;
							que.add(monkey);
						
						
					}
					
				}
			}
			}
			for(int d =0; d<4; d++) {
				int nw = w + dwM[d];
				int nh = h + dhM[d];
				if(nw < 0 || nh < 0 || nw>=W || nh>=H) { // 맵 밖으로 벗어 날때
					continue;
				}
				if(map[nh][nw] ==0) {
					if(isSelected[nh][nw][k]==false) {
						isSelected[nh][nw][k]=true;
						monkey = new Monkey();
						monkey.k =k;
						monkey.w = nw;
						monkey.h = nh;
						monkey.count =count+1;
						que.add(monkey);
						
					}
					
				}
				
			}
			
		
		}
		return result;
			
	}
```

## :black_nib: **Review**
- 처음에 방문처리를 어떻게 해야할지 몰라서 고민하다가 주변사람들 도움으로 해결했어요

## 📡 Link
https://www.acmicpc.net/problem/1600
