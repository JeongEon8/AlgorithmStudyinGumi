#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    
    int big, small;
    if(a > b){
        big = a;
        small = b;
    }
    else{
        big = b;
        small = a;
    }
    
    for(int i = small; i <= big; i++){
        answer += i;
    }
    
    return answer;
}
