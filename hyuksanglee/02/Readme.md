# [SWEA] 힙

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 힙

## ⏲️**Time Complexity**

$O(T×N×logN)

## :round_pushpin: **Logic**

- PriorityQueue를 사용하기
- 최댓순으로 뽑아야하기 때문에 new PriorityQueue<>((a,b) -> b - a)로 생성하기

```java
	 PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> b - a);
			
			for(int n =0; n<N; n++) {
				String[] input = in.readLine().split(" ");
				int type = Integer.parseInt(input[0]);
				if(type == 1) {
					que.add(Integer.parseInt(input[1]));
				}
				else if(type ==2) {
					int result = -1;
					if(!que.isEmpty()) {
						result = que.poll();
					}
					
					System.out.print(" "+result);
				}
				
				
			}
```

## :black_nib: **Review**
- 이번꺼는 PriorityQueue 이것만 사용하면 되서 너무 쉬웠어요


## 📡**Link**

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-Tj7ya3jYDFAXr
