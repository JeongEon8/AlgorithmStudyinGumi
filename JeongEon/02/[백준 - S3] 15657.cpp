#include <iostream>
#include <algorithm>

using namespace std;
#define MAX 9

int N,M;
int first[MAX];
int arr[MAX];

void dfs(int num, int k) {
    if(k==M) {
        for(auto i =0;i<M;i++)
            cout << arr[i] << " ";
        cout << "\n";
    } else {
        for(auto i = num; i < N; i++) {
            arr[k]=first[i];
            dfs(i, k+1);
        }
    }
}

int main(void) {
    cin >> N >> M;

    for(int i=0;i<N;i++)
        cin >> first[i];
    
    sort(first,first+N);

    dfs(0, 0);
}
