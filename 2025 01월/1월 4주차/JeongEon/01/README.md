# [백준 - 골드 4] 13975. 파일 합치기 3
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
그리디, 우선순위 큐

## ⏲️**Time Complexity**
$O(nlog(n))$

## :round_pushpin: **Logic**
1. 가장 작은 크기의 파일 2개를 더한다.
2. 아직 큐에 2개 이상 남아있다면 다시 1로 돌아간다.
```cpp
		while (pq.size() > 1) {
			long long sum = pq.top();
			pq.pop();
			sum += pq.top();
			pq.pop();
			ans += sum;
			pq.push(sum);
		}
```

## :black_nib: **Review**
- 와 행복한 골드!

## 📡 Link
https://www.acmicpc.net/problem/13975
