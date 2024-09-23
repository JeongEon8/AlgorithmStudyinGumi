# [백준 - 실버5] 1417. 국회의원 선거
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 우선순위 큐에 넣어 다솜이보다 크거나 같은 표를 1개 뺀 후 다솜이에게 더한다.
2. 다시 표를 큐에 넣는다.
3. 다솜이보다 크거나 같은지 반복해서 확인한다.
   ```cpp
	while (!q.empty()) {
		int num = q.top();
		q.pop();
		if (dasom <= num) {
			num--;
			dasom++;
			q.push(num);
			result++;
		}
	}
   ```

## :black_nib: **Review**
- 다솜아.. 부정투표는 안돼...

## 📡 Link
https://www.acmicpc.net/problem/1417
