# [PGS - lv2] 04.타겟 넘버

## ⏰**time**

20분

## :pushpin: \*\*Algorith

- dfs

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. dfs를 이용해서 +, - 한번씩 넣어서 구하고 마지막에 target이랑 비교해서 같으면 카운트 해준다.

```java
           public void dfs(int depth, int total, int len, int target, int[] numbers){
        if(depth>=len){
            if(total==target){
                count++;
            }
            return;
        }
        
        dfs(depth+1, total + numbers[depth], len, target, numbers);
        dfs(depth+1, total - numbers[depth], len, target, numbers);
        
        
        
    }
```



## :black_nib: **Review**

## 📡 Link
<https://school.programmers.co.kr/learn/courses/30/lessons/43165>
