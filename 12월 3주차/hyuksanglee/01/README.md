# [SWEA] 중앙값 구하기

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 힙

## ⏲️**Time Complexity**

$O(T * N * log N))$

## :round_pushpin: **Logic**
- 우선순위 큐 큰순과 작은순 2개를 만들어준다.
- 초기에는 x, y, A 값을 큰 순서로 정렬되어 있는 큐에 넣어주고 하나씩 뽑아 처음 나오는 숫자는 작은순 큐에 그다음 나온 숫자는 중앙값으로 둔다
- 그다음부터 x, y 를 중앙값과 비교하여 작으면 큰순 큐에 넣어주고 크면 작은순 큐에 넣어준다.
      1. 큐에 넣은 다음 해당 큐에서 poll() 해주고 중앙값이랑 비교해서 두 큐중 사이즈가 적은 큐에 크기에 맞는 숫자를 넣어준다
      ex) 4, 5 가 있으면 큰순서로 되어있는 큐에 사이즈가 적으면 4가 큰순서 큐에 들어가고 5는 중앙값이 된다.

```java


if(x<A) {
						queMin.add(x);
						int num = queMin.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}else {
						queMax.add(x);
						int num = queMax.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}	
					
					if(y<A) {
						queMin.add(y);
						int num = queMin.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}else {
						queMax.add(y);
						int num = queMax.poll();
						if(queMin.size()>queMax.size()) {
							if(num<A) {
								queMax.add(A);
								A= num;
							}else {
								queMax.add(num);
							}
						}else {
							if(num>A) {
								queMin.add(A);
								A= num;
							}else {
								queMin.add(num);
							}
						}
					}
```

## :black_nib: **Review**
- 헷갈리지만 않으면 쉬운 문제

## 📡**Link**

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
