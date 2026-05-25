#include <iostream>

using namespace std;

int solution(int n) {
    int ans = 0;
    
    do {
        if(n%2 != 0) {
            ans++;
            n -= 1;
        }
        else {
            n /= 2;
        }
    } while(n > 0);
    
    return ans;
}
