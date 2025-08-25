#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int visited[100002];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
	int N, K, answer = -1;
	cin >> N >> K;
	vector<int> v(N);
	for (int i = 0; i < N; i++) {
        cin >> v[i];
    }

	int en = 0;
	int st = 0;
	for (int st = 0; st < N; st++) {
		while (en < N && visited[v[en]] < K) {
			visited[v[en]]++;
			en++;
		}
		answer = max(answer, en - st);
		if (en == N) break;
		visited[v[st]]--;
	}
	cout << answer << '\n';

	return 0;
}
