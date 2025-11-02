# [백준 - G5] 2493. 탑

## ⏰  **time**
60분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. 스택이 비지 않았다면, 탑의 높이를 확인한다
- 현재 탑 보다 낮은 탑들은 모두 `pop()` 한다.
2. `pop()`이 끝난 후 스택이 비어있지 않다면, 그 탑의 인덱스를 `result[i]`에 기록한다.
3. 현재 탑을 스택에 push 한다


```java
for(int i = 0; i < N; i++) {
	// 현재 탑 보다 낮은 탑들을 pop
	while (!st.isEmpty() && st.peek().height <= arr[i]) {
		st.pop();
	}
			
	if (!st.isEmpty()) {
		result[i] = st.peek().idx;
	} else {
		result[i] = 0;
	}
		
	st.push(new Top(arr[i], i + 1));
}
```


## :black_nib: **Review**

뒤에서 앞으로 이동한다고 해서 뒤에서 비교하는 방식을 생각했는데,
그러면 $O(N^2)$가 될 것 같아서 앞에서 비교해야 한다.

## 📡**Link**
- https://www.acmicpc.net/problem/2493
