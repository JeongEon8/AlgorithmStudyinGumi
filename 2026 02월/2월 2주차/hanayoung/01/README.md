# [백준 - S3] 1018. 체스판 다시 칠하기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
브루트포스, 구현

## ⏲️**Time Complexity**
$O(N^2*M^2)$

## :round_pushpin: **Logic**
1. 흑은 false, 백은 true로 저장하는 배열 생성. copy는 이후 색칠할 배열
```java
boolean[][] maps = new boolean[N][M]; // false가 흑, true가 백
boolean[][] copy = new boolean[N][M];
```
2. 시작점으로 가능한 지점들까지만 반복문 돌기. i는 N-8까지, j는 M-8까지
3. idx를 둬서 시작점을 바꾸고 시작할 경우 안 바꾸고 시작할 경우를 둬서 두 번 반복
4. 시작점을 바꿀 경우 diff를 증가시키고 copy값도 변경시키기
5. 8*8 보드를 돌며 prev와 체크할 지점이 같으면 diff를 증가시키고 copy배열을 업데이트, prev는 매번 업데이트
6. 한 줄이 끝나면 prev는 copy[i][j]로 업데이트하여 현재줄 시작 j값으로 업데이트하여 비교할 수 있도록 함.
7. answer과 diff를 비교하여 가장 작은 값으로 업데이트
```java
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                int idx = 0;
                while(idx < 2) {
                    int diff = 0;

                    for(int l = 0; l < N; l++) {
                        copy[l] = maps[l].clone();
                    }
                    boolean prev;

                    if(idx == 0) {
                        prev = false;
                        if(prev != maps[i][j]) {
                            copy[i][j] = prev;
                            diff++;
                        }
                    }
                    else {
                        prev = true;
                        if(prev != maps[i][j]) {
                            copy[i][j] = prev;
                            diff++;
                        }
                    }

                    for(int l = i; l < i+8; l++) {
                        for(int k = j; k < j+8; k++) {
                            if(l == i && k == j) continue;
                            if(prev == copy[l][k]) {
                                diff++;
                                prev = !copy[l][k];
                                copy[l][k] = !copy[l][k];
                            }
                            else prev = copy[l][k];
                        }
                        prev = copy[l][j];
                    }
                    answer = Math.min(answer, diff);
                    idx++;
                }
            }
        }
```

## :black_nib: **Review**
- 간단할 줄 알았는데 생각보다 자꾸 꼬였던 문제..! 거기다가 저렇게 다 해봐야 할 줄이야...!

## 📡 Link
https://www.acmicpc.net/problem/1018
