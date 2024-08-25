#include <iostream>
#include <vector>
 
using namespace std;
 
 
int main() {
    int asdf;
    cin >> asdf;
    for (int tc = 1; tc <= asdf; tc++) {
        int n;
        cin >> n;
        vector<int>bus(5001,0);
        for (int i = 0; i < n; i++) {
            int a, b;
            cin >> a >> b;
            for(int j=a;j<=b;j++){
                bus[j]++;
            }
        }
        cout << '#' << tc << ' ';
        int p;
        cin>>p;
        for(int i=0;i<p;i++){
            int a;
            cin>>a;
            cout<<bus[a]<<' ';
        }
        cout<<'\n';
//        cout << '#' << tc << ' ' << answer << '\n';
 
    }
}
