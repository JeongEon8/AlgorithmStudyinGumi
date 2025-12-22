#include <iostream>
#include <vector>
#include <queue>
#define MAX 50001
#define INF 1e9
using namespace std;

int n, m;
int dist[MAX + 1];
vector<pair<int, int>> v[MAX + 1];

void FASTIO() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
}

void dijkstra(int start) {
	for (int i = 1; i <= n; i++) dist[i] = INF;
	priority_queue<pair<int, int>>pq;
	pq.push({ 0,start });
	dist[start] = 0;
	while (!pq.empty()) {
		int cost = -pq.top().first;
		int cur = pq.top().second;
		pq.pop();
		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i].first;
			int newcost = v[cur][i].second + cost;
			if (dist[next] > newcost) {
				dist[next] = newcost;
				pq.push({ -dist[next],next });
			}
		}
	}
}

int main() {
    FASTIO();

	cin >> n >> m;
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
		v[b].push_back({ a,c });
	}
	dijkstra(1);

	cout << dist[n];

    return 0;
}