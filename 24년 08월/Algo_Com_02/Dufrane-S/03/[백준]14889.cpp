#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
using namespace std;


int main() {
    int answer = INT_MAX;
    int n;
    cin >> n;
    int box[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int a;
            cin >> a;
            box[i][j] = a;
        }
    }
    vector<int>v;
    for(int i=0;i<n/2;i++){
        v.push_back(1);
        v.push_back(0);
    }

    sort(v.begin(), v.end());

    do{
        vector<int>start;
        int ssum=0;
        vector<int>link;
        int lsum=0;
        for(int i=0;i<v.size();i++){
            if(v[i]){
                link.push_back(i);
            }else{
                start.push_back(i);
            }
        }
        for(auto i:start){
            for(auto j:start){
                ssum+=box[i][j];
            }
        }
        for(auto i:link){
            for(auto j:link){
                lsum+=box[i][j];
            }
        }
        answer=min(answer,abs(lsum-ssum));
    }while(next_permutation(v.begin(), v.end()));
    cout<<answer;
}
