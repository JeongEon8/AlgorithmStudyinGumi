#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int t;

int main(void) {
    cin >> t;
 
    for(int x=0; x<t; x++) {
        int n,m;
        cin >> n >> m;
 
        vector<int>v1(n);
        vector<int>v2(m);
 
        for(int x=0; x<n; x++) {
            cin >> v1[x];
        }
        for(int x=0; x<m; x++) {
            cin >> v2[x];
        }
        
        int cnt=0;
 
        sort(v1.begin(),v1.end());
        sort(v2.begin(),v2.end());
 
        for(int y=0; y<n; y++) {
            for(int x=0; x<m; x++) {
                if(v1[y] > v2[x]) {
                    cnt++;
                }
                else{
                  break;  
                }
            }
        }
        
        cout << cnt <<"\n";
    }
 
    return 0;
}
