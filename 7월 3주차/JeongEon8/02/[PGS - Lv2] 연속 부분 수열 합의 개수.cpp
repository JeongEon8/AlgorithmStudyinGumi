#include <string>
#include <vector>
#include <set>

using namespace std;

int solution(vector<int> elements) {
    int answer = 0;
    int start = 0, end = 0;
    set<int> sums;
    
    for(int i = 0; i < elements.size(); ++i)
    {
        int sum = 0;
        for(int j = i; j < i+elements.size(); ++j)
        {
            int idx = j % elements.size();
            sum += elements[idx];
            sums.emplace(sum);
        }
    }
    
    answer = sums.size();
    
    return answer;
}
