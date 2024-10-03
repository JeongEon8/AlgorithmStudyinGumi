# [백준 - G3] 17471. 게리멘더링
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
브루트포스 알고리즘
그래프 탐색
너비 우선 탐색
조합론


## :round_pushpin: **Logic**
1. 1~3개 크기의 선거구를 만들고 나머지도 선거구로 만들어 주는 조합을 모두 만든다.
2. bfs를 통해 연결된 선거구의 갯수를 구해준다. 2보다 크면 불가능한 선거구
3. 선거구 간 차를 구해준다.
```#include <iostream>
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
```
