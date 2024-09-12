#include <iostream>
#include <vector>
using namespace std;

int box[101][101];

int n, m;

bool garo(int i) {
	vector<pair<int, int>>v;
	int now = box[i][0];
	pair<int, int>nowp = { now,0 };
	for (int j = 0; j < n; j++) {
		if (now != box[i][j]) {
			now = box[i][j];
			v.push_back(nowp);
			nowp = { now,1 };
		}
		else {
			nowp.second++;
		}
	}
	v.push_back(nowp);
	/*
	for (auto i : v) {
		cout << i.first << " : " << i.second << "   ";
	}cout << '\n';
	*/
	for (int i = 0; i < v.size() - 1; i++) {
		if (abs(v[i].first - v[i + 1].first) >= 2)return false;
		if (v[i].first > v[i + 1].first) {
			if (v[i + 1].second < m) {
				return false;
			}
			else {
				v[i + 1].second -= m;
			}

		}
		else if (v[i].first < v[i + 1].first) {
			if (v[i].second < m) {
				return false;
			}
		}
	}
	//cout << "true\n";
	return true;
}

bool sero(int j) {
	vector<pair<int, int>>v;
	int now = box[0][j];
	pair<int, int>nowp = { now,0 };
	for (int i = 0; i < n; i++) {
		if (now != box[i][j]) {
			now = box[i][j];
			v.push_back(nowp);
			nowp = { now,1 };
		}
		else {
			nowp.second++;
		}
	}
	v.push_back(nowp);
	for (int i = 0; i < v.size() - 1; i++) {
		if (abs(v[i].first - v[i + 1].first) >= 2)return false;
		if (v[i].first > v[i + 1].first) {
			if (v[i + 1].second < m) {
				return false;
			}
			else {
				v[i + 1].second -= m;
			}
		}
		else if (v[i].first < v[i + 1].first) {
			if (v[i].second < m) {
				return false;
			}

		}
	}
	//cout << "true\n";
	return true;
}


int main() {
	int answer = 0;
	cin >> n >> m;
	int a;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a;
			box[i][j] = a;
		}
	}

	for (int i = 0; i < n; i++) {
		if (sero(i))answer++;
		if (garo(i))answer++;
	}
	cout << answer ;
	
}
