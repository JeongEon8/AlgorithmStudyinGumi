#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n,m;
vector<int> budget;

int main() {
    cin >> n;
    for(auto i=0;i<n;i++) {
        int x;
        cin>>x;
        budget.push_back(x);
    }
    cin>> m;

    sort(budget.begin(),budget.end());

    int start=0;
    int end= budget[n-1];
    int result,sum;
    
    while(start<=end) {
        sum=0;
        int mid = (start+end)/2;
        for(auto i=0; i<n;i++) {
            sum += min(budget[i],mid);
        }
        if(m>=sum) {
            result=mid;
            start=mid+1;
        }else {
            end=mid-1;
        }
    }

    cout << result;
}
