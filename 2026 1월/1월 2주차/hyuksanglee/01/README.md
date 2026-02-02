# [백준 - 골드 5] 7569. 토마토

## ⏰**time**
40분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(N x M x H)$

N : 가로길이 , M : 세로길이, H : 층수
## :round_pushpin: **Logic**
1. 전체 토마토를 담을수 있는 변수 total을 만들어준다.
2. 3차원 배열에 하나씩 넣어주는데 1인경우 큐에 넣어준다.
   - 넣어줄때 -1이거나 1인경우 total에서 -1해준다.
```java
for(int h =0 ; h<H; h++) {
			for(int m = 0; m<M; m++) {
				input = in.readLine().split(" ");
				for(int n = 0; n<N; n++) {
					int num = Integer.parseInt(input[n]);
					map[h][m][n] = num;
					if(num == -1) {
						total--;
					}
					if(num == 1) {
						Point p = new Point(h, m, n,1);
						que.add(p);
						total--;
					}
				}
			}
		}
```

3. 큐에서 하나씩 꺼내서 주변 (동, 서, 남, 북, 상, 하) 탐색하여 0인경우 숫자를 넣어준다. 숫자는 큐에 있던 숫자에서 +1해서 넣어준다.
   - +1해주는 이유는 날짜를 체크하기위해
4. 값을 추가해줄때 마다 total을 -1을 해준다.
```java
while(!que.isEmpty()) {
		   Point po = que.poll();
		   for(int d = 0; d<6; d++) {
			   int cn = po.n + dn[d];
			   int cm = po.m + dm[d];
			   int ch = po.h + dh[d];
			   
			   if(cn <0 || cm<0 || ch <0 || cn>=N || cm >= M || ch >=H) {
				   continue;
			   }
			   if(map[ch][cm][cn] == 0) {
				   total--;
				   map[ch][cm][cn] = po.t+1;
				   if(type < po.t+1) {
					   type = po.t+1;
				   }
				   Point ppo = new Point(ch, cm, cn, po.t+1);
				   que.add(ppo);
			   }
		   }
		   
	   }
```

5. total이 0일경우 날짜를 출력하고 아닐경우 -1 출력
```java
if(total <=0) {
			System.out.println(type-1);
		}else {
			System.out.println(-1);
		}
```


## :black_nib: **Review**
- 처음에는 bfs를 안 사용하고 for문으로 처리 하려고 했지만 시간초과 뜸

## 📡 Link
https://www.acmicpc.net/problem/7569
