# [백준 - 실버 4] 11508. 2+1 세일
 
## ⏰  **time**
23분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 2+1에서 가장 적은 가격으로 사려면, 가장 비싼 순으로 정렬한 후 차례대로 3개씩 묶으면 된다.
2. 그러면 비싼 걸 공짜로 가질 수 있다..!
3. 3개 미만으로 남으면 result에 하나씩 더 한다.
   ```cpp
	sort(dq.begin(), dq.end(), greater<>());

	long long result = 0;
	while (!dq.empty()) {
		if (dq.size() >= 3) {
			result += dq.front();
			dq.pop_front();
			result += dq.front();
			dq.pop_front();
			dq.pop_front();
		}
		else {
			result += dq.front();
			dq.pop_front();
		}
	}
   ```

## :black_nib: **Review**
- 처음엔 오름 차순으로 정렬해서, 가장 싼거 2개 비싼거 1개 이렇게 구매했는데 내가 생각을 잘못했다..!

## 📡 Link
https://www.acmicpc.net/problem/11508
