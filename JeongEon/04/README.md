# [백준 - 실버 4] 31797. 아~파트 아파트

## ⏰  **time**
30분

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
$O(10001)$

## :round_pushpin: **Logic**
1. 모든 손의 순서를 q에 넣는다.(손이 연속된 숫자로 있지 않을 수도 있다.)
2. N까지 q를 넣다 뺐다가 한다.
```cpp
	queue<int> q;
	for (int i = 1; i < 10001; i++) {
		if (hand[i] != 0) {
			q.push(hand[i]);
		}
	}

	for (int i = 1; i < N; i++) {
		q.push(q.front());
		q.pop();
	}
```

## :black_nib: **Review**
- 나는.. 손이 연속된 숫자로 예쁘게 들어가는 줄 알았지.....
  
  
## 📡 Link
https://www.acmicpc.net/problem/31797
