# [백준 - 골드 5] 13023. ABCDE

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BackTracking

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 그래프 탐색을 통해 5명 이상이 이어져 있는지 확인한다.
```cpp
bool backTracking(int n) {
	if (cnt >= 5) {
		return true;
	}
	for (int i = 0; i < vec[n].size(); i++) {
		int next = vec[n][i];
		if (visited[next] == false) {
			cnt++;
			visited[next] = true;
			if (backTracking(next)) {
				return true;
			}
			cnt--;
			visited[next] = false;
		}
	}

	return false;
}
```

## :black_nib: **Review**


## 📡 Link
https://www.acmicpc.net/problem/13023
