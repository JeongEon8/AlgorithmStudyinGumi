#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

bool done[10001];
vector<int> box[10001];
int main() {
	int n, m;
	cin >> n >> m;
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		box[b].push_back(a);
	}
	vector<int>answers;
	int large = 0;
	for (int i = 1; i <= n; i++) {
		vector<int>coms;
		for (int i = 1; i <= n; i++) {
			done[i] = 0;
		}
		queue<int>q;
		q.push(i);
		done[i] = true;
		coms.push_back(i);
		while (!q.empty()) {
			int now = q.front();
			q.pop();
			for (auto k : box[now]) {
				if (done[k] == false) {
					done[k] = true;
					q.push({ k });
					coms.push_back(k);
				}
			}
		}
		if (coms.size() > large) {
			answers.clear();
			answers.push_back(i);
			large = coms.size();
		}
		else if (coms.size() == large) {
			answers.push_back(i);
		}
	}
	sort(answers.begin(), answers.end());
	for (auto i : answers) {
		cout << i << ' ';
	}
	
}
