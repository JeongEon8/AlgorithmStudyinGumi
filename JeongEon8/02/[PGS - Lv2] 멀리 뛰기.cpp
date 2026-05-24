#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
    long long answer = 0;
    long long run[2000];
    
    run[0] = 0;
    run[1] = 1;
    run[2] = 2;
    
    for(int i = 3; i <= n; i++){
        run[i] = (run[i-1] + run[i-2]) %1234567;
    }
        
    answer = run[n];
    
    return answer;
}
