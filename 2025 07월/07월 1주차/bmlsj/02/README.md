
# [백준 - G4] 9019. DSLR
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

- `prev` 배열은 각 상태가 어디서 왔는지 저장(부모 상태 기록)
- `cmd` 배열은 그 상태에 도달할 때 어떤 명령어를 썼는지 저장
- `printPath` 는 역으로 부모 상태를 따라가면서 명령어를 모으고, 거꾸로 뒤집어 결과 출력

```java
public static void convert(int start, int target) {

	visited[start] = true;
	Queue<Integer> queue = new ArrayDeque<>();
	queue.offer(start);
	prev[start] = -1; // 시작점

	while (!queue.isEmpty()) {

		int curr = queue.poll();

		if (curr == target) {
			printPath(target);
			return;
		}

		int[] next = new int[4];
		next[0] = (curr * 2) % 10000;
		next[1] = (curr == 0) ? 9999 : curr - 1;
		next[2] = (curr % 1000) * 10 + (curr / 1000); // 1234 -> 2341
		next[3] = (curr % 10) * 1000 + (curr / 10); // 1234 -> 4123

		char[] op = { 'D', 'S', 'L', 'R' };

		for (int i = 0; i < 4; i++) {

			int nx = next[i];

			if (!visited[nx]) {
				visited[nx] = true;
				prev[nx] = curr;
				cmd[nx] = op[i];  // curr -> nx로 가기 위한 명령어 저장
				queue.offer(nx);
			}
		}
	}
}

public static void printPath(int target) {
	StringBuilder sb = new StringBuilder();

	for (int cur = target; prev[cur] != -1; cur = prev[cur]) {
		sb.append(cmd[cur]);
	}

	System.out.println(sb.reverse().toString());
}
```


## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/9019