#include <iostream>
#include <vector>
#include <queue>

using namespace std;

//2<=n<=100000
//1<=m<=1000000
//<=가중치 <=1000
int n, m;
vector<pair<int,int>> edge[100001];
bool visited[100001];

int prim() {
	priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int >>> pq;
	int result=0;
	int maxCost = 0;
	pq.push( { 0,1 });

	for (int i = 1; i <= n; i++) {
		while (!pq.empty() &&visited[pq.top().second]) {
			pq.pop();
		}
		int next = pq.top().second;
		int minCost = pq.top().first;
		maxCost = max(maxCost, minCost);
		visited[next] = true;
		result += minCost;
		for (auto o : edge[next]) {
			pq.push({ o.second,o.first });
		}
	}
	return result-maxCost;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	
	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		edge[from].push_back({ to ,cost });
		edge[to].push_back({ from,cost });
	}	

	cout << prim();
	


	return 0;
}
