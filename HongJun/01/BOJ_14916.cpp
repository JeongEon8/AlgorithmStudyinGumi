#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int cnt = 0;

    cnt += (n / 5);
    
    if ((n % 5)%2 != 0) {
        int tmp = (n%5 + 5)/2;
        cnt += (tmp - 1);
    } else {
        int tmp = (n%5)/2;
        cnt += tmp;
    }
    if (n == 3 or n == 1) cnt = -1;
    cout << cnt;
    
    return 0;
}