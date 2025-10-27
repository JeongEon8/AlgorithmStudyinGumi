#include <iostream>
#include <cstring>

using namespace std;

int N;
int* T; 
int* P; 
int* dp; 

void input(void){
    cin >> N;
    
    T = new int[N + 1];
    P = new int[N + 1];
    dp = new int[N + 1];
    
    fill(dp, dp + N + 1, 0);
    
    for(int i = 0; i < N; i++) {
        cin >> T[i] >> P[i];
    }
}

void solution(void){
    int max_pay = 0; 
    
    for(int i = 0; i <= N; i++) {
        dp[i] = max(max_pay, dp[i]);
        
        if (T[i] + i <= N) {
            dp[T[i] + i] = max(dp[T[i] + i], P[i] + dp[i]);
        }
        
        max_pay = max(max_pay, dp[i]);
    }
    
    cout << max_pay;
}

int main (void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    input();
    solution();
    
    return 0;
}
