#include <iostream>
using namespace std;

int main()
{
	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int x, y, xcnt=0,ycnt=0, time = 0;
	cin >> x >> y;
	while (1) {
		time++;
		if (time%x == 0 && time%y == 0) {
			cout << 3;
			xcnt++;
			ycnt++;
		}
		else if (time%x == 0) {
			cout << 2;
			ycnt++;

		}
		else if (time%y == 0) {
			cout << 1;
			xcnt++;
		}
		if (ycnt == y && xcnt == x) {
			break;
		}
		
	}

}
