#include <iostream>
#include <string>
#include <set>

using namespace std;

// 전역변수
int N;
set<string> name;

int main(void) {
	cin >> N;

	name.insert("ChongChong");
	for (int i = 0; i < N; i++) {
		string A, B;
		cin >> A >> B;
		
		if (name.find(A) != name.end() || name.find(B) != name.end()) {
			name.insert(A);
			name.insert(B);
		}
	}

	cout << name.size();
	return 0;
}
