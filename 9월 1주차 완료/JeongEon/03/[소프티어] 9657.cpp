#include<iostream>

using namespace std;

int main(int argc, char** argv) {
    int n, m;
    cin >> n >> m;

    int arr[100][100];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }

    int L1, R1;
    cin >> L1 >> R1;
    int L2, R2;
    cin >> L2 >> R2;

    int attack1[100] = {0};
    for(int i= L1-1; i<R1;i++){
        attack1[i]=1;
    }

    int attack2[100] = {0};
    for(int i = L2 - 1; i < R2; i++){
        attack2[i]=1;
    }

    for(int i = 0; i < m; i++){
        for(int j = L1-1; j < R1; j++){
            if(attack1[j] == 1 && arr[j][i] == 1){
                arr[j][i] = 0;
                attack1[j] = 0;
            }
        }

        for(int j = L2 - 1; j < R2; j++){
            if(attack2[j] == 1 && arr[j][i] == 1){
                arr[j][i] = 0;
                attack2[j] = 0;
            }
        }
    }

    int result = 0;
    for(int i = 0; i < n ;i++){
        for(int j = 0; j < m; j++){
            if(arr[i][j] == 1){
                 result++;   
            }
        }
    }

    cout << result;
    
   return 0;
}
