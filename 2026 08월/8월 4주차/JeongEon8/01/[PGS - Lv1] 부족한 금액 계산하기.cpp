#include <cmath>

using namespace std;

long long solution(int price, int money, int count)
{
    long long answer = -1;
    long long sum = 0;    
    
    for(int i = 1; i <= count; i++){
        sum += price * i;
    }
    
    if(money > sum){
        answer = 0;
    }
    else{
        answer = abs(money - sum);        
    }

    return answer;
}
