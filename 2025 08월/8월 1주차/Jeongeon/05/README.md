# [백준 - 실버 5] 8979. 올림픽

## ⏰  **time**
15분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. result는 1등으로 시작한다.
2. 골드 개수가 나보다 많으면 ++
3. 이하 동일한 로직!
```cpp
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
```

## :black_nib: **Review**
- 문제 풀면서 대탈출2 보고 있는데 와 진짜 너무 재밌다!
- 방탈출 원트해요ㅠ
  
## 📡 Link
https://www.acmicpc.net/problem/8979
