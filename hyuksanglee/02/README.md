
# [백준- G4] 1715. 카드 정렬하기
## ⏰  **time**
60분

## :pushpin: **Algorithm**
- 에라토스테네스의 체
- bfs

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**

- 에라토스테네스의 체를 사용해서 10000이하까지 수소를 구해준다.
```java
	decimal = new boolean[10000];
		for(int i = 2; i< 10000; i++) {
			if(decimal[i]) {
				continue;
			}
			int n = 2;
			while(n * i <10000) {
				decimal[n * i] = true;
				n++;
			}
		}
```
  
- bfs를 사용해서 각자리의 숫자를 한개씩 바꿔주면서 소수이면 큐에 담아준다.
- 해당 결과가 나올때까지 bfs를 돌려준다.

```java
	static int bfs(int s, int e) {
		
		Queue<Num> que = new ArrayDeque();
		
		boolean[] isVisite = new boolean[10000];
		
		Num nu = new Num();
		nu.num =s;
		nu.count = 0;
		que.add(nu);
		while(!que.isEmpty()) {
			Num newNu = que.poll();
			int n = newNu.num;
			int ten = 1;
			if(n == e) {
				return newNu.count;
			}
			for(int i=0; i<4; i++) {
				ten*= 10;
				int share = n/ten;
				share *= ten;
				int t = ten / 10;
				int remain =n%t;
				
				for(int j =0; j<10; j++) {
					
					int addNum = j * t;
					int result =addNum + remain + share;
					
					if(!decimal[result] && result >1000 && !isVisite[result]) {
						isVisite[result] = true;
						Num cNu = new Num();
						cNu.num = result;
						cNu.count = newNu.count +1;
						que.add(cNu);
					}
				}
			}
			
		}
		
		return 0;
	}
```

## :black_nib: **Review**
- 오랜만에 에라토스테네스의 체


## 📡**Link**
- https://www.acmicpc.net/problem/1963

