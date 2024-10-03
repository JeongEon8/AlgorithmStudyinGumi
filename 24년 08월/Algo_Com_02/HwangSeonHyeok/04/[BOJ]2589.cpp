#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

string map[51];

int n, m;
int ans = 0;
int dx[4] = {1, 0, -1, 0 };
int dy[4] = {0, 1, 0, -1};

bool isInRange(int x, int y) {
	return x >= 0 && x < n && y >= 0 && y < m;
}

void bfs(int startX, int startY) {
	queue<pair<int,pair<int,int>>> q;
	bool visited[51][51] = { 0, };
	q.push(make_pair(0, make_pair(startX, startY)));
	visited[startX][startY] = true;
	while (!q.empty()) {
		
		int curDir = q.front().first;
		int curX = q.front().second.first;
		int curY = q.front().second.second;
		if (ans < curDir) {
			ans = curDir;
		}
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nextX = curX + dx[i];
			int nextY = curY + dy[i];
			if (isInRange(nextX, nextY) && map[nextX][nextY] == 'L' && !visited[nextX][nextY]) {
				q.push(make_pair(curDir + 1, make_pair(nextX, nextY)));
				visited[nextX][nextY] = true;
			}
			
		}
	}
}



int main()
{

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> map[i];
	}
	
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 'L') {
				bfs(i, j);
			}
		}
	}

	cout << ans;
	

}