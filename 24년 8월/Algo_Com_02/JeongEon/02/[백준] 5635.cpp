// 백준
// 실버 5
// 5635. 생일

#include <iostream>
#include <vector>

using namespace std;

struct student {
	int year;
	int month;
	int day;
	string name;
};

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	
	student max;
	max.name = "";
	max.year = 1990;
	max.month = 1;
	max.day = 1;

	student min;
	min.name = "";
	min.year = 2010;
	min.month = 12;
	min.day = 31;
		;
	for (int i = 0; i < n; i++) {
		int day, month, year;
		string name;
		cin >> name >> day >> month >> year;
		if (max.year < year) {
			max.name = name;
			max.year = year;
			max.month = month;
			max.day = day;
		}
		else if (max.year == year) {
			if (max.month < month) {
				max.month = month;
				max.day = day;
				max.name = name;
			}
			else if (max.month == month) {
				if (max.day < day) {
					max.day = day;
					max.name = name;
				}
			}
		}

		if (min.year > year) {
			min.name = name;
			min.year = year;
			min.month = month;
			min.day = day;		
		}
		else if (min.year == year) {
			if (min.month > month) {
				min.month = month;
				min.day = day;
				min.name = name;
			}
			else if (min.month == month) {
				if (min.day > day) {
					min.day = day;
					min.name = name;
				}
			}
		}
	}

	cout << max.name << endl;
	cout << min.name << endl;

	return 0;
}
