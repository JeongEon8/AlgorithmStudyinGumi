#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int N, M;
vector<int> vec[2001];
int cnt = 0;
bool visited[2001];

bool backTracking(int n) {
	if (cnt >= 5) {
		return true;
	}
	for (int i = 0; i < vec[n].size(); i++) {
		int next = vec[n][i];
		if (visited[next] == false) {
			cnt++;
			visited[next] = true;
			if (backTracking(next)) {
				return true;
			}
			cnt--;
			visited[next] = false;
		}
	}

	return false;
}

int main(void) {
	// init
	memset(visited, false, sizeof(visited));

	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		vec[a].push_back(b);
		vec[b].push_back(a);
	}

	for (int i = 0; i < N; i++) {
		cnt = 1;
		visited[i] = true;
		if (backTracking(i)) {
			cout << "1" << endl;
			return 0;
		}
		visited[i] = false;
	}


	cout << "0" << endl;

	return 0;
}
