#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    if(n == 1){
        return 1;
    }
    else if(n==2){
        return 2;
    }
    
    int prev = 1;
    int tmp = 2;
    
    for(int i = 3; i <= n; i++) {
        answer = (prev + tmp) % 1000000007;
        prev = tmp;
        tmp = answer;
    }
    
    return answer;
}
