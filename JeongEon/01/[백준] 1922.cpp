#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 전역변수
int N, M;
vector<pair<int, int>> node[100001];
bool visited[100001];

int prim() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	int result = 0;
	pq.push({ 0, 1 });
	for (int i = 1; i <= N; i++) {
		while (!pq.empty() && visited[pq.top().second]) {
			pq.pop();
		}
		int next = pq.top().second;
		int minCost = pq.top().first;
		visited[next] = true;
		result += minCost;
		for (auto o : node[next]) {
			pq.push({ o.second, o.first });
		}
	}

	return result;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	cin >> M;
	
	for (int i = 0; i < M; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		node[from].push_back({ to, cost });
		node[to].push_back({ from,cost });
	}

	cout << prim();

	return 0;
}
