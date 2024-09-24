#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main(void) {
	int K;
	cin >> K;
	
	for (int Class = 1; Class <= K; Class++) {
		int N;
		cin >> N;

		vector<int> student;
		for (int i = 0; i < N; i++) {
			int score;
			cin >> score;
			student.push_back(score);
		}

		sort(student.begin(), student.end(), greater<>());

		int maxi = student[0];
		int min = student[N-1];
		int gap = 0;

		for (int i = 0; i < N - 1; i++) {
			gap = max(abs(student[i] - student[i + 1]), gap);
		}

		cout << "Class " << Class << endl;
		cout << "Max " << maxi << ", Min " << min << ", Largest gap " << gap << endl;
	}

	return 0;
}
