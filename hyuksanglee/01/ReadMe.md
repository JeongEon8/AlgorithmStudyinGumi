# [SWEA - 모의] 2115. 벌꿀채취
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
완전탐색


## :round_pushpin: **Logic**
1. 모든 가능한 벌통 배치마다 최대 수확량 구해주기
``` do {
        int tmp = 0;
        int tmpsum = 0;
        for (auto i : honey1) {
            if (tmp + i <= c) {
                tmp += i;
                tmpsum += i * i;
            }
            else {
                if (sum1 < tmpsum)sum1 = tmpsum;
                continue;
            }
        }
        if (sum1 < tmpsum)sum1 = tmpsum;
    } while (next_permutation(honey1.begin(), honey1.end()));
    int sum2 = 0;
    do {
        int tmp = 0;
        int tmpsum = 0;
        for (auto i : honey2) {
            if (tmp + i <= c) {
                tmp += i;
                tmpsum += (i * i);
            }
            else {
                if (sum2 < tmpsum)sum2 = tmpsum;
                continue;
            }
            if (sum2 < tmpsum)sum2 = tmpsum;
        }
    } while (next_permutation(honey2.begin(), honey2.end()));
```

## :black_nib: **Review**
- 완탐이 아니라 DP 문제라는데;



## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu
