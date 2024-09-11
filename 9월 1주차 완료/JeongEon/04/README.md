# [소프티어 - Lv2] 6288. 금고털이
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 귀금속의 가치가 높은 순으로 정렬한다.
2. 가방에 넣을 수 있는 만큼 담는다.
```cpp
    for(int i = 0; i < metal.size(); i++){
        if(metal[i].first <= W){
            result += metal[i].first * metal[i].second;
            W -= metal[i].first;
        }
        else{
            result += W * metal[i].second;
            W = 0;
        }
    }
```

## :black_nib: **Review**


## 📡 Link
https://softeer.ai/practice/6288
