#include <iostream>
using namespace std;

int N, K;
int gold[1001];
int silver[1001];
int bronze[1001];
int res = 1;

int main() {

    //입력
    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        int index;
        cin >> index;
        cin >> gold[index] >> silver[index] >> bronze[index];
    }

    //1번 국가부터 N번 국가까지 K번 국가보다 더 잘한 국가일 경우 res++
    for (int i = 1; i <= N; i++) {
        if (gold[i] > gold[K]) {
            res++;
        }
        else if (gold[i] == gold[K]) {
            if (silver[i] > silver[K]) {
                res++;
            }
            else if (silver[i] == silver[K]) {
                if (bronze[i] > bronze[K]) {
                    res++;
                }
            }
        }
    }

    //출력
    cout << res;
}
