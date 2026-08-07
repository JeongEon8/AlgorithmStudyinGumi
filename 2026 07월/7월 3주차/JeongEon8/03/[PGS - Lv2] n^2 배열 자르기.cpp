#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;

    for(long long i = left; i <= right; ++i) {
        long long x = i / n;
        long long y = i % n;
        if(x < y) answer.push_back(y + 1);
        else answer.push_back(x + 1);
    }
    return answer;
}
