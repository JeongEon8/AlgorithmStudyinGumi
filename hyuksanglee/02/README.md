# [백준 - S4] 28279. 덱2

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 덱

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
LinkedList을 사용해서 덱을 구현
```java
if(input[0].equals("1")) {
				int num = Integer.parseInt(input[1]);
				deque.addFirst(num);
			}else if(input[0].equals("2")) {
				int num = Integer.parseInt(input[1]);
				deque.addLast(num);
			}else if(input[0].equals("3")) {
				if(deque.size()>0) {
					System.out.println(deque.removeFirst());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("4")) {
				if(deque.size()>0) {
					System.out.println(deque.removeLast());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("5")) {
				
					System.out.println(deque.size());
				
			}else if(input[0].equals("6")) {
				if(deque.size()>0) {
					System.out.println(0);
				}else {
					System.out.println(1);
				}
			}else if(input[0].equals("7")) {
				if(deque.size()>0) {
					System.out.println(deque.peekFirst());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("8")) {
				if(deque.size()>0) {
					System.out.println(deque.peekLast());
				}else {
					System.out.println(-1);
				}
			}
```


## :black_nib: **Review**  
실버..?
## 📡**Link**

https://www.acmicpc.net/problem/28279
