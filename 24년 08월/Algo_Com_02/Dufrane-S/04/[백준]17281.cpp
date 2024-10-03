#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {


	int n;
	cin >> n;
	int temp = 0;
	vector<vector<int>>v(n, vector<int>(9, 0));
	vector<vector<int>>vresult(n, vector<int>(9, 0));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 9; j++) {
			int a;
			cin >> a;
			v[i][j] = a;
		}
	}


	vector<int>abc;
	for (int i = 1; i < 9; i++) {
		abc.push_back(i);
	}
	//0 1 2 4 5 6 7 8

	do {
		for (int i = 0; i < n; i++) {
			int idx = 0;
			for (int j = 0; j < 8; j++) {
				if (j == 3)idx++;
				vresult[i][idx] = v[i][abc[j]];
				idx++;
			}
			vresult[i][3] = v[i][0];
		}
		/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 9; j++) {
				cout << vresult[i][j];
			}cout << '\n';
		}cout << '\n';
		*/
		int idx = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
		


			int outcount = 0;
			queue<int>q;
			while (true) {
				if (idx >= 9)idx = 0;
				int j = vresult[i][idx];

				if (j == 0) {
					outcount++;
				//	cout << "아웃 ";
				}
				else {
					if (q.empty()) {
						if (j == 4) {
							answer++;
						//	cout << "빈 홈런 " << j << ' ';
						}
						else {
							q.push(j);
						//	cout << "빈 진루 " << j << ' ';
						}

					}
					else {
						int num = q.size();
						for (int k = 0; k < num; k++) {
							int now = q.front();
							q.pop();
							now += j;
							if (now >= 4) {
								answer++;
							}
							else {
								q.push(now);
							}
						}
						if (j == 4) {
							answer++;
						//	cout << "홈런 ";
						}
						else {
							q.push(j);
						//	cout << "그냥 진루 " << j << ' ';
						}
					}
				}
				idx++;
				if (outcount == 3) {
					break;
				}
			}
		}
		temp = max(temp, answer);


	} while (next_permutation(abc.begin(), abc.end()));
	cout << temp;
}
