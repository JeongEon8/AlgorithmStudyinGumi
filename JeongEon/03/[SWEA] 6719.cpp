#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int T;
    cin >> T;

    for(int tc = 1; tc <= T; tc++){
        int N, K;
        cin >> N >> K;

        vector<double> video;
        for(int i = 0; i < N; i++){
            int M;
            cin >> M;
            video.push_back(M);
        }

        double A = 0;

        sort(video.begin(), video.end());

        for(int i = N-K; i < N; i++){
            if(A < video[i]){
                A = (double) (A + video[i])/2;
            }
        }

        cout << "#" << tc << " ";
        cout << fixed;
        cout.precision(6);
        cout << A << '\n';
    }
    
    return 0;
}
