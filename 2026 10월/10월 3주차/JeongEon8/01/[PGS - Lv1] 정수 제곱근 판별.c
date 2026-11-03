#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(long long n) {
    long long answer = 0;
    long long a = sqrt(n);
    if (a*a == n) {	
        answer=pow(a+1,2);
    }
    else {	
        answer=-1;
    }
    return answer;
}
