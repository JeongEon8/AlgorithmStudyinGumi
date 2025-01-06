// 1904. 01타일

#include <iostream>
#include <vector>

using namespace std;

int N;
vector<long long> result = { 0, 1, 2 };

void makeBinary(string binary) {
    long long tmp;
    for (int i = 3; i <= N; i++) {
        tmp = 0;
        tmp = result[i - 1] + result[i - 2];
        result.push_back(tmp % 15746);
    }
}

int main(void) {
	cin >> N;

	makeBinary("");

    cout << result[N] % 15746;

	return 0;
}
