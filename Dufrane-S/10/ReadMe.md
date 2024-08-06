# [백준 - G4] 2573. 빙산
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. 먼저 1년에 녹는 빙산을 반영
2. bfs로 빙산의 갯수를 확인
3. 빙산의 갯수에 따라 분기
```
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


int box[300][300];
int answer = 0;
int n, m;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
bool flag = true;

void melt() {
	int newbox[300][300];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (box[i][j] == 0) {
				newbox[i][j] = 0;
			}
			else {
				int sum = 0;
				for (int a = 0; a < 4; a++) {
					int nx = dx[a] + j;
					int ny = dy[a] + i;
					if (ny < 0 || nx < 0 || ny == n || nx == m)continue;
					if (box[ny][nx] == 0) {
						sum++;
					}
				}
				newbox[i][j] = max(box[i][j] - sum,0);
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			box[i][j] = newbox[i][j];
		}
	}
}

int bfs() {
	int copybox[300][300];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			copybox[i][j] = box[i][j];
		}
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (copybox[i][j] != 0) {
				count++;
				if (count > 1)return count;
				queue < pair<int, int> > q;
				q.push({ i,j });
				while (!q.empty()) {
					int y = q.front().first;
					int x = q.front().second;
					q.pop();
					for (int i = 0; i < 4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						if (ny < 0 || nx < 0 || ny == n || nx == m || copybox[ny][nx] == 0)continue;
						q.push({ ny,nx });
						copybox[ny][nx] = 0;
					}
				}
			}
			
		}
	}
	
	return count;
}


int main() {
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int a;
			cin >> a;
			box[i][j] = a;
		}
	}
	int year = 0;
	while (flag) {
		year++;
		
		melt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
			}
		}
		int check = bfs();
		if (check>1) {
			answer = year;
			break; 
		}
		else if ( check == 0) {
			break;
		}
	}
	
	cout << answer;
}

```
