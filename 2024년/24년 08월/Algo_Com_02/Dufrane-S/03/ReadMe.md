# [백준 - S1] 14889. 스타트와 링크
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
완전탐색, 조합


## :round_pushpin: **Logic**
1. next_permutaion을 활용하여 가능한 뽑을 수 있는 팀을 모두 순회
2. next_permutation 이용적 sort해줘야함에 주의, next_permutation은 중복을 제거해서 제공함에 주의
``#include <iostream>
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
```
