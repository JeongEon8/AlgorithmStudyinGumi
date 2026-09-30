#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(int x) {
    bool answer = true;
    
    int sum = 0;
    int divid = 10000;
    int num = x;
    
    while(x/divid == 0)
    {
        divid /= 10;
    }
    
    while(divid >= 1)
    {
        sum += num / divid;
        num %= divid;
        divid /= 10;
    }
    
    if(x % sum != 0)
    {
        answer = false;
    }
    
    return answer;
}
