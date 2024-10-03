
#include <iostream>
#include <algorithm>
#include <string>
#include <map>
#include <vector>
using namespace std;
map<char, int> m;
bool cmp(string a, string b) {
	if (a[0] == b[0]) {
		int scoreA = stoi(a.substr(1, a.size() - 1));
		int scoreB = stoi(b.substr(1, b.size() - 1));
		return scoreA > scoreB;
	}
	else {
		return m[a[0]] < m[b[0]];
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	m['B'] = 0;
	m['S'] = 1;
	m['G'] = 2;
	m['P'] = 3;
	m['D'] = 4;
	vector<string> vec, sortedVec, ans;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		vec.push_back(str);
		sortedVec.push_back(str);
	}

	sort(sortedVec.begin(), sortedVec.end(), cmp);
	for (int i = 0; i < n; i++) {
		if (vec[i] != sortedVec[i]) {
			ans.push_back(vec[i]);
		}
	}
	if (ans.size() == 0) {
		cout << "OK";
	}
	else {
		cout << "KO" << '\n';
		cout << ans[1] << ' ' << ans[0];
	}
	
}