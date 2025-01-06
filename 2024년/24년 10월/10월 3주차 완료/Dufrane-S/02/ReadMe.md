# [백준 - S4] 10773. 제로

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
0이 들어오면 가장 최근 입력된 값을 삭제

```java
	for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a!=0) {
				box.add(a);	
			}else if(!box.isEmpty() && a==0){
				box.remove(box.size()-1);
			}
		}
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/10773
