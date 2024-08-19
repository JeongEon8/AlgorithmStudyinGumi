#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool compare(string A, string B){
    if(A.length() == B.length()){
        for(int i = 0; i < A.length(); i++){
            if(A[i] == B[i]){
                continue;
            }
            return A[i] < B[i];
        }    
    }
    
    return A.length() < B.length();
}

int main(void){
    int T;
    cin >> T;

    for(int tc = 1; tc <= T; tc++){
        int N;
        cin >> N;

        vector<string> name;
        for(int i = 0; i < N; i++){
            string input;
            cin >> input;
            name.push_back(input);
        }
        
        sort(name.begin(), name.end(), compare);

        cout << "#" << tc << '\n';
        cout << name[0] << '\n';
        string temp = name[0];
        for(int i = 1; i < name.size() ; i++){
            if(temp == name[i]){
                continue;
            }
            temp = name[i];
            cout << name[i] << '\n';
        }
    }
    return 0;
}
