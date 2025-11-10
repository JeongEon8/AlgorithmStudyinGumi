#include <iostream>
using namespace std;

int main() {
    int a1, a0;
    cin >> a1 >> a0;

    int c;
    cin >> c;

    int n0;
    cin >> n0;

    if (a1*n0 + a0 <= c*n0 && a1 <= c)
        cout << 1;
    else
        cout << 0;

    
    return 0;
}