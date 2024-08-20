#include <iostream>
#include <vector>
using namespace std;

int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

int main() {

	int n, m;
	cin >> n >> m;
	int nowi, nowj, dir;
	cin >> nowi >> nowj >> dir;
	vector<vector<int>>box(n, vector<int>(m, 0));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int a;
			cin >> a;
			box[i][j] = a;
		}
	}
	int y = nowi;
	int x = nowj;
	int answer = 0;
	while (true) {
		if (box[y][x] == 0) {
			answer++;
			box[y][x] = -1;
		}
		bool flag = false;
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (ny < 0 || nx < 0 || nx == m || ny == n)continue;
			if (box[ny][nx] == 0) {
				flag = true;
				break;
			}
		}
		if (flag) {// 청소 안된 곳 있으면
			while (true) {
				dir--;
				if (dir == -1)dir = 3;
				if (dir == 0) {
					int ny = y - 1;
					if (box[ny][x] == 0) {
						y = ny;
						break;
					}
				}
				else if (dir == 1) {
					int nx = x + 1;
					if (box[y][nx] == 0) {
						x = nx;
						break;
					}
				}
				else if (dir == 2) {
					int ny = y + 1;
					if (box[ny][x] == 0) {
						y = ny;
						break;
					}
				}
				else if (dir == 3) {
					int nx = x - 1;
					if (box[y][nx] == 0) {
						x = nx;
						break;
					}
				}
			}
		}
		else {// 없으면
			if (dir == 0) {
				y++;
				if (y == n || box[y][x]==1)break;
			}
			else if (dir == 1 ) {
				x--;
				if (x < 0 || box[y][x] == 1)break;
			}
			else if (dir == 2) {
				y--;
				if (y < 0 || box[y][x] == 1)break;
			}
			else if (dir == 3) {
				x++;
				if (x == m || box[y][x] == 1)break;
			}
		}

	}
	cout << answer;
	
	
	return 0;

}
