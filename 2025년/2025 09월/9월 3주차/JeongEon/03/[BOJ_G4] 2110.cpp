#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> Houses;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, C;
	cin >> N >> C;

	Houses.reserve(N);
	for (int i = 0; i < N; ++i)
	{
		int X;
		cin >> X;
		Houses.emplace_back(X);
	}

	sort(Houses.begin(), Houses.end());

	int Solution = 0;
	int Left = 0;
	int Right = Houses.back();
	while (Left <= Right)
	{
		int Mid = (Left + Right) / 2;
		int Count = 1;

		int Distance = 0;
		for (int i = 1; i < N; ++i)
		{
			Distance += Houses[i] - Houses[i - 1];

			if (Distance >= Mid)
			{
				Distance = 0;
				++Count;
			}
		}

		if (Count >= C)
		{
			Solution = Mid;
			Left = Mid + 1;
		}
		else
		{
			Right = Mid - 1;
		}
	}

	cout << Solution;
    
    return 0;
}
