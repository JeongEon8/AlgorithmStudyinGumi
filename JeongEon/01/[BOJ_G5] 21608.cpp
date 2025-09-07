#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct info {
	int x, y, blankCnt=0, friendCnt = 0;
	bool operator <(const info& i) const {
		if (friendCnt == i.friendCnt) {
			if (blankCnt == i.blankCnt) {
				if (x == i.x) return y > i.y;
				else return x > i.x;
			}
			else return blankCnt < i.blankCnt;
		}
		else return friendCnt < i.friendCnt;
	}
};

struct student {
	int id;
	int love[4];
	int x, y;
};

int manjok[] = { 0,1,10,100,1000 };

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(0);
    cout.tie(0);

	int N;
	int board[20][20] = {0,};

	cin >> N;

	vector<student> students(N * N);
	for (int i = 0; i < N * N; i++) {
		cin >> students[i].id;
		for (int j = 0; j < 4; j++) {
			cin >> students[i].love[j];
		}
	}

	for (int s = 0; s < N * N; s++) {
		priority_queue<info> pQ;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					int blankCnt = 0, friendCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx<0 || nx>N - 1 || ny<0 || ny>N - 1) continue;
						if (board[nx][ny] == 0) blankCnt++;
						else {
							for (int k = 0; k < 4; k++) {
								if (board[nx][ny] == students[s].love[k]) {
									friendCnt++;
									break;
								}
							}
						}
					}
					pQ.push({ i,j,blankCnt , friendCnt });
				}
			}
		}

		if (!pQ.empty()) {
			int x = pQ.top().x;
			int y = pQ.top().y;

			board[x][y] = students[s].id;
			students[s].x = x;
			students[s].y = y;
		}
	}

	int res = 0;
	for (int s = 0; s < N * N; s++) {
		int x = students[s].x;
		int y = students[s].y;

		int friends = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx<0 || nx>N - 1 || ny<0 || ny>N - 1) continue;
			for (int k = 0; k < 4; k++) {
				if (board[nx][ny] == students[s].love[k]) {
					friends++;
					break;
				}
			}
		}
		res += manjok[friends];
	}

	cout << res;

	return 0;
}
