#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct Student {
	string name = "";
	int kr = 0, en = 0, math = 0;
};

int N;
vector<Student> arr;

bool cmp(Student a, Student b) {
	if (a.kr == b.kr && a.en == b.en && a.math == b.math) {
		return a.name < b.name;
	}
	else if (a.kr == b.kr && a.en == b.en) {
		return a.math > b.math;
	}
	else if (a.kr == b.kr) {
		return a.en < b.en;
	}

	return a.kr > b.kr; // 국어는 감소하는 순으로
}

void print() {
	for (int i = 0; i < N; i++) {
		cout << arr[i].name << '\n';
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;


	for (int i = 0; i < N; i++) {
		Student student;
		cin >> student.name >> student.kr >> student.en >> student.math;
		arr.push_back(student);
	}

	sort(arr.begin(), arr.end(), cmp);
	print();

	return 0;
}
