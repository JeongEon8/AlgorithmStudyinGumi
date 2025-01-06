# [SWEA - D3] 6485. 삼성시의 버스 노선
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
배열


## :round_pushpin: **Logic**
1. 정류장만큼 배열을 만들어 준 뒤 입력받은 노선 정보를 바탕으로 정류장을 지나는 노선을 체크해서 추가
```#include <iostream>
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
```
