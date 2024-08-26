#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;

    int sizes[6];
    for (int i = 0; i < 6; i++)
    {
        cin >> sizes[i];
    }
    int t, p;
    cin >> t >> p;

    int result_t = 0;
    for (int i = 0; i < 6; i++)
    {
        if (sizes[i]%t == 0) {
            result_t += sizes[i]/t;
        } else {
            result_t += sizes[i]/t + 1;
        }
    }
    cout << result_t << endl;
    cout << (N / p) << " " << (N % p) << "\n";
}