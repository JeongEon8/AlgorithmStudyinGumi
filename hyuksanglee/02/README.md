# [PGS - Lv2] 02_의상

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 해시 테이블, 조합

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 옷의 종류에 개수를 알아내기 위해 map을 사용해서 종류의 개수를 파악함
   ```
   for(const [name, type] of clothes){
        map[type] = (map[type] || 0) +1;
    }
   ```
2. 수학 식을 이용하여 각 종류의 개수에 +1을 해주고 곱해준다.
   {(A + 1)*(B + 1) * ... } -1 

   ```
    for(const count of Object.values(map)){
        answer *= (count+1)   
    }
   ```
3. 출력할때 -1해주어서 뽑아준다.

## :black_nib: **Review**

- 수학문제?

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=javascript
