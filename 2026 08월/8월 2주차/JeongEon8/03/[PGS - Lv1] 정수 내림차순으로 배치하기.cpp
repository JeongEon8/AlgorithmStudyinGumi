#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;

    vector<long long> num;
    while(n > 0){
        num.push_back(n%10);
        n /= 10;
    }
    
    sort(num.begin(), num.end());
    
    int size = num.size();
    int ten = 1;
    for(int i = 0; i < size; i++){
        answer += num[i]*ten;
        ten *= 10;
    }
    
    return answer;
}
