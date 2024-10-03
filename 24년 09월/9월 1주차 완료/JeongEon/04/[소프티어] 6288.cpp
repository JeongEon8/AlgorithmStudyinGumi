#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b){
    return a.second > b. second;
}

int main(int argc, char** argv) {
    int W, N;
    cin >> W >> N;

    vector<pair<int, int>> metal;
    for(int i = 0; i < N; i++){
        int M, P;
        cin >> M >> P;
        metal.push_back({M, P});
    }

    sort(metal.begin(), metal.end(), compare);

    int result = 0;
    for(int i = 0; i < metal.size(); i++){
        if(metal[i].first <= W){
            result += metal[i].first * metal[i].second;
            W -= metal[i].first;
        }
        else{
            result += W * metal[i].second;
            W = 0;
        }
    }

    cout << result;
    
   return 0;
}
