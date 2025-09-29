
# [백준- G5] 1665. 가운데를 말해요
## ⏰  **time**
30분

## :pushpin: **Algorithm**
우선순위큐

## ⏲️**Time Complexity**
$O(log N)$

## :round_pushpin: **Logic**

- 작은 순 우선순위 큐, 큰순 우선순위큐 2개 생성
- 처음에는 작은 순 큐에 숫자를 넣어준다.
- 그다음 작은 순 큐에서 하나 뽑아서 비교하여 클경우 넣어주고 아닐경우 큰순 큐에 넣어준다.
- 작은순 큐와 큰순 큐 비교하여 대칭이 되게 조절해준다.
- 작은순 큐에서 하나 뽑아서 출력

```java
		PriorityQueue<Integer> minQ = new PriorityQueue<>();

		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int n = 0; n <N; n++) {
			int num = Integer.parseInt(in.readLine());
			if(maxQ.size()==0) {
				maxQ.add(num);
			}else {
				if(maxQ.peek()>=num) {
					maxQ.add(num);
				}else {
					minQ.add(num);
				}
			}
			
			while(minQ.size()-maxQ.size()<-1) {
				minQ.add(maxQ.poll());
			}
			while(maxQ.size()-minQ.size()<0) {
				maxQ.add(minQ.poll());
			}
			System.out.println(maxQ.peek());
		}
```


## :black_nib: **Review**
- 이번 문제는 골드 2 치고는 너무 쉬웠어요


## 📡**Link**
- https://www.acmicpc.net/problem/1655
