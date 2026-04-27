#include <iostream>

using namespace std;

int N, M, J;

int main(void) {
    cin >> N >> M >> J;

    int cnt=0;

    int start=1, end = M;

    while(J--) {
        int x;
        cin >> x;

        bool flag=true;
        while(flag) {
            if(start<=x && x<=end) {
                flag=false;
            } else if(start>x){
                start--; end--; cnt++;
            } else {
                start++; end++; cnt++;
            }
        }
    }

    cout << cnt;
    
    return 0;
}
