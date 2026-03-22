#include <iostream>
using namespace std;

int dp[200000];
int min_num;

int main (){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int t, x;
    cin >> t;
    for(int i=0; i < t; i++){
        cin >> x;
        if( i==0 ) {
            dp[0] = 0;
            min_num = x;}
        else {
            if ( x < min_num ) { min_num = x;}
            dp[i] = (x-min_num) > dp[i-1] ? (x-min_num) : dp[i-1];
        }
        cout << dp[i] << " " ;

    }
}
