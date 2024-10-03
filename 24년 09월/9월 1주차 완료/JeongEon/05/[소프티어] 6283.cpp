#include<iostream>
#include <cmath>

using namespace std;

int main(int argc, char** argv) {
    int arr[8];
    bool increase = true;
    bool decrease = false;
    for(int i = 0; i < 8; i++){
        cin >> arr[i];

        if(i > 0){
            if(abs(arr[i] - arr[i - 1]) != 1){
                cout << "mixed" << endl;
                return 0;
            }
            else{
                if(arr[i] - arr[i-1] < 0){
                    decrease = true;
                    increase = false;
                }
                else{
                    increase = true;
                    decrease = false;
                }
            }
        }
    }

    if(increase){
        cout << "ascending" << endl;
    }
    else if(decrease){
        cout << "descending" << endl;
    }
    
   return 0;
}
