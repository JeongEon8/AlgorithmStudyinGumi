#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    
    int smallest = 0;
    int size = arr.size();
    
    for(int i = 0; i < size; i++){
        if(arr[smallest] > arr[i]){
            smallest = i;
        }
    }
    
    arr.erase(arr.begin() + smallest);
    if(arr.empty()){
        arr.push_back(-1);
    }
    
    answer = arr;
    
    return answer;
}
