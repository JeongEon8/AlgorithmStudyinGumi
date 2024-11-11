#include <iostream>
#include <queue>
#include <algorithm>
#include <cmath>
#include <vector>
#include <iostream>
#include <map>
using namespace std;


int board[52][52];
bool check[52][52];


int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int sum = 0;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N,M,r,c,d;
	cin >> N >> M >> r >> c >> d;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}

	while (1) {
		if (check[r][c] == false) { //1번 현재 위치 청소			
			check[r][c] = true;
			sum++;			
		}
		bool ch = false;
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 방향을 틀어서 봄
			int nx = r + dx[d];// 방향을 틀어서 본 좌표의 청소값을 보기 위함
			int ny = c + dy[d];
			if (board[nx][ny] == 0 && check[nx][ny] == false) {
				//왼쪽 방향에 청소하지 않은 공간이 있다면 한 칸 움직이고 1번으로 감
				r += dx[d];
				c += dy[d];
				ch = true;
				break;
			}
		}
		if (!ch) { //조건 2-c , 2-d일 때
			int back = (d + 2) % 4; //바라보는 방향을 유지하기 위해서
			if (board[r + dx[back]][c + dy[back]] == 1) break;
			r += dx[back];
			c += dy[back];
		}
	}
	cout << sum << "\n";
}
