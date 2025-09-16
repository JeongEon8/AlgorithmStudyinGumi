
# [백준- G4] 20166. 문자열 지옥에 빠진 호석
## ⏰  **time**
80분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**

- 해쉬맵을 사용해서 단어를 추가 할때마다 값을 추가해준다.
	- 해쉬맵에 해당값이 없으면 새로 추가해주고 있을 경우 해당값에 count 하나 올려준다.
- 글자의 최대 크기만큼 dfs() 반복해준다.
- StringBuilder를 사용해서 문자를 더해준다.
	- dfs를 들어갈때는 append()로 추가 해주고
 	- 나왔을때는 setLength()를 통해 하나 제거 해준다.
```java
	static void dfs(int y, int x, int count, StringBuilder total) {
		if(count >=len) {
			
			return;
		}
		
		for(int d = 0; d<8; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			
			if(ny<0) {
				ny=N-1;
			}
			if(nx<0) {
				nx = M-1;
			}
			if(ny>=N) {
				ny=0;
			}
			if(nx>=M) {
				nx =0;
			}
			total.append(map[ny][nx]);
			if(hash.containsKey(total.toString())) {
				hash.merge(total.toString(), 1, Integer::sum);
			}else {
				hash.put(total.toString(),1);
			}
			dfs(ny,nx,count+1, total);
			total.setLength(total.length() - 1);
		}
		
	}
```


## :black_nib: **Review**
- 시간을 줄이기 위해 StringBuilder를 꼭 써야하더라구요


## 📡**Link**
- https://www.acmicpc.net/problem/20166

