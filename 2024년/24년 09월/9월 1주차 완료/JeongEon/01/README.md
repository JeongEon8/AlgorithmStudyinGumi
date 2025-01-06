# [백준 - 골드 4] 14500. 테트로미노
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
벡트레킹

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 상하좌우 방향벡터를 통해 4방향 탐색을 진행한다.
2. 테트로미노는 4칸이므로, 4칸 탐색을 했다면 그 칸들의 합과 결과값을 비교해 큰 수를 결과값에 저장한다. (이때, 결과값의 초기값은 0이다.)
3. 테트로미노는 (ㅓ, ㅏ , ㅗ, ㅜ) 모양도 존재한다.
4. 해당 모양은 4방향 탐색을 통해 만들 수 없으므로, if문을 통해 확인했다.
```cpp
void backTracking(int sum, int x, int y, int cnt) {
	if (cnt >= 4) {
		result = max(result, sum);
		//print();
		return;
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
			continue;
		}

		if (visited[ny][nx] == true) {
			continue;
		}

		if (visited[ny][nx] == false) {
			visited[ny][nx] = true;
			backTracking(sum + arr[ny][nx], nx, ny, cnt + 1);
			visited[ny][nx] = false;
		}
	}
}
```

```cpp
			// ㅗ
			if (0 <= up && up < N && 0 <= left && left < M && 0 <= right && right < M) {
				result = max(result, (arr[i][j] + arr[up][j] + arr[i][left] + arr[i][right]));
			}
			
			// ㅏ
			if (0 <= up && up < N && 0 <= right && right < M && 0 <= down && down < N) {
				result = max(result, (arr[i][j] + arr[up][j] + arr[i][right] + arr[down][j]));
			}

			// ㅜ
			if (0 <= down && down < N && 0 <= left && left < M && 0 <= right && right < M) {
				result = max(result, (arr[i][j] + arr[down][j] + arr[i][left] + arr[i][right]));
			}

			// ㅓ
			if (0 <= up && up < N && 0 <= left && left < M && 0 <= down && down < N) {
				result = max(result, (arr[i][j] + arr[up][j] + arr[i][left] + arr[down][j]));
			}
```

## :black_nib: **Review**
- 좀 더 줄일 수 없을까? (ㅓ, ㅏ , ㅗ, ㅜ) 모양을 백트리킹 안에 넣고 싶다.

## 📡 Link
https://www.acmicpc.net/problem/14500
