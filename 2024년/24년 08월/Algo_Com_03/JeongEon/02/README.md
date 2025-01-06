# [SWEA - D4] 7701. 염라대왕의 이름 정렬
 
## ⏰  **time**

10분
  
## :pushpin: **Algorithm**

정렬
  
## ⏲️**Time Complexity**

$O(NlogN)$
    
## :round_pushpin: **Logic**
- sort의 compare을 만들어서 정렬했다.
  1. string 길이가 짧은 순
  2. 길이가 같다면 알파벳이 다를 때 알파벳이 작은 순

```cpp
bool compare(string A, string B){
    if(A.length() == B.length()){
        for(int i = 0; i < A.length(); i++){
            if(A[i] == B[i]){
                continue;
            }
            return A[i] < B[i];
        }    
    }
    
    return A.length() < B.length();
}
```
  
## :black_nib: **Review**

- 정렬 조아
  
## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AWqU0zh6rssDFARG&categoryId=AWqU0zh6rssDFARG&categoryType=CODE&problemTitle=&orderBy=SUBMIT_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=3
