
# [백준- G4] 1715. 카드 정렬하기
## ⏰  **time**
30분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**

- 우선순위 큐를 사용해서 정렬 후 작은 순서부터 두개씩 뽑아서 더해주면 된다

```java
	PriorityQueue<Integer> que = new PriorityQueue();
		
		
		for(int n = 0; n<N; n++) {
			int num = Integer.parseInt(in.readLine());
			que.offer(num);
		}
		
		int total = 0;
		
		while(que.size() > 1) {
			int num = que.poll() + que.poll();
			total += num;
			
			que.add(num);
		}
```

## :black_nib: **Review**
- 이게 골드 4??


## 📡**Link**
- https://www.acmicpc.net/problem/1715

