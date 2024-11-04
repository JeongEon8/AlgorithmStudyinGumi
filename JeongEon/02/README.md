# [백준 - 실버 5] 16435. 스네이크버드
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 뱀 몸의 길이보다 작거나 같을 경우는 1 더하고, 아니면 그만 더한다.
   ```cpp
    	while (!q.empty()) {
    		if (L >= abs(q.top())) {
    			L += 1;
    			q.pop();
    		}
    		else {
    			break;
    		}
    	}
   ```

## :black_nib: **Review**
- 우선순위 큐를 이용해서 확인한다.

## 📡 Link
https://www.acmicpc.net/problem/16435
