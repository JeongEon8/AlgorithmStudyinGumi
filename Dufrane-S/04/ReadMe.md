# [백준 - S1] 2468. 안전 영역
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. 최대 높이를 구해서 0~최대 높이-1까지 비가 오는 경우 모두 bfs를 통해 구역을 구해주기
```#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int done[101][101];
int n;
int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,1,-1};


void bfs(int i, int j) {
	queue<pair<int, int>>q;
	q.push({ i,j });
	while (!q.empty()) {
		int nx, ny;
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			nx = x + dx[k];
			ny = y + dy[k];
			if (nx < 0 || ny < 0 || nx == n || ny == n)continue;
			if (done[ny][nx] == 0) {
				done[ny][nx] = 1;
				q.push({ ny,nx });
			}
		}
	}
}

int main(void) {
	
	int a;
	cin >> n;
	int box[101][101];
	int large = 0;
	int answer = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a;
			box[i][j] = a;
			large = max(large, a);
		}
	}
	
	for (int k = 0; k < large; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (box[i][j] <= k) { 
					done[i][j] = 1;
				}else {
					done[i][j] = 0; 
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (done[i][j] == 0 ) {
					bfs(i, j);
					done[i][j] = 1;
					count++;
				}
			}
		}
		answer = max(answer, count);

	}
	cout << answer;

}
```
