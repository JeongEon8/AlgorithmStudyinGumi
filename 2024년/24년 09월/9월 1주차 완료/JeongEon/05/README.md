# [소프티어 - Lv2] 6283. 8단 변속기
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
수학(절댓값)

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 두 수의 차의 절댓값이 1이 아니면 mixed
2. -1이면 descending
3. 1이면 ascending
```cpp
    for(int i = 0; i < 8; i++){
        cin >> arr[i];

        if(i > 0){
            if(abs(arr[i] - arr[i - 1]) != 1){
                cout << "mixed" << endl;
                return 0;
            }
            else{
                if(arr[i] - arr[i-1] < 0){
                    decrease = true;
                    increase = false;
                }
                else{
                    increase = true;
                    decrease = false;
                }
            }
        }
    }
```

## :black_nib: **Review**


## 📡 Link
https://softeer.ai/practice/6283
