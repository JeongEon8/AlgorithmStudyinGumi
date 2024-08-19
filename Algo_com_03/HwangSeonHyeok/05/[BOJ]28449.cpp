#include <iostream>
#include <algorithm>
using namespace std;


int hi[100001] = { 0, };
int arc[100001] = { 0, };
long long hiWin[100001] = { 0, };
long long arcWin[100001] = { 0, };
long long draw = 0;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        cin >> hi[i];
    }

    for (int j = 1; j <= m; j++) {
        cin >> arc[j];
    }

    sort(hi, hi + (n + 1));
    sort(arc, arc + (m + 1));

    int hiIdx = 1;
    int arcIdx = 1;
    while (1) {
        if (hiIdx > n) {
            for (; arcIdx <= m; arcIdx++) {
                arcWin[arcIdx] = arcWin[arcIdx - 1] + n;
            }
            break;
        }
        else if (arcIdx > m) {
            for (; hiIdx <= n; hiIdx++) {
                hiWin[hiIdx] = hiWin[hiIdx - 1] + m;
            }
            break;
        }

        if (hi[hiIdx] > arc[arcIdx]) {
            hiWin[hiIdx] = hiWin[hiIdx - 1] + arcIdx;
            arcWin[arcIdx] = arcWin[arcIdx - 1] + hiIdx - 1;
            arcIdx++;
        }
        else if (hi[hiIdx] < arc[arcIdx]) {
            arcWin[arcIdx] = arcWin[arcIdx - 1] + hiIdx;
            hiWin[hiIdx] = hiWin[hiIdx - 1] + arcIdx - 1;
            hiIdx++;
        }
        else {
            int tmp = hi[hiIdx];
            int tmphiIdx = hiIdx;
            int tmparcIdx = arcIdx;
            long long cnthi = 0;
            long long cntarc = 0;
            while (hi[hiIdx] == tmp && hiIdx <= n) {
                cnthi++;
                hiWin[hiIdx] = hiWin[hiIdx - 1] + tmparcIdx - 1;
                hiIdx++;
            }
            while (arc[arcIdx] == tmp && arcIdx <= m) {
                cntarc++;
                arcWin[arcIdx] = arcWin[arcIdx - 1] + tmphiIdx - 1;
                arcIdx++;
            }
            draw += cnthi * cntarc;

        }

    }
    cout << hiWin[n] << " " << arcWin[m] << " " << draw;





}