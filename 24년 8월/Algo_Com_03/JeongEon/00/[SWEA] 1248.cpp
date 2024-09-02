#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int countVertics(int parent, vector<int> vertics[10001]) {
	if (vertics[parent].size() == 1) {
		return 1;
	}
	else {
		int cnt = 1;
		for (int i = 1; i < vertics[parent].size(); i++) {
			cnt += countVertics(vertics[parent][i], vertics);
		}
		return cnt;
	}
}

queue<int> findParent(int child, vector<int> vertics[10001]) {
	queue<int> q;
	while (vertics[child][0] != 0) {
		q.push(vertics[child][0]);
		child = vertics[child][0];
	}

	return q;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int tc = 1; tc <= T; tc++) {
		// 입력
		int V, E, num1, num2;
		cin >> V >> E >> num1 >> num2;

		// 1부터 정점이 있다.
		// 정점 벡터의 0번째는 그 정점의 부모가 들어있다.
		// 일단은 0을 삽입하여 부모를 초기화한다.
		vector<int> vertics[10001];
		for (int i = 0; i <= V; i++) {
			vertics[i].push_back(0);
		}

		// 입력
		for (int i = 0; i < E; i++) {
			int V1, V2;
			cin >> V1 >> V2;
			vertics[V1].push_back(V2);
			vertics[V2][0] = V1;
		}

		// 공통 부모 찾기
		int commonParent = 0;
		queue<int> num1Parents = findParent(num1, vertics);
		queue<int> num2Parents = findParent(num2, vertics);
		int parent1 = num1Parents.front();
		num1Parents.pop();
		int parent2 = num2Parents.front();
		num2Parents.pop();
		while (1) {
			if(parent1 != 0 && parent2 != 0) {
				if (parent1 == parent2) {
					commonParent = parent1;
					break;
				}
				else {
					if (num1Parents.size() >= num2Parents.size()) {
						parent1 = num1Parents.front();
						num1Parents.pop();
					}
					else {
						parent2 = num2Parents.front();
						num2Parents.pop();
					}
				}
			}
		}

		// 서브트리 노드개수
		int countTree = countVertics(commonParent, vertics);

		cout << "#" << tc << " ";
		cout << commonParent << " " << countTree << '\n';
	}

	return 0;
}
