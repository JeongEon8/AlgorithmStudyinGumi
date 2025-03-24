#include<iostream>

using namespace std;

int main(){
    int e,s,m;
    int count = 0;
    int re = 0;
    int rs = 0;
    int rm = 0;
    
    cin >> e >> s >> m;
    
    while(1){
        if(re == 16){
            re = 1;
        }
        if(rs == 29){
            rs = 1;
        }
        if(rm == 20){
            rm = 1;
        }
        if(re == e & rs == s & rm == m){
            cout << count;
            break;

        }
        re++;
        rs++;
        rm++;
        count++;
    }
    
    return 0;
}
