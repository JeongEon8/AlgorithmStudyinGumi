#include <iostream>
using namespace std;
 
int main() {
    int T;
    cin >> T;
 
    while (T--) {
        int N, M;
        cin >> N >> M;
 
        int a, b;
        while (M--) {
            cin >> a >> b;
        }
 
        cout << N - 1 << endl;
    }
    
    return 0;
}
