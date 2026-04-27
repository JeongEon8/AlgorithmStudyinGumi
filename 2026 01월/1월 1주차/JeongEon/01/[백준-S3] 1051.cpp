#include <iostream>
 
using namespace std;
int N, M;
int arr[50][50];
string input;
 
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
    
	int i, j, ans;
    
	cin >> N >> M;
    
	for (i = 0; i < N; i++) {
		cin >> input;
		for (j = 0; j < M; j++)
			arr[i][j] = input[j] - '0';
	}
    
	int len, Max_len = min(N, M);
	int a, b, c, d;
    
	for (len = 1; len <= Max_len; len++) {
		for (i = 0; i <= N - len; i++) {
			for (j = 0; j <= M - len; j++) {
				a = arr[i][j];
				b = arr[i + len - 1][j];
				c = arr[i][j + len - 1];
				d = arr[i + len - 1][j + len - 1];
				if (a == b && b == c && c == d)
					ans = len;
			}
		}
	}
    
	cout << ans * ans << '\n';
    
    return 0;
}
