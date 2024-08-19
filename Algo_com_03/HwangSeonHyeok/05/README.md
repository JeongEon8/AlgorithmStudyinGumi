# [백준 - g5] 28449. 누가 이길까

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- 구현
- 정렬
- 누적합
- ~~이분 탐색~~

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

오름 차순으로 정렬 후 큰쪽의 승수 누적합에 작은쪽의 index만큼 더해주고 작은 쪽 index를 증가시켜 다음 수가 오게 하는 식으로 승수를 계산한다.  
무승부가 나오는 상황에선 서로 같은수의 개수를 count하고 곱해줘서 무승부 대결수를 구하고 무승부 누적합엥 더해준다.  
한쪽팀의 index가 범위를 초과하면 반대쪽 남은 팀원들은 초과한팀의 모든 팀원을 이길수 있으므로 이를 처리해준다.

```cpp
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

```

## :black_nib: **Review**

- 반례를 찾는데 시간을 한참 썼는데 long long타입이 필요한 문제였다.
- 문제 자체의 알고리즘 분류는 이분 탐색인데 시뮬레이션에 가깝게 구현하였다.

## 📡**Link**

- https://www.acmicpc.net/problem/28449
