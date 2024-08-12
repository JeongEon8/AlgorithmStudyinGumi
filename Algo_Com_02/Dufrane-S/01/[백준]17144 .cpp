#include <iostream>
using namespace std;


int box[51][51];

int n, m, t;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

int ctx;
int cty;
int cdx;
int cdy;

void spread() {
	int mbox[51][51];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			mbox[i][j] = box[i][j] / 5;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < 4; k++) {
				int ny = i + dy[k];
				int nx = j + dx[k];
				if (nx < 0 || ny < 0 || nx == m || ny == n || box[ny][nx] == -1)continue;
				box[ny][nx] = mbox[i][j] + box[ny][nx];
				box[i][j] -= mbox[i][j];
			}
		}
	}
}


void clean() { // 공청기가 붙어 있을 경우 체크

	int x, y;
	x = ctx;
	y = cty - 2;

	if (y == -1) {
		y = 0;
		x++;
		while (x < m)
		{
			box[y][x - 1] = box[y][x];
			x++;
		}
		x--;
		y++;
		while (y <= cty) {
			box[y - 1][x] = box[y][x];
			y++;
		}
		y--;
		x--;
		while (x > ctx) {
			box[y][x + 1] = box[y][x];
			x--;
		}
		box[cty][ctx + 1] = 0;
	}
	else if (y == -2) {
		y = 0;
		x+=2;
		while (x < m)
		{
			box[y][x - 1] = box[y][x];
			x++;
		}
		x--;
		y++;
		while (y <= cty) {
			box[y - 1][x] = box[y][x];
			y++;
		}
		y--;
		x--;
		while (x > ctx) {
			box[y][x + 1] = box[y][x];
			x--;
		}
		box[cty][ctx + 1] = 0;
	}
	else {
		while (y >= 0) {
			box[y + 1][x] = box[y][x];
			y--;
		}
		y++;
		x++;
		while (x < m)
		{
			box[y][x - 1] = box[y][x];
			x++;
		}
		x--;
		y++;
		while (y <= cty) {
			box[y - 1][x] = box[y][x];
			y++;
		}
		y--;
		x--;
		while (x > ctx) {
			box[y][x + 1] = box[y][x];
			x--;
		}
		box[cty][ctx + 1] = 0;
	}





	/////////////////////
	x = cdx;
	y = cdy + 2;

	if (y == n) {
		y = n - 1;
		x++;
		while (x < m)
		{
			box[y][x - 1] = box[y][x];
			x++;
		}
		x--;
		y--;
		while (y >= cdy) {
			box[y + 1][x] = box[y][x];
			y--;
		}
		y++;
		x--;
		while (x >= ctx) {
			box[y][x + 1] = box[y][x];
			x--;
		}
		box[cdy][cdx + 1] = 0;
	}
	else if (y == n + 1) {
		y = n - 1;
		x+=2;
		while (x < m)
		{
			box[y][x - 1] = box[y][x];
			x++;
		}
		x--;
		y--;
		while (y >= cdy) {
			box[y + 1][x] = box[y][x];
			y--;
		}
		y++;
		x--;
		while (x >= ctx) {
			box[y][x + 1] = box[y][x];
			x--;
		}
		box[cdy][cdx + 1] = 0;
	}
	else {
		while (y < n) {
			box[y - 1][x] = box[y][x];
			y++;
		}
		y--;
		x++;
		while (x < m)
		{
			box[y][x - 1] = box[y][x];
			x++;
		}
		x--;
		y--;
		while (y >= cdy) {
			box[y + 1][x] = box[y][x];
			y--;
		}
		y++;
		x--;
		while (x >= ctx) {
			box[y][x + 1] = box[y][x];
			x--;
		}
		box[cdy][cdx + 1] = 0;
	}
	

}



int main() {
	cin >> n >> m >> t;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int a;
			cin >> a;
			box[i][j] = a;
			if (a == -1) {
				cdy = i;
				cdx = j;

			}
		}
	}

	cty = cdy - 1;
	ctx = cdx;

	for (int i = 0; i < t; i++) {
		spread();
		clean();
	}
	int answer = 0;
	


	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (box[i][j] > 0) {
				answer += box[i][j];
			}
			
		}
	}
	cout << answer;
}
