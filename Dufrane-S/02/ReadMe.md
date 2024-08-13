# [백준 - G4] 17471. 뱀
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현
시뮬레이션


## :round_pushpin: **Logic**
1. 사과와 방향 전환 좌표를 따로 저장
2. 이동하면서 충돌상황 & 사과 상황 구현
3. 사과 좌표를 따로 저장해 두었다면 사과를 먹고 삭제하는 것에 주의
```#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	int k;
	cin >> k;
	vector<vector<int>>box(n,vector<int>(n,0));
	vector<pair<int, int>>apples;

	for (int i = 0; i < k; i++) {
		int a, b;
		cin >> a >> b;
		apples.push_back({ a-1,b-1 });
	}
	cin >> k;
	vector<pair<int, char>>corners;
	for (int i = 0; i < k; i++) {
		int a;
		char b;
		cin >> a >> b;
		corners.push_back({ a,b });
	}
	int time = 0;
	pair<int, int>headnow = { 0,0 };
	queue<pair<int, int>>tail;
	tail.push(headnow);
	box[0][0] = 1;

	char way = 'r';
	int idx = 0;
	while (true)
	{
		time++;

		//cout << "time : " << time << " way : " <<way << " headyx "<<headnow.first<< ' '<<headnow.second<<'\n';
		bool flag = true;
		if (way == 'r') {
			
			headnow.second += 1;
			if (headnow.second == n || box[headnow.first][headnow.second] == 1) { // 몸통 or 벗어남
				break;
			}
			tail.push(headnow);
			box[headnow.first][headnow.second] = 1;
			
			/*for (auto i : apples) {
				if (i == headnow) {
					flag = false;
					remove(apples.begin(), apples.end(), i);
				}
			}*/

			for (int k = 0; k < apples.size(); k++) {
				if (headnow == apples[k]) {
					flag = false;
					apples.erase(apples.begin()+k);
				}
			}


			if (flag) {
				pair<int, int>tailnow = tail.front();
				tail.pop();
				box[tailnow.first][tailnow.second] = 0;
			}
			
			if (idx < corners.size()) {
				if (corners[idx].first == time) {
					if (corners[idx].second == 'L') {
						way ='u' ;
					}
					else if (corners[idx].second == 'D') {
						way = 'd';
					}
					idx++;
				}
			}

		}
		else if (way == 'l') {
			headnow.second -= 1;
			if (headnow.second < 0 || box[headnow.first][headnow.second] == 1) { // 몸통 or 벗어남
				break;
			}
			tail.push(headnow);
			box[headnow.first][headnow.second] = 1;

			for (int k = 0; k < apples.size(); k++) {
				if (headnow == apples[k]) {
					flag = false;
					apples.erase(apples.begin() + k);
				}
			}

			if (flag) {
				pair<int, int>tailnow = tail.front();
				tail.pop();
				box[tailnow.first][tailnow.second] = 0;
			}

			if (idx < corners.size()) {
				if (corners[idx].first == time) {
					if (corners[idx].second == 'L') {
						way = 'd';
					}
					else if (corners[idx].second == 'D') {
						way = 'u';
					}
					idx++;
				}
			}

		}
		else if (way == 'd') {
			headnow.first += 1;
			if (headnow.first == n || box[headnow.first][headnow.second] == 1) { // 몸통 or 벗어남
				break;
			}
			tail.push(headnow);
			box[headnow.first][headnow.second] = 1;

			for (int k = 0; k < apples.size(); k++) {
				if (headnow == apples[k]) {
					flag = false;
					apples.erase(apples.begin() + k);
				}
			}

			if (flag) {
				pair<int, int>tailnow = tail.front();
				tail.pop();
				box[tailnow.first][tailnow.second] = 0;
			}

			if (idx < corners.size()) {
				if (corners[idx].first == time) {
					if (corners[idx].second == 'L') {
						way = 'r';
					}
					else if (corners[idx].second == 'D') {
						way = 'l';
					}
					idx++;
				}
			}
		}
		else if (way == 'u') {
			headnow.first -= 1;
			if (headnow.first < 0 || box[headnow.first][headnow.second] == 1) { // 몸통 or 벗어남
				break;
			}
			tail.push(headnow);
			box[headnow.first][headnow.second] = 1;

			for (int k = 0; k < apples.size(); k++) {
				if (headnow == apples[k]) {
					flag = false;
					apples.erase(apples.begin() + k);
				}
			}

			if (flag) {
				pair<int, int>tailnow = tail.front();
				tail.pop();
				box[tailnow.first][tailnow.second] = 0;
			}

			if (idx < corners.size()) {
				if (corners[idx].first == time) {
					if (corners[idx].second == 'L') {
						way = 'l';
					}
					else if (corners[idx].second == 'D') {
						way = 'r';
					}
					idx++;
				}
			}
		}
	}




	while (!tail.empty())
	{
		//cout << tail.front().first << ' ' << tail.front().second << '\n';
		tail.pop();
	}


	/*for (auto i : box) {
		for (auto j : i) {
			cout << j<< ' ';
		}cout << '\n';
	}*/

	//cout << apples.size()<<' ';

	cout << time;

}
```
