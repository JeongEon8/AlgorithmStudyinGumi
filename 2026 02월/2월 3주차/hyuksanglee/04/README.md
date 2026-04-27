# [백준 - S4] 1057. 토너먼트

## ⏰ **time**

45분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 2명씩 게임이 이루어 지므로 같이 경기를 하는경우는 나누기 2를 했을때 같은 숫자여야한다.
  - ex) 1 ,2 가 경기를 하는데 같이 경기를 하기위해서는 +1 해서 나누기 2를 해야 같아진다. (1+1)/2 = 1, (2+1)/2= 1
- 같은 같이 나올때 까지 계속 나눠준다. 
```java
   while(A!=B) {
			A = (A+1)/2;
			B= (B+1)/2;
			result ++;
		}
```



## :black_nib: Review
- 처음에는 dfs로 풀었더니 스텍오버 뜨다라구요
- 이문제 수학 모르고 풀면 실버 아닌데
## 📡**Link**

- [https://www.acmicpc.net/problem/1057](https://www.acmicpc.net/problem/1057)
