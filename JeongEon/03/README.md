# [SWEA - D4] 7701. 염라대왕의 이름 정렬
 
## ⏰  **time**

10분
  
## :pushpin: **Algorithm**

정렬
  
## ⏲️**Time Complexity**

$O(NlogN)$
    
## :round_pushpin: **Logic**
- sort오름차순으로 정렬 후
  1. A보다 큰 비디오를 (A + M)/2 하여 A에 저장한다.

```cpp
        sort(video.begin(), video.end());

        for(int i = N-K; i < N; i++){
            if(A < video[i]){
                A = (double) (A + video[i])/2;
            }
        }
```
  
## :black_nib: **Review**

- 정렬 조아
  
## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AWd7sgDatsMDFAUh&categoryId=AWd7sgDatsMDFAUh&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=3
