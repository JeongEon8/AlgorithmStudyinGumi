# [백준 - G3] 2623. 음악프로그램

## ⏰ **time**

40분

## :pushpin: **Algorithm**
- 위상정렬

## ⏲️**Time Complexity**

$O(N + M)$
N:가수 수, M: 보조PD 수

## :round_pushpin: **Logic**
- 보조PD가 정한 순서의 2번쨰 이상부터 가수번호는 +1을 해서 저장해준다.
- 가수번호가 개수가 0인것을 큐에 저장해서 하나씩 뽑는다 그리고 그 가수 뒤에 연결되어 있는 가수를 큐에 담아주는데 1일경우 담아주고 2이상일경우 -1해서 안담는다.
```java
for(int i = 0; i<M; i++) {
			input = in.readLine().split(" ");
			int C = Integer.parseInt(input[0]);
			for(int c=1; c<C; c++) {
				int a = Integer.parseInt(input[c]);
				int b = Integer.parseInt(input[c+1]);
				arr[b]++;
				list[a].add(b);
			}
		}
		
		Queue<Integer> que = new ArrayDeque<Integer>();
		for(int i =1; i<N+1; i++) {
			if(arr[i]==0) {
				que.add(i);
				check[i] =true;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		
		while(!que.isEmpty()) {
			int num = que.poll();
			result.add(num);
			for(int nu: list[num]) {
				arr[nu]--;
				if(arr[nu]==0 && !check[nu]) {
					que.add(nu);
					check[nu]=true;
				}
			}
		}
```

## :black_nib: **Review**  
위상정렬 문제가 제일 쉬운거 같아요
## 📡**Link**
https://www.acmicpc.net/problem/2623
