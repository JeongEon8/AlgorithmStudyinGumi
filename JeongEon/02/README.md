# [백준 - S2] 2805. 나무 자르기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
반복..?

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 자를 지점을 중간값으로 정한다.
2. 자르고 남은 나무가 있다면 모두 합해준다.
3. 원래 가져가고자 했던 길이보다 많거나 같으면 low를 더 올린다.
```cpp
    while(low <= high){ 
        long long sum = 0;
        long long cut = (low + high) / 2;
        
        for(int i = 0; i < n; i++) {
            if(tree[i] - cut > 0){
                sum += tree[i] - cut; 
            }  
        }
        
        if(sum >= m){ 
            max = cut;
            low = cut + 1; 
        } else{
            high = cut - 1;
        }
    }
```

## :black_nib: **Review**
- 나무 잘라유~
## 📡 Link
https://www.acmicpc.net/problem/2805
