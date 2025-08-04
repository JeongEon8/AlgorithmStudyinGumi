# [백준- G3] 15685. 드래곤 커브
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(N × 2^g + 10^4)$

## :round_pushpin: **Logic**
- 처음 방향을 이동하고 배열에 저장시키고 역순으로 90도 이동시킨 방향으로 이동후 다시 저장
  	1. 시작점 방문 처리
  	2. d 방향으로 이동시키고 배열에 d 저장
  	3. 배열에 뒤에서 부터 하나씩 뽑고 +1해서 해당 방향에 맞게 이동시키고 방문처리 그리고 해당 방향은 배열에 저장
  	4. 세대수만큼 3번 반복
  	5. map 전체를 탐색해서 4꼭지점이 방문 되어있는지 체크하고 그수 출력하기
  	


```java
	while(g-->0) {
				
				for(int i = arr.size()-1 ; i>=0; i--) {
					int dn = arr.get(i);
					dn++;
					if(dn>3) {
						dn=0;
					}
					x += dx[dn];
					y += dy[dn];
					map[y][x]= true;
					arr.add(dn);
				}
				
				
				
			}
```


```java
	int count =0;
		for(int i =0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1] ) {
					count++;
				}
			}
		}
```

## :black_nib: **Review**
- 그냥 시키는데요 구현만 하면되서 쉬웠어요

## 📡**Link**
- https://www.acmicpc.net/problem/15685
