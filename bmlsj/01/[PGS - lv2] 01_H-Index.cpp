#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> citations)
{

    sort(citations.begin(), citations.end());

    int n = citations.size();

    for (int i = 0; i < n; i++)
    {
        int remains = n - i;

        if (citations[i] >= remains)
        {
            return remains;
        }
    }
    return 0;
}