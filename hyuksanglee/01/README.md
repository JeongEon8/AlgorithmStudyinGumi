# [백준 - 골드 4] 9019. DSLR
 
## ⏰  **time**
1시간 20분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. DSLR 조건을 함수로 구현.
2. bfs를 사용해서 해당 값을 찾을때까지 탐색한다.
```java
	public static String bfs() {
		while(!que.isEmpty()) {
			Node node = que.poll();
			int num = node.num;
			String comment = node.comment;
			
			if(num==B) {
				return comment;
			}
			for(int i =0; i<4; i++) {
				String c = type[i];
				int total = 0;
				
				if(i==0) {
					total = d(num);
				}else if(i==1) {
					total = s(num);
				}else if(i==2) {
					total = l(num);
				}else {
					total =r(num);
				}
				if(!visited[total]) {
					visited[total]=true;
					que.add(new Node(total,comment+c));
				}
			}
			
		}
		
		
	    return "";
	}
```

## :black_nib: **Review**
- 처음에 bfs인거는 알았는데 어떻게 구현할지를 오래동안 생각한거 같아요

## 📡 Link
https://www.acmicpc.net/problem/9019
