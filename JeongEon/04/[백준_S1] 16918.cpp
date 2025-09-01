#include <iostream>
#include <vector>

using namespace std;

int r, c, n, T;
int a[201][201];
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };


void print(void) {
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (a[i][j] == -1) {
				cout << '.';
			}
			else cout << 'O';
		}
		cout << '\n';
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
    cout.tie(0);

	cin >> r >> c >> n;

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			char tmp;
			cin >> tmp;
			if (tmp == 'O') {
				a[i][j] = 0;
			}
			else {
				a[i][j] = -1;
			}
		}
	}
	
	if (T == n) {
		print();
		return 0;
	}


	T++;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (a[i][j] == 0) {
				a[i][j]++;
			}
		}
	}
	if (T == n) {
		print();
		return 0;
	}

	
	T++;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			a[i][j]++;
		}
	}
	if (T == n) {
		print();
		return 0;
	}



	while(T<n) {
		T++;
		vector<pair<int, int> > v;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] >= 0) a[i][j]++;
				if (a[i][j] == 3) {
					v.push_back({ i,j });
				}
			}
		}

		for (int i = 0; i < v.size(); i++) {
			a[v[i].first][v[i].second] = -1;
			for (int k = 0; k < 4; k++) {
				int nx = v[i].first + dx[k];
				int ny = v[i].second + dy[k];
				if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;    
                }
				a[nx][ny] = -1;
			}
		}

		v.clear();
		if (T == n) {
            break;
        }

		T++;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j]++;
				if (a[i][j] == 3) {
                    v.push_back({ i,j });
                }
			}
		}
		for (int i = 0; i < v.size(); i++) {
			a[v[i].first][v[i].second] = -1;
			for (int k = 0; k < 4; k++) {
				int nx = v[i].first + dx[k];
				int ny = v[i].second + dy[k];
				if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
				a[nx][ny] = -1;

			}
		}
	}
	
	print();

	return 0;
}
