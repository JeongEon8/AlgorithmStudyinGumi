#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;
    
    vector<int> v(N), answer(N);
    for(int i = 0; i < N; i++){
        cin >> v[i];
    }
    
    for(int i = 0; i < N; i++){
        int j = 0;
        while(v[i] != 0){
            if(answer[j] == 0){
                v[i]--;
            }
            j++;
        }
        while(answer[j] != 0){
            j++;
        }
        answer[j] = i + 1;
    }
    
    for(int i = 0; i < N; i++){
        cout << answer[i] << ' ';
    }
    
    return 0;
}
