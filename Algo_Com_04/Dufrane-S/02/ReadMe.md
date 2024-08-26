# [백준 - S1] 1697. 숨바꼭질
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS


## :round_pushpin: **Logic**
1. 방문 처리를 해주면서 시작점이 목적지보다 작을 때는 -1만 크면 +1, *2 모두 처리
2. 그냥 모든 경우 -1,+1,*2 해주면 메로리 초과 발생
```#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>
#include <climits>
using namespace std;


int main() {

	unordered_set<int>done;
	int n, m;
	int answer=INT_MAX;
	cin >> n >> m;
	queue<pair<int,int>>q;
	q.push({ n,0 });
	done.insert(n);

	while (!q.empty()) {
		int now = q.front().first;
		int depth = q.front().second;
		if (now == m) { 
			answer = depth;
			break;
		}
		q.pop();
		if (now>=0 && done.count(now - 1)==0 && answer>depth+1) {
			if (now - 1 == m) {
				answer = depth + 1;
				break;
			}
			q.push({ now - 1,depth + 1 });
			done.insert(now - 1);
			//cout << now - 1<<' ';
		}
		if (now < m && done.count(now + 1) == 0 && answer > depth + 1) {
			if (now + 1 == m) {
				answer = depth + 1;
				break;
			}
			q.push({ now + 1,depth + 1 });
			done.insert(now + 1);
			//cout << now + 1 << ' ';
		}
		if (now < m  && done.count(now * 2) == 0 && answer > depth + 1) {
			if (now * 2 == m) {
				answer = depth + 1;
				break;
			}
			q.push({ now * 2,depth + 1});
			done.insert(now * 2);
			//cout << now * 2 << ' ';
		}
	}
	cout << answer;
}
```
