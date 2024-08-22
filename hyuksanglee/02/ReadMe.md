# [백준 - S1] 2346. 풍선 터뜨리기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- Deque

## :round_pushpin: **Logic**
1. 데크를 사용해서 (정수와 인덴스)클래스를 담는다

2. 풍선안에 양수이면 데크에서 .poll()로 빼서 다시 .offer()로 오른쪽에 넣어준다. 

3. 음수이면 데크에 오른쪽으로 .pollLeft()롤 뺴서 다시 offerFirst()로 왼쪽에 붙여준다

4. 2 3번에 해당 되는 것에 숫자만큼 반복한 후 .poll이나 .pollLeft()를 통해서 해당 클래스를 뽑아서 덱스를 출력해준다.
   
```#java
while(!que.isEmpty()) {
			
			if(type ==0) {
				nu =que.poll();
				num = nu.num;
			}else {
				nu = que.pollLast();
				num = nu.num;
			}
			
			System.out.print(nu.index + " ");
			
			if(que.isEmpty()) {
				break;
			}
			if(num <0) {
				type = 1;
				num = Math.abs(num);
			}else {
				type =0;
			}
			
			for(int i = 0; i<num-1; i++) {
				if(type == 0) {
					que.offer(que.poll());
					
				
				}else {
					que.offerFirst(que.pollLast());
				}
			}
			
		}
```
## :black_nib: **Review**

- 처음에 데크에 숫자만 받아서 뽑으려 했지만 인덱스를 뽑는데 어려운이있어서 클래스를만들어서 해결했어요

## 📡**Link**

- https://www.acmicpc.net/problem/2346
  
