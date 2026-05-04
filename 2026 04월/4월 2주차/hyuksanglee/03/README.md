# [백준 - G5] 5582. 공통 부분 문자열

## ⏰ **time**

55분

## :pushpin: **Algorithm**

- dp

## ⏲️**Time Complexity**

$O((N-1) \times (N-1)!)$

## :round_pushpin: **Logic**

- 두문자를 한번씩 탐색해서 같으면 이전값에서 +1해준다
- 같지 않을경우 0으로 초기화

```kotlin
	for(i in 1..sLen){
        for(j in 1 .. tLen){
            if(s[i-1] == t[j-1]){
                array[i][j] = array[i-1][j-1]+1
                if(array[i][j]>result){
                    result = array[i][j]
                }
            }else{

                array[i][j]=0

            }
        }
    }
```


## :black_nib: **Review**

## 📡**Link**
https://www.acmicpc.net/problem/5582
