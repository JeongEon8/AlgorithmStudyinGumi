#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

vector<vector<int>> box = vector<vector<int>>(101, vector<int>(101, 0));
vector<vector<bool>> island = vector<vector<bool>>(101, vector<bool>(101, false));
vector<vector<int>> edge = vector<vector<int>>(101, vector<int>(101, false));
vector<vector<int>> edgecopy = vector<vector<int>>(101, vector<int>(101, false));

int n;
int dy[4] = { 1,-1,0,0 };
int dx[4] = { 0,0,1,-1 };
int answer = INT_MAX;
int tmp;

void bfs(int y, int x) {
	tmp++;
	queue<pair<int, int>>q;
	q.push({ y,x });
	island[y][x] = true;
	while (!q.empty()) {
		int nowy = q.front().first;
		int nowx = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int ny = nowy + dy[k];
			int nx = nowx + dx[k];
			if (ny < 0 || nx < 0 || ny == n || nx == n)continue;
			if (box[ny][nx] == 0) {
				edge[nowy][nowx] = tmp;
				edgecopy[nowy][nowx] = tmp;
				continue;
			}
			if (island[ny][nx] == true)continue;
			
			q.push({ ny,nx });
			island[ny][nx] = true;
		}

	}

}


void bridge(int y, int x) {
	int start = edge[y][x];

	/*cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << edgecopy[i][j] << ' ';
		}cout << '\n';
	}*/

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			edgecopy[i][j] = edge[i][j];
		}
	}
	
	queue<pair<int, int>>q;
	
	q.push({ y,x });
	bool done = true;
	while (!q.empty() && done) {
		int nowx = q.front().second;
		int nowy = q.front().first;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int ny = nowy + dy[k];
			int nx = nowx + dx[k];
			if (ny < 0 || nx < 0 || ny == n || nx == n)continue;
			if(island[ny][nx] == true && box[ny][nx]==start)continue; // 처음 시작한 섬이면
			

			if (edgecopy[ny][nx] != 0 && edgecopy[ny][nx] != 0 && island[ny][nx]==true && edgecopy[ny][nx] != start) {
				if (answer > edgecopy[nowy][nowx] - start) { answer = edgecopy[nowy][nowx] - start;
				/*cout << '\n';
				cout <<y<< ' '<<x<<  ' ' << start <<' ' << ny<<' ' << nx<<'\n';
				cout << answer << '\n';*/

				}
				done = false;
				break;
			}
			if (island[ny][nx])continue;
			if (edgecopy[ny][nx] == 0) {
				q.push({ ny,nx });
				edgecopy[ny][nx] = edgecopy[nowy][nowx] + 1;
			}

		}
	}

}

int main() {
	cin >> n;
	tmp = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int a;
			cin >> a;
			box[i][j] = a;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (box[i][j] == 1 && island[i][j] == false) {
				bfs(i, j);
			}
		}
	}


	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (edge[i][j] != 0) {
				bridge(i, j);
			}
		}
	}
	
	/*cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << edge[i][j]<<' ';
		}cout << '\n';
	}
	cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << edgecopy[i][j] << ' ';
		}cout << '\n';
	}

	cout << '\n';
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << island[i][j] << ' ';
		}cout << '\n';
	}*/
	cout << answer;
}
