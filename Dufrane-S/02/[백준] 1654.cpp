#include <iostream>
#include <vector>
using namespace std;

int main(void){
    long long n,m;
    cin>>n>>m;
    vector<int>v;
    long long a;
    long long end=0;
    for(int i=0;i<n;i++){
        cin>>a;
        v.push_back(a);
        if(end<a)end=a;
    }
    long long start=1;
    long long count;
    while(end>=start){
        long long mid=(start+end)/2;
        count=0;
        for(auto i:v){
            count+=i/mid;
        }
        if(count<m){
            end=mid-1;
        }else if(count>m){
            start=mid+1;
        }else if(count==m){
            start=mid+1;
        }

    }
    cout<<end;
}
