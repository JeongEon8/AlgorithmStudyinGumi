#include <iostream>

using namespace std;

int map[101][101];
int cnt;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	for (int i = 1; i <= 4; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		
        for (int y = b; y < d; y++) {
			for (int x = a; x < c; x++) {
				if (!map[y][x]) {
					cnt++;
					map[y][x] = 1;
				}
			}
		}

	}
    
	cout << cnt << '\n';
	
	return 0;
}
