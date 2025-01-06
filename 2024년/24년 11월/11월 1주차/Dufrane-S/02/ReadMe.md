# [BOJ - G5] 2096. 내려가기
 
## ⏰  **time**
70분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 메모리 공간이 작음, 3칸짜리 배열을 이용해 dp
```
 for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                sNext[j] = tmp;
                lNext[j] = tmp;
            }
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    int large = Integer.MIN_VALUE;
                    int small = Integer.MAX_VALUE;
                    for (int k = 0; k < 2; k++) {
                        if (large < lList[k]) large = lList[k];
                        if (small > sList[k]) small = sList[k];
                    }
                    lNext[j] += large;
                    sNext[j] += small;

                } else if (j == 1) {
                    int large = Integer.MIN_VALUE;
                    int small = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; k++) {
                        if (large < lList[k]) large = lList[k];
                        if (small > sList[k]) small = sList[k];
                    }
                    lNext[j] += large;
                    sNext[j] += small;
                } else if (j == 2) {
                    int large = Integer.MIN_VALUE;
                    int small = Integer.MAX_VALUE;
                    for (int k = 1; k < 3; k++) {
                        if (large < lList[k]) large = lList[k];
                        if (small > sList[k]) small = sList[k];
                    }
                    lNext[j] += large;
                    sNext[j] += small;
                }

            }
            for (int k = 0; k < 3; k++) {
                sList[k] = sNext[k];
                lList[k] = lNext[k];
            }
            
        }
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (lList[i] > large) large = lList[i];
            if (sList[i] < small) small = sList[i];
        }
```
## :black_nib: **Review**



## 📡**Link**
https://www.acmicpc.net/problem/2096
