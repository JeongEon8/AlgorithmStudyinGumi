# [PGS - Lv2] 02_모음 사전

## ⏰**time**

-20분

## :pushpin: **Algorithm**

- dfs

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. dfs를 사용해서 하나씩 단어를 넣어주고 5개 이상이면 그다음 단어를 넣어준다.
   ```
   function dfs(word, total, count){
    if(word===total){
        return [true,count];
    }
    if(total.length===5){
        return [false,count];
    }
    for(const w of alpa){
        const result = dfs(word,total+w, count+1);
        count = result[1];
        if(result[0]) return [true,count];
    }
    return [false,count];
   ```

## :black_nib: **Review**

- 자바스크립트 쉬우면서도 어렵네

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/84512
