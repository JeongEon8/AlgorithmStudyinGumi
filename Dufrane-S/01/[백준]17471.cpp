#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>
using namespace std;


int main() {
	int n;
	cin >> n;
	vector<int>pop;
	vector<vector<int>>graph(n, vector<int>());
	int answer = INT_MAX;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		pop.push_back(a);
	}
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		for (int j = 0; j < a; j++) {
			int b;
			cin >> b;
			graph[i].push_back(b);
		}
	}

	for (int i = 1; i <= n/2; i++) {
		vector<int>checker;
		for (int j = 0; j < i; j++) {
			checker.push_back(1);
		}
		for (int j = 0; j < n - i; j++) {
			checker.push_back(0);
		}
		sort(checker.begin(), checker.end());
		
		do {
			int count = 0;
			int a = 0;
			int b = 0;
			for (int k = 0; k < n; k++) {
				if (checker[k]) {
					a += pop[k];
				}
				else {
					b += pop[k];
				}
			}

			
			vector<bool>done(n, false);
			for (int k = 0; k < n; k++) {
				if (done[k] == false) {
					queue<int>q;
					q.push(k);
					count++;
					done[k] = true;
					while (!q.empty()) {
						int a = q.front();
						q.pop();
						int check = checker[a];
						for (auto s : graph[a]) {
							if (done[s-1] == false && check == checker[s-1]) {
								q.push(s-1);
								done[s-1] = true;
							}
							
						}

					}

				}
			}
			if (count >= 3)continue;

			if (answer > abs(a - b)) {
				answer = abs(a - b);
			}
			

		} while (next_permutation(checker.begin(), checker.end()));

	}
	if (INT_MAX == answer)answer = -1;

	cout << answer;
	
}
