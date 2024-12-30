# [백준 - 골드 4] 9019. DSLR
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. BFS 함수에서 현재 숫자에서 D, S, L, R 연산을 해 큐에 집어 넣는다.
2. visited 배열을 통해 방문한 숫자를 체크하여 중복된 숫자를 방문하지 않도록 해준다.
3. 만약 결과 숫자가 나오면 return (종료)
```cpp
void BFS() {
	queue<pair<int, string>> q;
	q.push(make_pair(A, ""));
	visited[A] = 1;
	while (!q.empty()) {
		int num = q.front().first;
		string s = q.front().second;
		if (num == B) {
			cout << s << "\n";
			return;
		}
		q.pop();
		int D, S, L, R;
		// D 연산
		D = (num * 2) % 10000;
		if (!visited[D]) {
			visited[D] = 1;
			q.push(make_pair(D, s + 'D'));
		}
		// S 연산
		S = num - 1;
		if (S == -1) S = 9999;
		if (!visited[S]) {
			visited[S] = 1;
			q.push(make_pair(S, s + 'S'));
		}
		// L 연산
		L = (num * 10) % 10000 + num / 1000;
		if (!visited[L]) {
			visited[L] = 1;
			q.push(make_pair(L, s + 'L'));
		}
		// R 연산
		R = num / 10 + (num % 10) * 1000;
		if (!visited[R]) {
			visited[R] = 1;
			q.push(make_pair(R, s + 'R'));
		}
	}
}
```

## :black_nib: **Review**
- DFS 돌리다가 도저히 안 돌아가서 왜 그러지.. 했더니 BFS로 해야되는 거였다.
- 그리고 로직도 틀렸다.
- 오랜만에 머리쓰니까 진짜 안된다.
- 공부하기 싫다.

## 📡 Link
https://www.acmicpc.net/problem/9019
