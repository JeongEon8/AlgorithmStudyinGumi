#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_set>
using namespace std;
 
 
int main() {
    int ctn;
    cin>>ctn;
    for(int ct=1;ct<=ctn;ct++){
        int n;
        cin>>n;
        string s;
        cin>>s;
        vector<string>v;
        unordered_set<string>set;
 
        for(int i=0;i<s.size();i++){
            string tmp ="";
            for(int j=i;j<s.size();j++){
                tmp+=s[j];
                if(!set.count(tmp)){
                    v.push_back(tmp);
                    set.insert(tmp);
                }
            }
        }
 
        if(n>v.size()){
            cout << '#' << ct << " none" << v[n] << '\n';
        }else {
            sort(v.begin(), v.end());
            cout << '#' << ct << ' ' << v[n-1] << '\n';
        }
    }
}
