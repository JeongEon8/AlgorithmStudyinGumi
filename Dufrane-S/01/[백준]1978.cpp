#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	int n;
	cin >> n;
	int box[6];
	for (int i = 0; i < 6; i++) {
		int a;
		cin >> a;
		box[i] = a;
	}
	int c,p;
	cin >> c >> p;
	int cresult=0, pa, pb;
	for (auto i : box) {
		if (i > (i / c)*c) {
			cresult += ((i / c) + 1);
		}else if(i==(i/c)*c) {
			cresult += i / c;
		}
	}
	pa = n / p;
	pb = n % p;
	cout << cresult << '\n' << pa << ' ' << pb;
}
